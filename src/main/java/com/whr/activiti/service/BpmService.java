package com.whr.activiti.service;

import java.util.List;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.ProcessDefinition;
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
	void startProcess(String processDefKey, String userId, String businessKey);
	
	/**
	 * 提交流程
	 * @param taskId
	 */
	void complete(String taskId, String targetUserId);
	
	/**
	 * 退回流程
	 * @param taskId
	 */
	void back(String taskId, String targetUserId);
	
	/**
	 * 查找用户当前待处理的任务
	 * @param processDefKey
	 * @param userId
	 * @return
	 */
	List<Task> findTasksByUser(String processDefKey, String userId);
	
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
	

}
