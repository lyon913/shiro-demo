package com.whr.activiti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whr.activiti.model.UserInfo;
import com.whr.activiti.model.Users;
import com.whr.activiti.service.UserManager;

@Controller
public class XmlController {
	
	@Autowired
	private UserManager um;
	
	@RequestMapping(value = "/user/list")
	public String userList(Model m) {
		List<UserInfo> users = um.findAll();
		Users list = new Users();
		list.setUsers(users);
		m.addAttribute("list", list);
		return "user/list";
	}
	
	@RequestMapping(value = "/user/list/ajax")
	@ResponseBody
	public Users userListCn(Model m) {
		List<UserInfo> users = um.findAll();
		Users list = new Users();
		list.setUsers(users);
		return list;
	}
}
