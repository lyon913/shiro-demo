package com.whr.activiti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whr.activiti.model.UserInfo;
import com.whr.activiti.service.SessionManager;
import com.whr.activiti.service.UserManager;

@Controller
public class UserController {

	@Autowired
	private UserManager um;

	@RequestMapping(value = "/user/switch", method = RequestMethod.GET)
	public String initSwitchUser(Model m) {
		List<UserInfo> users = um.findAll();
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
//
//	/**
//	 * 按组别选择用户
//	 * @param group 用户组
//	 * @param cbk 选择用户后的回掉
//	 * @param m
//	 * @return
//	 */
//	@RequestMapping("/user/selectByGroup/{group}/{cbk}")
//	public String userListByGroup(@PathVariable String group, @PathVariable String cbk, Model m) {
//		List<UserInfo> users = um.findByGroup(group);
//		
//		m.addAttribute("users", users);
//		m.addAttribute("cbk", cbk);
//		return "user/select";
//	}
}
