package com.whr.activiti.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
	
	@XmlElement(name = "user")
	private List<UserInfo> users;

	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
	
}
