package com.whr.activiti.service;

import javax.transaction.Transactional;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whr.activiti.dao.ApplyRepo;
import com.whr.activiti.model.Apply;

@Service
public class ApplyServiceImpl implements ApplyService {
	private final Logger logger = LoggerFactory.getLogger(ApplyServiceImpl.class);
	
	@Autowired
	private ApplyRepo ar;
	
	@Autowired
	private RuntimeService rs;
	
//	@Autowired
//	private TaskService ts;

	public Apply findById(long id) {
		return ar.findOne(id);

	}

	@Transactional
	public Apply save(Apply apply) {
		return ar.save(apply);
	}

	@Transactional
	public void startProcess() {
		ProcessInstance p = rs.startProcessInstanceByKey("p_register");
		logger.info("process started:"+p.getProcessInstanceId());
	}

}
