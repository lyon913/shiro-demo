package com.whr.activiti.dto;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ProcessInstanceAndTask {

	private ProcessInstance processInstance;

	private Task task;
	
	public ProcessInstanceAndTask(){
		
	}
	
	public ProcessInstanceAndTask(ProcessInstance processInstance, Task task) {
		this.processInstance = processInstance;
		this.task = task;
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
