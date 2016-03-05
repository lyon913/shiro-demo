package com.whr.activiti.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 
 * @author Lyon
 *
 */
public interface BpmService {
	/**
	 * 启动流程，并指定第一个任务的所有者为启动者
	 * @param processDefKey
	 * @param userId
	 */
	String startProcess(String processDefKey, String userId, String businessKey);
	
	/**
	 * 提交流程
	 * @param taskId
	 */
	void complete(String taskId, String currentUserId, String targetUserId);
	
	/**
	 * 退回流程
	 * @param taskId
	 */
	void back(String taskId, String currentUserId, String targetUserId);
	
	
	/**
	 * 通过流程实例id查找流程实例
	 * @param processInstanceId
	 * @return
	 */
	ProcessInstance findProcessInstanceById(String processInstanceId);
	
	/**
	 * 查找用户当前待处理的任务
	 * @param userId
	 * @return
	 */
	Map<ProcessInstance,Task> findTasksByUser(String userId);
	
	/**
	 * 查找指定流程实例的历史办理情况
	 * @param processInstanceId
	 * @return
	 */
	List<HistoricActivityInstance> findProcessHistory(String processInstanceId);
	
	/**
	 * 查找用户组可启动的流程
	 * @param group
	 * @return
	 */
	List<ProcessDefinition> findProcessDefByGroup(String group);
	
	/**
	 * 通过key查找流程定义
	 * @param processDefKey
	 * @return
	 */
	ProcessDefinition findProcessDefByKey(String processDefKey);
	
	/**
	 * 生成流程图
	 * @param pid
	 * @return
	 */
	InputStream generateDiagram(String pid);

	
	List<String> findNextCandiGroups(String processInstanceId);
	
	List<String> findLastCandiGroups(String processInstanceId);

	

	

}
