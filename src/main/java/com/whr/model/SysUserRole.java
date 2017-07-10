package com.whr.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;

public class SysUserRole implements GrantedAuthority {

    @Column(name = "sys_user_id")
    private Integer sysUserId;

    @Column(name = "sys_role")
    private String sysRole;

    @Column(name = "sys_role_name")
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