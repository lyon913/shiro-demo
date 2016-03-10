package com.whr.activiti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whr.activiti.dao.UserInfoDao;
import com.whr.activiti.model.UserInfo;

@Service
public class UserManagerImpl implements UserManager {
	@Autowired
	private UserInfoDao ud;

	@Override
	public List<UserInfo> findAll() {
		return ud.findAll();
	}

	@Override
	public List<UserInfo> findByGroup(String group) {
		return ud.findByGroup(group);
	}
	
	@Override
	public List<UserInfo> findByGroups(List<String> groups) {
		return ud.findByGroups(groups);
	}

}
