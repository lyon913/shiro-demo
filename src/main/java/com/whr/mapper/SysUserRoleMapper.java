package com.whr.mapper;

import com.whr.model.SysUserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserRoleMapper extends Mapper<SysUserRole> {
   List<SysUserRole> selectByUserId(int userId);
}