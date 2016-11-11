package com.xqx.test.model;

/**
 * 系统权限
 * Created by Lyon on 2016/11/10.
 */
public class SysPermission extends BaseIdEntity {
    /**
     * 权限类型
     */
    private String type;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限值
     */
    private String permission;

    /**
     * 描述
     */
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
