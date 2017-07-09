package com.whr.service;

import java.util.List;

import com.whr.mapper.SysUserMapper;
import com.whr.mapper.SysUserRoleMapper;
import com.whr.model.SysUser;
import com.whr.model.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	SysUserMapper userMapper;
	
	@Autowired
	SysUserRoleMapper roleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String loginName) 	throws UsernameNotFoundException {
		SysUser sysUser = userMapper.selectByLoginName(loginName);
		if (sysUser == null) {
			throw new UsernameNotFoundException("用户名不正确。");
		}

		List<SysUserRole> roles = roleMapper.selectByUserId(sysUser.getId());
		sysUser.setRoles(roles);
		
		return sysUser;
	}
	
}
