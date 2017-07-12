package com.whr.service;

import com.whr.dto.SysUserQueryKey;
import com.whr.model.SysUser;

import java.util.List;

/**
 * Created by Lyon on 2016/12/6.
 */
public interface SysUserService {
    SysUser newUser();
    SysUser getById(int userId);
    List<SysUser> query(SysUserQueryKey key);
    void saveOrUpdate(SysUser user);

}
