package com.xqx.service;

import com.xqx.model.SysUser;

/**
 * Created by Lyon on 2016/12/6.
 */
public interface UserService {
    SysUser create(SysUser user);
    void update(SysUser user);

}
