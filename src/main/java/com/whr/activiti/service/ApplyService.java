package com.whr.activiti.service;

import com.whr.activiti.model.Apply;

public interface ApplyService {
	public Apply findById(long id);
	
	public Apply save(Apply apply);
	
	public void startProcess();
}
