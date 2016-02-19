package com.whr.activiti.service;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BpmServiceImpl implements BpmService {
	
	@Autowired
	private RepositoryService rs;

	@Autowired
	private RuntimeService rts;

	@Autowired
	private TaskService ts;
	
	@Autowired
	private HistoryService hs;

	@Transactional
	@Override
	public void startProcess(String processDefKey, String userId, String businessKey) {
		// 启动流程实例
		ProcessInstance instance = rts.startProcessInstanceByKey(processDefKey);

		// 查找流程当前的任务节点
		Task task = ts.createTaskQuery().processInstanceId(instance.getId()).singleResult();

		// 指定任务所有者
		ts.claim(task.getId(), userId);
		// 设置流程变量--业务号
		rts.setVariable(instance.getId(), "YHW", businessKey);

	}

	@Transactional
	@Override
	public void complete(String taskId, String targetUserId) {
		Task t = ts.createTaskQuery().taskId(taskId).singleResult();

		// 查找对应task的流程实例id
		String processInstId = t.getProcessInstanceId();

		// 设定流程提交方向变量（前进：forward；退回：backward）
		rts.setVariable(processInstId, "direction", "forward");
		ts.complete(taskId);

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
	public List<Task> findTasksByUser(String processDefKey, String userId) {
		// 指定流程和用户查询task
		return ts.createTaskQuery().processDefinitionKey(processDefKey).taskAssignee(userId).list();
	}

	@Override
	public List<HistoricActivityInstance> findProcessHistory(String processInstanceId) {
		//查找实例的历史办理情况；根据启动时间排序
		return hs.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
				.orderByHistoricActivityInstanceStartTime().asc().list();
	}

	
	@Override
	public List<ProcessDefinition> findProcessDefByGroup(String group) {
		// TODO Auto-generated method stub
		rs.createProcessDefinitionQuery().startableByUser(group);
		return null;
	}
	

}
