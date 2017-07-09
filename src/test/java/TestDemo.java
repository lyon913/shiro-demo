import com.whr.mapper.SysUserMapper;
import com.whr.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Lyon on 2017/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/root-context.xml"})
public class TestDemo {
    @Autowired
    private SysUserMapper userMapper;

    @Test
    @Transactional
    public void testSomthing(){
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
    }
}
