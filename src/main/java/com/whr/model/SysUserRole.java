package com.whr.model;

import org.springframework.security.core.GrantedAuthority;

public class SysUserRole implements GrantedAuthority{
    private Integer id;

    private Integer sysUserId;

    private String sysRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysRole() {
        return sysRole;
    }

    public void setSysRole(String sysRole) {
        this.sysRole = sysRole == null ? null : sysRole.trim();
    }

    //=================   GrantedAuthority ========================
    @Override
    public String getAuthority() {
        return this.getSysRole();
    }
}