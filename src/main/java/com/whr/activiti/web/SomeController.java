package com.whr.activiti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whr.activiti.service.ApplyService;

@Controller
public class SomeController {
	@Autowired
	private ApplyService as;

	@RequestMapping("/test")
	public String test(){
		return "/test";
	}
	
	@RequestMapping("/start")
	public String start(){
		as.startProcess();
		return "/test";
	}
}
