package com.whr.mapper;

import com.whr.dto.SysUserQueryKey;
import com.whr.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByLoginName(String loginName);

    List<SysUser> query(SysUserQueryKey key);
}