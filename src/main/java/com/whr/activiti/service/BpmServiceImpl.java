package com.whr.activiti.service;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BpmServiceImpl implements BpmService {

	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;

	@Autowired
	private RepositoryService rps;

	@Autowired
	private RuntimeService rts;

	@Autowired
	private TaskService ts;

	@Autowired
	private HistoryService hs;

	@Transactional
	@Override
	public String startProcess(String processDefKey, String userId, String businessKey) {
		// 启动流程实例,设置业务号（businessKey,唯一）
		ProcessInstance instance = rts.startProcessInstanceByKey(processDefKey,businessKey);

		// 查找流程当前的任务节点
		Task task = ts.createTaskQuery().processInstanceId(instance.getId()).singleResult();

		// 指定任务所有者
		ts.claim(task.getId(), userId);
		
		// 返回实例id
		return instance.getId();

	}

	@Transactional
	@Override
	public void complete(String pid, String targetUserId) {
		//此处简化处理代码
		//串行任务可以按下面查询，只会有一条记录；但并行任务可能有多条task，需修改处理方式
		Task t = ts.createTaskQuery().processInstanceId(pid).active().singleResult();
		
		if(t == null) {
			throw new ActivitiObjectNotFoundException("未找到活动任务-pid:"+pid);
		}

		// 查找对应task的流程实例id
		String processInstId = t.getProcessInstanceId();

		// 设定流程提交方向变量（前进：forward；退回：backward）
		rts.setVariable(processInstId, "direction", "forward");
		ts.complete(t.getId());

		// 查找流程当前的任务节点
		Task task = ts.createTaskQuery().processInstanceId(processInstId).singleResult();
		// 指定任务所有者
		ts.claim(task.getId(), targetUserId);
	}

	@Transactional
	@Override
	public void back(String taskId, String targetUserId) {
		Task t = ts.createTaskQuery().taskId(taskId).singleResult();

		// 查找对应task的流程实例id
		String processInstId = t.getProcessInstanceId();

		// 设定流程提交方向变量（前进：forward；退回：backward）
		rts.setVariable(processInstId, "direction", "backward");
		ts.complete(taskId);

		// 查找流程当前的任务节点
		Task task = ts.createTaskQuery().processInstanceId(processInstId).singleResult();
		// 指定任务所有者
		ts.claim(task.getId(), targetUserId);

	}

	@Override
	public Map<ProcessInstance,Task> findTasksByUser(String userId) {
		Map<ProcessInstance,Task> result = new HashMap<ProcessInstance,Task>();
		// 指定流程和用户查询task
		List<Task> tasks = ts.createTaskQuery().taskAssignee(userId).list();
		if(tasks != null && tasks.size() > 0) {
			for(Task t : tasks) {
				ProcessInstance pi = rts.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).singleResult();
				result.put(pi, t);
			}
		}
		return result;
	}

	@Override
	public List<HistoricActivityInstance> findProcessHistory(String processInstanceId) {
		// 查找实例的历史办理情况；根据启动时间排序（多条）
		return hs.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
				.orderByHistoricActivityInstanceStartTime().asc().list();
	}

	@Override
	public List<ProcessDefinition> findProcessDefByGroup(String group) {
		// 查找group可启动的流程（可以是多个或一个）
		return rps.createProcessDefinitionQuery().startableByUser(group).list();
	}

	@Override
	public ProcessDefinition findProcessDefByKey(String processDefKey) {
		// 按key查找流程定义（单个记录）
		return rps.createProcessDefinitionQuery().processDefinitionKey(processDefKey).singleResult();
	}

	@Override
	public InputStream generateDiagram(String pid) {
		
		HistoricProcessInstance hInst = hs.createHistoricProcessInstanceQuery().processInstanceId(pid).singleResult();
		
		if(hInst == null) {
			throw new ActivitiObjectNotFoundException("流程实例未找到："+pid);
		}
		BpmnModel bpmnModel = rps.getBpmnModel(hInst.getProcessDefinitionId());
		
		ProcessDiagramGenerator dg = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream resource = dg.generateDiagram(bpmnModel, "png",
				rts.getActiveActivityIds(hInst.getId()), Collections.<String> emptyList(),
				"宋体", "宋体", processEngineConfiguration.getClassLoader(), 1);
		return resource;

	}

}
