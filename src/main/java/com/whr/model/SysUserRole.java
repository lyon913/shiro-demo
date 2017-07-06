package com.whr.model;

/**
 * 用户和角色关系
 * Created by Lyon on 2016/11/10.
 */
public class SysUserRole extends BaseEntity{
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
        this.sysRole = sysRole;
    }

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }
}
