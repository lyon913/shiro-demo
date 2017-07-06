package com.whr.security;

import com.whr.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * Created by Lyon on 2017/7/6.
 */
public class SecurityUtils {
    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static UserDetails getCurrentUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static SysUser getCurrentUser() {
        return (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 判断用户是否有某个权限
     *
     * @param role
     * @return
     */
    public static boolean hasRole(SysRole role) {
        //空值直接返回否
        if (StringUtils.isEmpty(role)) {
            return false;
        }

        //遍历当前用户权限并判断
        Collection<? extends GrantedAuthority> authorities = getCurrentUserDetails().getAuthorities();
        for (GrantedAuthority a : authorities) {
            if (role.getName().equals(a.getAuthority())) {
                //权限判断肯定
                return true;
            }
        }

        //判断否定
        return false;
    }

    /**
     * 判断给定的用户id是否为当前登录用户
     *
     * @param userId
     * @return
     */
    public static boolean isMe(Integer userId) {
        long myId = getCurrentUser().getId();
        return myId == userId;
    }

    /**
     * 判断给定的用户登录名是否为当前登录用户
     *
     * @param loginName 登录名
     * @return
     */
    public static boolean isCurrentUser(String loginName) {
        String myId = getCurrentUser().getLoginName();
        return loginName.equals(myId);
    }

    /**
     * 获取当前登录用户ID
     *
     * @return
     */
    public static Integer getUserId() {
        return getCurrentUser().getId();
    }
}
