package com.whr.activiti.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.FlowNode;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.whr.activiti.dto.OutAndUsers;
import com.whr.activiti.dto.ProcessInstanceAndTask;

/**
 * 
 * @author Lyon
 *
 */
public interface BpmService {
	/**
	 * 通过id查找Task实例
	 * @param taskId
	 * @return
	 */
	Task findTaskById(String taskId);
	
	/**
	 * 通过taskId查找流程实例
	 * @param taskId
	 * @return
	 */
	ProcessInstance findProcessInstanceByTaskId(String taskId);
	
	/**
	 * 启动流程，并指定第一个任务的所有者为启动者
	 * @param processDefKey
	 * @param userId
	 */
	String startProcess(String processDefKey, String userId, String businessKey,Map<String,Object> variables);
	
	/**
	 * 设置/更新流程变量参数
	 * @param params
	 */
	void setProcessVariables(String processInstanceId, Map<String,Object> variables);
	
	/**
	 * 提交流程
	 * @param taskId task实例id
	 * @param currentUserId 当前用户标识
	 * @param targetUserId 目标用户标识
	 * @param wf_direction 流程出口控制参数
	 */
	void complete(String taskId, String currentUserId, String targetUserId, String wf_direction);
	
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
	List<ProcessInstanceAndTask> findTasksByUser(String userId);
	
	/**
	 * 查找指定流程实例的历史办理情况
	 * @param processInstanceId
	 * @return
	 */
	List<HistoricActivityInstance> findHistoricActivityInstance(String processInstanceId);
	
	/**
	 * 查找全部流程定义
	 * @param group
	 * @return
	 */
	List<ProcessDefinition> findAllProcessDef();
	
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

	/**
	 * 通过taskId查找出口节点
	 * @param taskId
	 * @return
	 */
	List<FlowNode> findOutNodes(String taskId);
	
	/**
	 * 通过taskId查找出口节点和对应的候选用户
	 * @param taskId
	 * @return
	 */
	List<OutAndUsers> findNodeUsers(String taskId);
	
	
	/**
	 * 通过业务号查找流程实例历史
	 * @param businessKey
	 * @return
	 */
	HistoricProcessInstance findHistoricProcessInstanceByBusinessKey(String businessKey);
	

	
	
}
