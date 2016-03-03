package com.whr.activiti.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.whr.activiti.model.UserInfo;


public class SessionManager {

	public static UserInfo getLoginUser() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session =attr.getRequest().getSession();
		UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
		return loginUser;
	}

	public static void setLoginUser(UserInfo loginUser) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session =attr.getRequest().getSession();
		session.setAttribute("loginUser", loginUser);
	}
		
}
