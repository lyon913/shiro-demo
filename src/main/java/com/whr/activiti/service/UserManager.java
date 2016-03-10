package com.whr.activiti.service;

import java.util.List;

import com.whr.activiti.model.UserInfo;

public interface UserManager{

	List<UserInfo> findAll();
	
	List<UserInfo> findByGroup(String group);
	
	List<UserInfo> findByGroups(List<String> groups);

}
