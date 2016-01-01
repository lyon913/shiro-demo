package com.whr.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class RegisterDelegateService implements JavaDelegate{
	

	public void execute(DelegateExecution exec) {
		System.out.println("Person "+exec.getVariable("name")+" registed.");
		
	}

}
