package com.whr.activiti.dto;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;

public class HistoricProcessInstanceAndTask {

	private HistoricProcessInstance processInstance;

	private HistoricTaskInstance task;
	
	public HistoricProcessInstanceAndTask(){
		
	}
	
	public HistoricProcessInstanceAndTask(HistoricProcessInstance processInstance, HistoricTaskInstance task) {
		this.processInstance = processInstance;
		this.task = task;
	}

	public HistoricProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(HistoricProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public HistoricTaskInstance getTask() {
		return task;
	}

	public void setTask(HistoricTaskInstance task) {
		this.task = task;
	}


}
