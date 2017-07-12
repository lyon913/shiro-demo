package com.whr.service;

import com.whr.dto.SysUserQueryKey;
import com.whr.mapper.SysUserMapper;
import com.whr.model.SysUser;
import com.whr.utils.AuditUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lyon on 2017/7/12.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper um;

    @Override
    public SysUser newUser() {
        SysUser u = new SysUser();
        u.setAccEnabled(true);
        return u;
    }

    @Override
    public SysUser getById(int userId) {
        return um.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> query(SysUserQueryKey key) {
        return um.query(key);
    }

    @Override
    @Transactional
    public void saveOrUpdate(SysUser user) {
        AuditUtil.setAudit(user);
        if(user.getId() == null){
            um.insert(user);
        }else{
            um.updateByPrimaryKey(user);
        }
    }
}
