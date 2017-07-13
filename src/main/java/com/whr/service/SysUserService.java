package com.whr.service;

import com.whr.dto.SysUserQueryKey;
import com.whr.dto.ValidationResult;
import com.whr.model.SysUser;

import java.util.List;

/**
 * Created by Lyon on 2016/12/6.
 */
public interface SysUserService {
    /**
     * 初始化一个新的SysUser对象
     * @return
     */
    SysUser newUser();

    /**
     * 通过id查找
     * @param userId
     * @return
     */
    SysUser getById(int userId);

    /**
     * 查询
     * @param key
     * @return
     */
    List<SysUser> query(SysUserQueryKey key);

    /**
     * 保存
     * @param user
     */
    void saveOrUpdate(SysUser user);

    /**
     * 删除
     * @param userId
     */
    void delete(int userId);

    /**
     * 验证用户名是否合法
     * @param loginName
     * @return
     */
    ValidationResult validateLoginName(String loginName);

}
