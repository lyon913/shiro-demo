package com.xqx.test.model;

/**
 * 角色和权限关系
 * Created by Lyon on 2016/11/10.
 */
public class SysRolePermission {
    /**
     * 角色
     */
    private String role;

    /**
     * 权限id
     */
    private String permissionId;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
