package com.whr.activiti.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UserInfo extends IdEntity{
	private String loginName;
	
	@Column(name="fName")
	private String name;
	
	@Column(name="fPassword")
	private String password;
	
	@Column(name="fGroupName")
	private String groupName;
	
	@Column(name="fGroup")
	private String group;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
}
