package com.whr.service;

import com.whr.model.SysUser;

/**
 * Created by Lyon on 2016/12/6.
 */
public interface SysUserService {
    SysUser create(SysUser user);
    void update(SysUser user);

}
