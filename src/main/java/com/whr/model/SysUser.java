package com.whr.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SysUser implements UserDetails{
    private Integer id;

    private String loginName;

    private String password;

    private String staffNo;

    private Boolean enabled;

    private Date expireDate;

    private String ipAddr;

    private String macAddr;

    private String comments;

    private String opCreate;

    private String opModify;

    private Date gtmCreate;

    private Date gtmModify;

    private List<SysUserRole> roles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    //public Boolean getEnabled() {
    //    return enabled;
    //}

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr == null ? null : macAddr.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getOpCreate() {
        return opCreate;
    }

    public void setOpCreate(String opCreate) {
        this.opCreate = opCreate == null ? null : opCreate.trim();
    }

    public String getOpModify() {
        return opModify;
    }

    public void setOpModify(String opModify) {
        this.opModify = opModify == null ? null : opModify.trim();
    }

    public Date getGtmCreate() {
        return gtmCreate;
    }

    public void setGtmCreate(Date gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    public Date getGtmModify() {
        return gtmModify;
    }

    public void setGtmModify(Date gtmModify) {
        this.gtmModify = gtmModify;
    }

    public List<SysUserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysUserRole> roles) {
        this.roles = roles;
    }

    /////       UserDetails           //////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        if(expireDate == null){
            return true;
        }
        return expireDate.compareTo(new Date()) < 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}