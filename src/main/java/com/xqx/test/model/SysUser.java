package com.xqx.test.model;

import com.xqx.test.security.UserDetails;

import java.util.Date;
import java.util.List;

/**
 * 用户
 * Created by Lyon on 2016/11/9.
 */
public class SysUser extends BaseAuditEntity implements UserDetails {

    private String loginName;
    private String name;
    private String password;

    private boolean accountEnabled;
    private Date expiredate;

    private List<String> roles;


    ////////////////// UserDetails ////////////////////
    @Override
    public String getLoginName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public List<String> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountEnabled() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    ///////////// //// //////////////



}
