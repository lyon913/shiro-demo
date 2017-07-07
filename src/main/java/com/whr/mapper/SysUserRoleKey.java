package com.whr.mapper;

import com.whr.model.BaseEntity;

public class SysUserRoleKey extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.sys_user_id
     *
     * @mbggenerated
     */
    private Integer sysUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.sys_role
     *
     * @mbggenerated
     */
    private String sysRole;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.sys_user_id
     *
     * @return the value of sys_user_role.sys_user_id
     *
     * @mbggenerated
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.sys_user_id
     *
     * @param sysUserId the value for sys_user_role.sys_user_id
     *
     * @mbggenerated
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.sys_role
     *
     * @return the value of sys_user_role.sys_role
     *
     * @mbggenerated
     */
    public String getSysRole() {
        return sysRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.sys_role
     *
     * @param sysRole the value for sys_user_role.sys_role
     *
     * @mbggenerated
     */
    public void setSysRole(String sysRole) {
        this.sysRole = sysRole == null ? null : sysRole.trim();
    }
}