package com.xqx.model;

/**
 * 用户和角色关系
 * Created by Lyon on 2016/11/10.
 */
public class SysUserRole extends BaseEntity{
    private String userId;
    private String role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
