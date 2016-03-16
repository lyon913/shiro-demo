package com.whr.activiti.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.whr.activiti.dao.mybatis.CustomHistoricInstanceMapper;
import com.whr.activiti.dto.HistoricProcessInstanceAndTask;
import com.whr.activiti.dto.OutAndUsers;
import com.whr.activiti.dto.ProcessInstanceAndTask;
import com.whr.activiti.model.UserInfo;

@Service
public class BpmServiceImpl implements BpmService {

	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;

	/**
	 * 流程定义仓库接口
	 */
	@Autowired
	private RepositoryService rps;

	/**
	 * 流程运行时接口
	 */
	@Autowired
	private RuntimeService rts;

	/**
	 * 任务接口
	 */
	@Autowired
	private TaskService ts;

	/**
	 * 流程历史接口
	 */
	@Autowired
	private HistoryService hs;
	
	/**
	 * 流程引擎管理接口
	 */
	@Autowired
	ManagementService ms;

	@Autowired
	private UserManager um;

	@Transactional
	@Override
	public String startProcess(String processDefKey, String userId, String businessKey, Map<String, Object> variables) {

		// 设置activiti用户信息
		Authentication.setAuthenticatedUserId(userId);

		// 启动流程实例,设置业务号（businessKey,唯一）
		ProcessInstance instance = rts.startProcessInstanceByKey(processDefKey, businessKey, variables);

		/**
		 * 流程定义中已经根据流程创建者设置了第一个节点的指派用户为流程启动者(${initator})
		 * 此处无需再指定。代码注释掉
		 */
		// 查找流程当前的任务节点
		// Task task =
		// ts.createTaskQuery().processInstanceId(instance.getId()).singleResult();
		// 指定任务所有者
		// ts.claim(task.getId(), userId);

		// 返回实例id
		return instance.getId();

	}

	@Transactional
	@Override
	public void complete(String taskId, String currentUserId, String targetUserId, String wf_direction) {
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
		// 设定流程提交方向变量(设定为目标节点id)
		rts.setVariable(processInstId, "wf_direction", wf_direction);
		ts.complete(t.getId());

		if (!StringUtils.isEmpty(targetUserId)) {
			// 查找流程当前的任务节点
			Task task = ts.createTaskQuery().processInstanceId(processInstId).singleResult();
			// 指定任务所有者
			ts.claim(task.getId(), targetUserId);
		}
	}

	@Override
	public ProcessInstance findProcessInstanceById(String processInstanceId) {
		return rts.createProcessInstanceQuery().processInstanceId(processInstanceId).includeProcessVariables().singleResult();
	}

