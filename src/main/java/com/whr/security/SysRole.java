package com.whr.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Lyon on 2017/7/6.
 */
public enum SysRole implements GrantedAuthority {
    ROLE_USER("ROLE_USER", "普通用户", "系统认证的基本用户"),
    ROLE_ADMIN("ROLE_ADMIN", "系统管理员", "管理系统用户、权限及系统设定"),
    ROLE_SL("ROLE_SL", "受理人员", "业务受理员");

    private String name;
    private String displayName;
    private String describe;

    private SysRole(String name, String displayName, String describe) {
        this.name = name;
        this.displayName = displayName;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String getAuthority() {
        return this.name();
    }

}