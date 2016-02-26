package com.whr.activiti.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.whr.activiti.model.UserInfo;

@Component
@Scope("session")
public class SessionManager {
	private UserInfo loginUser;

	public UserInfo getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(UserInfo loginUser) {
		this.loginUser = loginUser;
	}
		
}
