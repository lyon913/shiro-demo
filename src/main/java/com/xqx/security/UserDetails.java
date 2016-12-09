package com.xqx.security;

import java.util.List;

/**
 * 用户信息接口，用于用户认证
 * Created by Lyon on 2016/10/30.
 */
public interface UserDetails {
    /**
     * 取用户登录名
     *
     * @return 用户登录名
     */
    String getLoginName();

    /**
     * 取用户密码
     *
     * @return 用户密码
     */
    String getPassword();


    /**
     * 取用户角色
     *
     * @return 角色
     */
    List<String> getAuthorities();

    /**
     * 账户是否启用
     *
     * @return 账户启用状态
     */
    boolean isAccountEnabled();

    /**
     * 账户是否未锁定
     *
     * @return 账户未锁定状态
     */
    boolean isAccountNonLocked();

    /**
     * 账户是否未过期
     *
     * @return 账户未过期状态
     */
    boolean isAccountNonExpired();

}
