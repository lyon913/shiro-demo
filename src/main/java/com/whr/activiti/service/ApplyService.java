package com.whr.activiti.service;

import java.io.InputStream;

public interface ApplyService {
	
	public String startProcess();

	public InputStream getProcessDiagram(String pid);
	
	public void complete(String pid);
}
