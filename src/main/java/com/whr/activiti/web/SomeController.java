package com.whr.activiti.web;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whr.activiti.service.ApplyService;
import com.whr.activiti.service.BpmService;

@Controller
public class SomeController {
	@Autowired
	private ApplyService as;
	
	
	private BpmService bs;
	
	@RequestMapping("/start")
	public String processRepo(Model m){

		return "/processRepo";
	}

	
	@RequestMapping("/p/{processKey}/start")
	public String start(Model m){
		String pid = as.startProcess();
		m.addAttribute("pid", pid);
		return "/processStarted";
	}
	
	@RequestMapping("/p/{pid}/diagram")
	public ResponseEntity<byte[]> showProgressDiagram(@PathVariable String pid) throws IOException{
		InputStream in = as.getProcessDiagram(pid);
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);

	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("/p/{pid}/complete")
	public String complete(@PathVariable String pid){
		as.complete(pid);
		return "/test";
	}
	
	@RequestMapping("/p/{key}/task/{tid}")
	public String taskList(@PathVariable String key,@PathVariable String tid){
		
		return "/taskList";
	}
}
