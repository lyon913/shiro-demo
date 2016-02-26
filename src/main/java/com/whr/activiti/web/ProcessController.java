package com.whr.activiti.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whr.activiti.model.UserInfo;
import com.whr.activiti.service.BpmService;
import com.whr.activiti.service.SessionManager;
import com.whr.activiti.utils.Utils;

@Controller
public class ProcessController {
	
	@Autowired
	private BpmService bs;
	
	@Autowired
	private SessionManager sm;
	
	
	@RequestMapping(value="/user/switch",method = RequestMethod.GET)
	public String initSwitchUser(Model m) {
		List<UserInfo> users = new ArrayList<UserInfo>();
		UserInfo u1 = new UserInfo();
		u1.setId(1l);
		u1.setLoginName("admin");
		u1.setName("系统管理员1");
		u1.setGroup("GROUP_ADMIN");
		u1.setGroupName("系统管理组");
		users.add(u1);
		
		UserInfo u2 = new UserInfo();
		u2.setId(2l);
		u2.setLoginName("user1");
		u2.setName("用户1");
		u2.setGroup("GROUP_SL");
		u2.setGroupName("受理用户组");
		users.add(u2);
		
		m.addAttribute("users", users);
		return "/user/switch";
	}
	
	/**
	 * 切换登录用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user/switch",method = RequestMethod.POST)
	public String processSwitchUser(@RequestParam UserInfo user) {
		//session切换登陆用户
		sm.setLoginUser(user);
		//用户登录activiti
		Authentication.setAuthenticatedUserId(user.getLoginName());
		return "/user/switch";
	}
	
	@RequestMapping("/p/repo")
	public String processRepo(Model m){
		List<ProcessDefinition> prcesses = bs.findProcessDefByGroup(sm.getLoginUser().getGroup());
		m.addAttribute("process", prcesses);
		return "/p/repo";
	}

	
	@RequestMapping("/p/{processDefKey}/start")
	public String start(@PathVariable String processDefKey,Model m){
		String bKey = Utils.getBusinessKey();
		String pid = bs.startProcess(processDefKey, "admin", bKey);
		
		ProcessDefinition pDef = bs.findProcessDefByKey(processDefKey);
		m.addAttribute("pName", pDef.getName());
		m.addAttribute("pid", pid);
		m.addAttribute("bKey", bKey);
		return "/p/todoList";
	}
	
	@RequestMapping("/p/{pid}/diagram")
	public ResponseEntity<byte[]> showProgressDiagram(@PathVariable String pid) throws IOException{
		InputStream in = bs.generateDiagram(pid);
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);
	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("/p/{pid}/complete")
	public String complete(@PathVariable String pid){
		bs.complete(pid, sm.getLoginUser().getLoginName());
		return "redirect:/p/todoList";
	}
	
	@RequestMapping("/p/todoList")
	public String todoList(@PathVariable String key,@PathVariable String tid, Model m){
		Map<ProcessInstance,Task> result = bs.findTasksByUser(sm.getLoginUser().getLoginName());
		m.addAttribute("result", result);
		return "/p/todoList";
	}
}
