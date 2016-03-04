package com.whr.activiti.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whr.activiti.model.UserInfo;
import com.whr.activiti.service.BpmService;
import com.whr.activiti.service.SessionManager;

@Controller
public class UserController {

	@Autowired
	private BpmService bs;

	@RequestMapping(value = "/user/switch", method = RequestMethod.GET)
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
		
		UserInfo currentUser = SessionManager.getLoginUser();
		m.addAttribute("currentUser", currentUser);
		
		return "/user/switch";
	}

	/**
	 * 切换登录用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/switch", method = RequestMethod.POST)
	public String processSwitchUser(UserInfo user) {
		// session切换登陆用户
		SessionManager.setLoginUser(user);

		return "redirect:/user/switch";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/user/list/group/{group}")
	public String userListByGroup(String group) {
		return "userSelect";
	}
}
