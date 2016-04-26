package com.whr.activiti.dao;

import java.util.List;

import com.whr.activiti.model.SysUser;

public interface SysUserMapper {
	
	public void save(SysUser user);
	
	public void update(SysUser user);
	
	public void setPassword(int userId, String pwd);
	
	public List<SysUser> findAll();

}
