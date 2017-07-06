package com.whr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.xqx.sms.server.dao.SysUserDao;
import com.xqx.sms.server.dao.SysUserRoleDao;
import com.xqx.sms.server.model.SysUser;
import com.xqx.sms.server.model.SysUserRole;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	SysUserDao userDao;
	
	@Autowired
	SysUserRoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String loginName)
			throws UsernameNotFoundException {
		SysUser sysUser = userDao.findByLoginName(loginName);
		if (sysUser == null) {
			throw new UsernameNotFoundException("用户名不正确。");
		}

		List<SysUserRole> roles = roleDao.findByUserId(sysUser.getId());
		sysUser.setRoles(roles);
		
		return sysUser;
	}
	
}
