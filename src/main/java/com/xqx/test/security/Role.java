package com.xqx.test.security;

/**
 * 系统角色定义枚举类
 * Created by Lyon on 2016/10/30.
 */
public enum Role {

    ROLE_ADMIN("ROLE_ADMIN","超级管理员","系统超级管理员，拥有系统用户、权限管理职能。");


    private String role;
    private String roleName;
    private String description;

    Role(String role,String roleName,String description){
        this.role = role;
        this.roleName = roleName;
        this.description = description;
    }
}
