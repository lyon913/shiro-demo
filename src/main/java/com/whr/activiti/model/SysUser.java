package com.whr.activiti.model;

public class SysUser extends BaseAuditEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -342211794426752130L;
	
	private String loginName;
	private String password;
	private String name;
	private String mail;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
