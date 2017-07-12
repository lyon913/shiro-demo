package com.whr.mapper;

import com.whr.dto.SysUserQueryKey;
import com.whr.model.BusStaffInfoWithBLOBs;
import com.whr.model.SysUser;
import com.whr.model.SysUserRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private BusStaffInfoMapper sm;

    @Test
    @Transactional
    public void insertUserAndRolesTest(){
        SysUser u = new SysUser();
        u.setAccEnabled(true);
        u.setLoginName("admin");
        u.setPwd("password");
        u.setStaffNo("STAFF-" + System.currentTimeMillis());
        u.setOpCreate("admin");
        u.setOpModify("admin");
        u.setGtmCreate(new Date());
        u.setGtmModify(new Date());
        u.setAccEnabled(true);
        userMapper.insert(u);

        SysUserRole role = new SysUserRole();
        role.setSysUserId(u.getId());
        role.setSysRole("ROLE_ADMIN");
        roleMapper.insert(role);

        SysUserRole role2 = new SysUserRole();
        role2.setSysUserId(u.getId());
        role2.setSysRole("ROLE_USER");
        roleMapper.insert(role2);

        SysUser user = userMapper.selectByLoginName("admin");
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getLoginName());
        Assert.assertEquals(true,u.isEnabled());

        List<SysUserRole> roles = roleMapper.selectBySysUserId(u.getId());
        Assert.assertEquals(2, roles.size());

        BusStaffInfoWithBLOBs staff = new BusStaffInfoWithBLOBs();
        staff.setStaffNo(u.getStaffNo());
        staff.setShortName("STF");
        byte[] bytes_test = "test".getBytes();
        staff.setCardFront(bytes_test);
        sm.insert(staff);

        BusStaffInfoWithBLOBs blob = sm.selectByPrimaryKey(staff.getId());
        Assert.assertArrayEquals(bytes_test,blob.getCardFront());

    }

    @Test
    public void queryTest(){
        SysUserQueryKey key = new SysUserQueryKey();
        key.setLoginName("test1");
        key.setStaffNo("test1");
        key.setStaffName("test1");

        List<SysUser> list =  userMapper.query(key);
        SysUser user = list.get(0);
        Assert.assertEquals("test1", user.getStaffInfo().getStaffName());
    }
}
