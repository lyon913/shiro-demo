package com.xqx.test.model;

/**
 * 角色
 * Created by Lyon on 2016/11/10.
 */
public class SysRole extends BaseEntity {
    /**
     * 角色值，主键
     * 例如：ROLE_AMDIN,ROLE_USER
     */
    private String role;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
