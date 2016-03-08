package com.whr.activiti.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

		// 设置activiti用户信息
		Authentication.setAuthenticatedUserId(userId);

		// 启动流程实例,设置业务号（businessKey,唯一）
		ProcessInstance instance = rts.startProcessInstanceByKey(processDefKey, businessKey);

		// 查找流程当前的任务节点
		//Task task = ts.createTaskQuery().processInstanceId(instance.getId()).singleResult();

		// 指定任务所有者
		//ts.claim(task.getId(), userId);

		// 返回实例id
		return instance.getId();

	}

	@Transactional
	@Override
	public void complete(String taskId, String currentUserId, String targetUserId) {

		// 设置activiti用户信息
		Authentication.setAuthenticatedUserId(currentUserId);

		// 此处简化处理代码
		// 串行任务可以按下面查询，只会有一条记录；但并行任务可能有多条task，需修改处理方式
		Task t = ts.createTaskQuery().taskId(taskId).singleResult();

		if (t == null) {
			throw new ActivitiObjectNotFoundException("未找到活动任务-taskid:" + taskId);
		}

		// 查找对应task的流程实例id
		String processInstId = t.getProcessInstanceId();

		// 设定流程提交方向变量（前进：forward；退回：backward）
		rts.setVariable(processInstId, "direction", "forward");
		ts.complete(t.getId());

		if(targetUserId != null) {
			// 查找流程当前的任务节点
			Task task = ts.createTaskQuery().processInstanceId(processInstId).singleResult();
			// 指定任务所有者
			ts.claim(task.getId(), targetUserId);
		}
	}

	@Transactional
	@Override
	public void back(String taskId, String currentUserId, String targetUserId) {
		// 设置activiti用户信息
		Authentication.setAuthenticatedUserId(currentUserId);

		Task t = ts.createTaskQuery().taskId(taskId).singleResult();

		// 查找对应task的流程实例id
		String processInstId = t.getProcessInstanceId();

		// 设定流程提交方向变量（前进：forward；退回：backward）
		rts.setVariable(processInstId, "direction", "backward");
		ts.complete(taskId);

		if(targetUserId != null) {
			// 查找流程当前的任务节点
			Task task = ts.createTaskQuery().processInstanceId(processInstId).singleResult();
			// 指定任务所有者
			ts.claim(task.getId(), targetUserId);
		}

	}

	@Override
	public ProcessInstance findProcessInstanceById(String processInstanceId) {
		return rts.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
	}

	@Override
	public Map<ProcessInstance, Task> findTasksByUser(String userId) {
		Map<ProcessInstance, Task> result = new HashMap<ProcessInstance, Task>();
		// 指定流程和用户查询task
		List<Task> tasks = ts.createTaskQuery().taskAssignee(userId).list();
		if (tasks != null && tasks.size() > 0) {
			for (Task t : tasks) {
				ProcessInstance pi = rts.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId())
						.singleResult();
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
		// 查找group可启动的流程;最新版本（可以是多个或一个）
		return rps.createProcessDefinitionQuery().startableByUser(group).latestVersion().list();
	}

	@Override
	public ProcessDefinition findProcessDefByKey(String processDefKey) {
		// 按key查找流程定义（单个记录）
		return rps.createProcessDefinitionQuery().processDefinitionKey(processDefKey).singleResult();
	}

	@Override
	public InputStream generateDiagram(String pid) {

		HistoricProcessInstance hInst = hs.createHistoricProcessInstanceQuery().processInstanceId(pid).singleResult();

		if (hInst == null) {
			throw new ActivitiObjectNotFoundException("流程实例未找到：" + pid);
		}
		BpmnModel bpmnModel = rps.getBpmnModel(hInst.getProcessDefinitionId());

		ProcessDiagramGenerator dg = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream resource = dg.generateDiagram(bpmnModel, "png", rts.getActiveActivityIds(hInst.getId()),
				Collections.<String> emptyList(), "宋体", "宋体", processEngineConfiguration.getClassLoader(), 1);
		return resource;

	}

	@Override
	public List<String> findNextCandiGroups(String taskId) {

		Task t = ts.createTaskQuery().taskId(taskId).singleResult();
		if (t == null) {
			throw new ActivitiObjectNotFoundException("任务未找到--task id:" + taskId);
		}

		BpmnModel m = rps.getBpmnModel(t.getProcessInstanceId());
		
		//主流程
		Process mp = m.getMainProcess();
		// 查找流程定义中的所有UserTask
		List<UserTask> uts = mp.findFlowElementsOfType(UserTask.class);

		if (uts == null || uts.size() < 1) {
			throw new ActivitiObjectNotFoundException("流程定义错误(流程"+mp.getId()+"中未找到UserTask)");
		}

		UserTask currentTask = null;// 当前用户任务
		Integer currentTaskIndex = null;// 当前用户任务的index（即id的数值大小）

		for (UserTask ut : uts) {
			// 遍历查找当前的UserTask
			if (t.getTaskDefinitionKey().equals(ut.getId())) {
				currentTask = ut;
				currentTaskIndex = Integer.parseInt(ut.getId());
			}
		}

		if (currentTask == null) {
			throw new ActivitiObjectNotFoundException("未找到Task定义");
		}

		// 获得当前UserTask的所有出口定义
		List<SequenceFlow> outFlows = currentTask.getOutgoingFlows();
		if (outFlows == null || outFlows.size() < 1) {
			throw new ActivitiObjectNotFoundException("流程定义错误:节点" + currentTask.getName() + "没有出口");
		}
		//遍历出口，寻找前进方向（index比当前节点大的节点）
		List<UserTask> nextNodes = findNext(outFlows,currentTaskIndex);
		if(nextNodes == null) {
			//流程无下一个usertask，通常情况是下一节点为流程结束事件
			return null;
		}
		
		if(nextNodes.size() > 1) {
			throw new RuntimeException("暂不支持多个出口节点");
		}
		
		return nextNodes.get(0).getCandidateGroups();

	}

	@Override
	public List<String> findLastCandiGroups(String processInstanceId) {
		return null;

	}
	
	private List<UserTask> findNext(List<SequenceFlow> flows, int currentIndex){
		List<UserTask> result = new ArrayList<UserTask>();
		for(SequenceFlow sf : flows) {
			
			//获取sequenceflow的目标节点
			FlowElement target = sf.getTargetFlowElement();
			if(target instanceof UserTask) {
				String taskDefKey = ((UserTask)target).getId();
				int nextIndex = Integer.parseInt(taskDefKey);
				
				//目标节点index大于当前index则判断为前进方向
				if(nextIndex > currentIndex) {
					result.add((UserTask)target);
				}
			}else if(target instanceof StartEvent){
				//流程开始事件
			}else if(target instanceof EndEvent){
				//流程结束事件
			}else {
				//其他节点暂时未考虑。如需处理gateway在此增加递归调用
			}
		}
		
		return result;
	}
	
	private List<UserTask> findLast(List<SequenceFlow> flows, int currentIndex){
		List<UserTask> result = new ArrayList<UserTask>();
		for(SequenceFlow sf : flows) {
			
			//获取sequenceflow的目标节点
			FlowElement target = sf.getTargetFlowElement();
			if(target instanceof UserTask) {
				String taskDefKey = ((UserTask)target).getId();
				int nextIndex = Integer.parseInt(taskDefKey);
				
				//目标节点index大于当前index则判断为前进方向
				if(nextIndex < currentIndex) {
					result.add((UserTask)target);
				}
			}else if(target instanceof StartEvent){
				//流程开始事件
			}else if(target instanceof EndEvent){
				//流程结束事件
			}else {
				//其他节点暂时未考虑。如需处理gateway在此增加递归调用
			}
		}
		
		return result;
	}

}
