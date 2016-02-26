package com.whr.activiti.service;

import java.io.InputStream;
import java.util.Collections;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplyServiceImpl implements ApplyService {
	private final Logger logger = LoggerFactory.getLogger(ApplyServiceImpl.class);

	@Autowired
	private RuntimeService runtime;
	
	@Autowired
	private TaskService task;

	@Autowired
	private RepositoryService repo;
	
	@Autowired
	private IdentityService ids;

	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;


	@Override
	@Transactional
	public String startProcess() {
		ids.setAuthenticatedUserId("1122");
		ProcessInstance p = runtime.startProcessInstanceByKey("p_register");
		logger.info("process started:" + p.getProcessInstanceId());
		
		return p.getId();
	}

	@Override
	public InputStream getProcessDiagram(String pid) {
		ProcessInstance processInstance = runtime.createProcessInstanceQuery().processInstanceId(pid).singleResult();

		ProcessDefinition pde = repo.getProcessDefinition(processInstance.getProcessDefinitionId());

		ProcessDiagramGenerator dg = processEngineConfiguration.getProcessDiagramGenerator();

		BpmnModel bpmnModel = repo.getBpmnModel(pde.getId());
		InputStream resource = dg.generateDiagram(bpmnModel, "png",
				runtime.getActiveActivityIds(processInstance.getId()), Collections.<String> emptyList(),
				"宋体", "宋体", processEngineConfiguration.getClassLoader(), 1);
		return resource;
	}

	@Override
	@Transactional
	public void complete(String pid) {
		Task t = task.createTaskQuery().processInstanceId(pid).singleResult();
		runtime.setVariable(pid, "receiveResult", "approved");
		runtime.setVariable(pid, "checkResult", "approved");
		runtime.setVariable(pid, "level", "2");
		task.complete(t.getId());
	}

}
