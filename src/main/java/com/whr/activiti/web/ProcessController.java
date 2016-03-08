package com.whr.activiti.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

import com.whr.activiti.model.UserInfo;
import com.whr.activiti.service.BpmService;
import com.whr.activiti.service.SessionManager;
import com.whr.activiti.utils.Utils;

@Controller
public class ProcessController {

	@Autowired
	private BpmService bs;

//	@RequestMapping(value = "/user/switch", method = RequestMethod.GET)
//	public String initSwitchUser(Model m) {
//		List<UserInfo> users = new ArrayList<UserInfo>();
//		UserInfo u1 = new UserInfo();
//		u1.setId(1l);
//		u1.setLoginName("admin");
//		u1.setName("系统管理员1");
//		u1.setGroup("GROUP_ADMIN");
//		u1.setGroupName("系统管理组");
//		users.add(u1);
//
//		UserInfo u2 = new UserInfo();
//		u2.setId(2l);
//		u2.setLoginName("user1");
//		u2.setName("用户1");
//		u2.setGroup("GROUP_SL");
//		u2.setGroupName("受理用户组");
//		users.add(u2);
//
//		m.addAttribute("users", users);
//		
//		UserInfo currentUser = SessionManager.getLoginUser();
//		m.addAttribute("currentUser", currentUser);
//		
//		return "/user/switch";
//	}
//
//	/**
//	 * 切换登录用户
//	 * 
//	 * @param user
//	 * @return
//	 */
//	@RequestMapping(value = "/user/switch", method = RequestMethod.POST)
//	public String processSwitchUser(UserInfo user) {
//		// session切换登陆用户
//		SessionManager.setLoginUser(user);
//
//		return "redirect:/user/switch";
//	}

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
		bs.startProcess(processDefKey, SessionManager.getLoginUser().getLoginName(), bKey);

		return "redirect:/p/todoList";
	}

	@RequestMapping("/p/{pid}/diagram")
	public ResponseEntity<byte[]> showProgressDiagram(@PathVariable String pid) throws IOException {
		InputStream in = bs.generateDiagram(pid);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}

	@RequestMapping("/p/task/{tid}/complete")
	public String complete(@PathVariable String tid) {
		bs.complete(tid, SessionManager.getLoginUser().getLoginName(), SessionManager.getLoginUser().getLoginName());
		return "redirect:/p/todoList";
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
}
