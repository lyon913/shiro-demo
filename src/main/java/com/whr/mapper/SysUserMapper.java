package com.whr.mapper;

import com.whr.model.SysUser;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {

    SysUser selectByLoginName(String loginName);
}