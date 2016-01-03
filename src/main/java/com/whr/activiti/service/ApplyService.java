package com.whr.activiti.service;

import java.io.InputStream;

import com.whr.activiti.model.Apply;

public interface ApplyService {
	public Apply findById(long id);
	
	public Apply save(Apply apply);
	
	public String startProcess();

	public InputStream getProcessDiagram(String pid);
	
	public void complete(String pid);
}
