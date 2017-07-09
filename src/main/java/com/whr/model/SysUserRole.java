package com.whr.model;

import org.springframework.security.core.GrantedAuthority;

public class SysUserRole implements GrantedAuthority {

    private Integer sysUserId;

    private String sysRole;

    private String sysRoleName;

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

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName == null ? null : sysRoleName.trim();
    }

    //=================   GrantedAuthority ========================
    @Override
    public String getAuthority() {
        return this.getSysRole();
    }
}