	@Override
	public List<ProcessInstanceAndTask> findTasksByUser(String userId) {
		List<ProcessInstanceAndTask> result = new ArrayList<ProcessInstanceAndTask>();
		// 指定流程和用户查询task
		List<Task> tasks = ts.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
		if (tasks != null && tasks.size() > 0) {
			for (Task t : tasks) {
				ProcessInstance pi = rts.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).includeProcessVariables().singleResult();
				ProcessInstanceAndTask pat = new ProcessInstanceAndTask(pi, t);
				result.add(pat);
			}
		}
		return result;
	}

	@Override
	public List<HistoricActivityInstance> findHistoricActivityInstance(String processInstanceId) {
		// 查找实例的历史办理情况；根据启动时间排序（多条）
		return hs.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
				.orderByHistoricActivityInstanceStartTime().asc().orderByHistoricActivityInstanceEndTime().asc().list();
	}

	@Override
	public List<ProcessDefinition> findAllProcessDef() {
		// 需要加上latestVersion条件，否则会查询出历史版本
		return rps.createProcessDefinitionQuery().latestVersion().list();
	}

	@Override
	public ProcessDefinition findProcessDefByKey(String processDefKey) {
		// 按key查找流程定义（单个记录）
		return rps.createProcessDefinitionQuery().processDefinitionKey(processDefKey).singleResult();
	}

	/**
	 * 输出流程图
	 */
	@Override
	public InputStream generateDiagram(String pid) {
		//查找流程实例（此处使用HistoricProcessInstance，即可处理已办结的流程）
		HistoricProcessInstance hInst = hs.createHistoricProcessInstanceQuery().processInstanceId(pid).singleResult();
		if (hInst == null) {
			throw new ActivitiObjectNotFoundException("流程实例未找到-pid:" + pid);
		}
		//流程定义模型
		BpmnModel bpmnModel = rps.getBpmnModel(hInst.getProcessDefinitionId());
		
		//流程图生成器
		ProcessDiagramGenerator dg = processEngineConfiguration.getProcessDiagramGenerator();
		//生成png图片stream
		InputStream resource = dg.generateDiagram(bpmnModel, "png", rts.getActiveActivityIds(hInst.getId()),
				Collections.<String> emptyList(), "宋体", "宋体", processEngineConfiguration.getClassLoader(), 1);
		return resource;

	}

	@Override
	public List<FlowNode> findOutNodes(String taskId) {
		UserTask currentTask = getUserTaskDefById(taskId);
		List<FlowNode> outNodes = findUserTaskOutNodes(currentTask);
		return outNodes;

	}

	/**
	 * 通过UsrTask实例id查找其定义
	 * 
	 * @param taskId
	 * @return
	 */
	private UserTask getUserTaskDefById(String taskId) {
		Task t = ts.createTaskQuery().taskId(taskId).singleResult();
		if (t == null) {
			throw new ActivitiObjectNotFoundException("任务未找到--task id:" + taskId);
		}
		BpmnModel m = rps.getBpmnModel(t.getProcessDefinitionId());
		// 主流程
		Process mp = m.getMainProcess();
		// 查找流程定义中的所有UserTask
		List<UserTask> uts = mp.findFlowElementsOfType(UserTask.class);

		if (uts == null || uts.size() < 1) {
			throw new ActivitiObjectNotFoundException("流程定义错误(流程" + mp.getId() + "中未找到UserTask)");
		}
		UserTask taskDef = null;// 查找的目标任务
		for (UserTask ut : uts) {
			// 遍历查找指定UserTask
			if (t.getTaskDefinitionKey().equals(ut.getId())) {
				taskDef = ut;
			}
		}
		return taskDef;

	}

	/**
	 * 查找UserTask的出口节点
	 * 
	 * @param userTask
	 * @return
	 */
	private List<FlowNode> findUserTaskOutNodes(UserTask userTask) {

		// 获得当前UserTask的所有出口定义
		List<SequenceFlow> outFlows = userTask.getOutgoingFlows();
		if (outFlows == null || outFlows.size() < 1) {
			throw new ActivitiObjectNotFoundException("流程定义错误:节点" + userTask.getName() + "没有出口");
		}
		List<FlowNode> outNodes = new ArrayList<FlowNode>();
		for (SequenceFlow sf : outFlows) {

			// 获取sequenceflow的目标节点
			FlowElement target = sf.getTargetFlowElement();
			if (target instanceof UserTask) {
				// usertask
				outNodes.add((UserTask) target);
			} else if (target instanceof StartEvent) {
				// 流程开始事件不能作为出口
			} else if (target instanceof EndEvent) {
				// 流程结束事件
				outNodes.add((EndEvent) target);
			} else {
				// 其他节点暂时未考虑。如需处理gateway在此增加递归调用
			}
		}

		return outNodes;
	}

	@Override
	public Task findTaskById(String taskId) {
		return ts.createTaskQuery().taskId(taskId).singleResult();
	}

	@Override
	public ProcessInstance findProcessInstanceByTaskId(String taskId) {
		Task t = findTaskById(taskId);
		return rts.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).includeProcessVariables().singleResult();
	}

	@Override
	public List<OutAndUsers> findNodeUsers(String taskId) {
		//获得所有出口
		List<FlowNode> outs = findOutNodes(taskId);
		List<OutAndUsers> result = new ArrayList<OutAndUsers>();
		for (FlowNode outNode : outs) {
			if (outNode instanceof UserTask) {
				//出口是UserTask，查找出口节点可选用户
				UserTask t = (UserTask) outNode;
				List<UserInfo> users = um.findByGroups(t.getCandidateGroups());
				OutAndUsers ous = new OutAndUsers(t,users);
				result.add(ous);
			} else if (outNode instanceof EndEvent) {
				//出口是EndEvent流程结束，则没有候选用户。
				List<UserInfo> users  = new ArrayList<UserInfo>();
				UserInfo ui = new UserInfo();
				ui.setName("办结");
				users.add(ui);
				OutAndUsers ous = new OutAndUsers(outNode,users);
				result.add(ous);
			} else {

			}
		}
		return result;
	}

	@Override
	public HistoricProcessInstance findHistoricProcessInstanceByBusinessKey(String businessKey) {
		//查找流程实例历史（在办、完结都可查到）。条件为业务号
		HistoricProcessInstance hi = hs.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(businessKey)
				.includeProcessVariables()
				.singleResult();
		return hi;

	}

	@Override
	public void setProcessVariables(String processInstanceId, Map<String, Object> variables) {
		//设置流程变量；已存在的变量会被更新
		rts.setVariables(processInstanceId, variables);
	}

	@Override
	public Page<ProcessInstanceAndTask> findTasksByUser(String userId, int page, int size) {
		List<ProcessInstanceAndTask> result = new ArrayList<ProcessInstanceAndTask>();
		// 指定流程和用户查询task
		//指定分页参数
		List<Task> tasks = ts.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().listPage(page*size, size);
		//记录总数
		long count = ts.createTaskQuery().taskAssignee(userId).count();
		
		//查找task对应的流程实例
		if (tasks != null && tasks.size() > 0) {
			for (Task t : tasks) {
				ProcessInstance pi = rts.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).includeProcessVariables().singleResult();
				ProcessInstanceAndTask pat = new ProcessInstanceAndTask(pi, t);
				result.add(pat);
			}
		}
		
		//包装为spring data 的分页格式
		Pageable pageable = new PageRequest(page, size);
		Page<ProcessInstanceAndTask> p = new PageImpl<ProcessInstanceAndTask>(result,pageable,count);
		return p;
	}


	@Override
	public List<HistoricProcessInstanceAndTask> findInvolvedByUser(final String userId) {
		List<HistoricProcessInstanceAndTask> result = new ArrayList<HistoricProcessInstanceAndTask>();
		//sql 查询已办理的业务（用户办理过，但流程未完）
		List<HistoricProcessInstance> insts = ms.executeCommand(new Command<List<HistoricProcessInstance>>() {    
		    @Override    
		    public List<HistoricProcessInstance> execute(CommandContext commandContext) { 
		    	CustomHistoricInstanceMapper mapper = commandContext.getDbSqlSession().getCustomMapper(CustomHistoricInstanceMapper.class);
		     return mapper.findDoneListByUserId(userId);
		    }    
		   });
		
		if (insts != null && insts.size() > 0) {
			for (HistoricProcessInstance pi : insts) {
				//查找流程实例当前所处的节点
				List<HistoricTaskInstance> tasks = hs.createHistoricTaskInstanceQuery()
						.processInstanceId(pi.getId())
						.unfinished()
						.orderByTaskCreateTime()
						.desc()
						.list();
				if(tasks != null && tasks.size() > 0) {
					HistoricProcessInstanceAndTask pat = new HistoricProcessInstanceAndTask(pi, tasks.get(0));
					result.add(pat);
				}
			}
		}
		return result;
	}
	
	@Override
	public Page<HistoricProcessInstanceAndTask> findInvolvedByUser(final String userId, final int page, final int size) {
		List<HistoricProcessInstanceAndTask> result = new ArrayList<HistoricProcessInstanceAndTask>();
		//sql 查询已办理的业务（用户办理过，但流程未完）
		List<HistoricProcessInstance> insts = ms.executeCommand(new Command<List<HistoricProcessInstance>>() {    
		    @Override    
		    public List<HistoricProcessInstance> execute(CommandContext commandContext) { 
		    	CustomHistoricInstanceMapper mapper = commandContext.getDbSqlSession().getCustomMapper(CustomHistoricInstanceMapper.class);
		     return mapper.findDoneListByUserIdPage(userId,page*size+1,(page*size+1)+size);
		    }    
		});
		
		long count = ms.executeCommand(new Command<Long>() {    
		    @Override    
		    public Long execute(CommandContext commandContext) { 
		    	CustomHistoricInstanceMapper mapper = commandContext.getDbSqlSession().getCustomMapper(CustomHistoricInstanceMapper.class);
		     return mapper.countDoneListByUserId(userId);
		    }    
		});
		
		if (insts != null && insts.size() > 0) {
			for (HistoricProcessInstance pi : insts) {
				//查找流程实例当前所处的节点
				List<HistoricTaskInstance> tasks = hs.createHistoricTaskInstanceQuery()
						.processInstanceId(pi.getId())
						.unfinished()
						.orderByTaskCreateTime()
						.desc()
						.list();
				if(tasks != null && tasks.size() > 0) {
					HistoricProcessInstanceAndTask pat = new HistoricProcessInstanceAndTask(pi, tasks.get(0));
					result.add(pat);
				}
			}
		}
		
		//包装为spring data 的分页格式
		Pageable pageable = new PageRequest(page, size);
		Page<HistoricProcessInstanceAndTask> p = new PageImpl<HistoricProcessInstanceAndTask>(result,pageable,count);
		return p;
	}
	

}
