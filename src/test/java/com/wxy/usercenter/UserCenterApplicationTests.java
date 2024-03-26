package com.wxy.usercenter;

import com.wxy.usercenter.mapper.UserMapper;
import com.wxy.usercenter.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
//@RunWith(SpringRunner.class)
class UserCenterApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        System.out.println("xxx");
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5,userList.size());
        userList.forEach(System.out::println);
    }

}
