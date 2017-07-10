package com.whr.mapper;

import com.whr.mapper.SysUserMapper;
import com.whr.mapper.SysUserRoleMapper;
import com.whr.model.SysUser;
import com.whr.model.SysUserRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lyon on 2017/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/root-context.xml"})
public class UserMapperTest {
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper roleMapper;

    @Test
    @Transactional
    public void insertUserAndRolesTest(){
        SysUser u = new SysUser();
        u.setEnabled(true);
        u.setLoginName("admin");
        u.setPassword("password");
        u.setStaffNo("ST-" + System.currentTimeMillis());
        u.setOpCreate("admin");
        u.setOpModify("admin");
        u.setGtmCreate(new Date());
        u.setGtmModify(new Date());
        userMapper.insert(u);

        SysUserRole role = new SysUserRole();
        role.setSysUserId(u.getId());
        role.setSysRole("ROLE_ADMIN");
        role.setSysRoleName("ADMIN");
        roleMapper.insert(role);

        SysUserRole role2 = new SysUserRole();
        role2.setSysUserId(u.getId());
        role2.setSysRole("ROLE_USER");
        role2.setSysRoleName("USER");
        roleMapper.insert(role2);

        SysUser user = userMapper.selectByLoginName("admin");
        Assert.assertNotNull(user.getId());

        List<SysUserRole> roles = roleMapper.selectByUserId(u.getId());
        Assert.assertEquals(2, roles.size());
    }
}
