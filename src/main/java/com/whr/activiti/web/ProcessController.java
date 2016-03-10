package com.whr.activiti.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.FlowNode;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whr.activiti.model.UserInfo;
import com.whr.activiti.service.BpmService;
import com.whr.activiti.service.SessionManager;
import com.whr.activiti.utils.Utils;

@Controller
public class ProcessController {

	@Autowired
	private BpmService bs;


	@RequestMapping("/p/repo")
	public String processRepo(Model m) {
		UserInfo currentUser = SessionManager.getLoginUser();
		if (currentUser != null) {
			List<ProcessDefinition> processes = bs.findProcessDefByGroup(currentUser.getGroup());
			m.addAttribute("pdList", processes);
		}
		return "/p/repo";
	}

	@RequestMapping("/p/{processDefKey}/start")
	public String start(@PathVariable String processDefKey, Model m) {

		String bKey = Utils.getBusinessKey();
		Map<String,Object> variables = new HashMap<>();
		variables.put("YWLX", "土地使用权/房屋所有权首次登记");
		variables.put("QLR", "郑房东");
		variables.put("ZL", "云南省昆明市五华区人民中路42号右弼大厦4-A1");
		bs.startProcess(processDefKey, SessionManager.getLoginUser().getLoginName(), bKey, variables);

		return "redirect:/p/todoList";
	}

	@RequestMapping("/p/{pid}/diagram")
	public ResponseEntity<byte[]> showProgressDiagram(@PathVariable String pid) throws IOException {
		InputStream in = bs.generateDiagram(pid);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/p/task/{tid}/complete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> complete(@PathVariable String tid,String targetUser,String wf_direction) {
		
		try {
			bs.complete(tid, SessionManager.getLoginUser().getLoginName(), targetUser, wf_direction);
		}catch(Throwable e) {
			ResponseEntity<String> response = new ResponseEntity<>(ExceptionUtils.getStackTrace(e),HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
		
		ResponseEntity<String> response = new ResponseEntity<>("OK",HttpStatus.OK);
		
		return response;
	}

	@RequestMapping("/p/todoList")
	public String todoList(Model m) {
		UserInfo currentUser = SessionManager.getLoginUser();
		if (currentUser != null) {
			Map<ProcessInstance, Task> result = bs.findTasksByUser(currentUser.getLoginName());
			m.addAttribute("result", result);
		}
		return "/p/todoList";
	}
	
	@RequestMapping("/p/task/{taskId}/details")
	public String taskDetails(@PathVariable String taskId, Model m) {
		Task t = bs.getTaskById(taskId);
		ProcessInstance pi = bs.getProcessInstanceByTaskId(taskId);
		List<HistoricActivityInstance> history = bs.findProcessHistory(pi.getId());
		m.addAttribute("task", t);
		m.addAttribute("processInstance", pi);
		m.addAttribute("history",history);
		return "/p/taskDetails";
	}
	
	@RequestMapping("/p/task/{taskId}/outs/{cbk}")
	public String outNodes(@PathVariable String taskId, @PathVariable String cbk, Model m) {
		Map<FlowNode,List<UserInfo>> outs = bs.findNodeUsers(taskId);

		m.addAttribute("outs",outs);
		m.addAttribute("taskId",taskId);
		m.addAttribute("cbk",cbk);
		return "/p/outs";
	}
}
