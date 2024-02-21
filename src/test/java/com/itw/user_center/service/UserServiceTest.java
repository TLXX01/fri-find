package com.itw.user_center.service;

import com.itw.user_center.mapper.UserMapper;
import com.itw.user_center.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Test
    void userRegister() {
    }

    @Test
    void userLogin() {
    }

    @Test
    void getSafetyUser() {
    }

    @Test
    void userLogout() {
    }

    @Test
    void searchUserByTags() {
        List<String> tagNameList = Arrays.asList("java","python");
        List<User> userList = userService.searchUserByTags(tagNameList);
        Assert.assertNotNull(userList);
    }

    @Test
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final  int INSERT_USER  = 100000;
        for (int i = 0; i < INSERT_USER; i++){
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("faker");
            user.setAvatarUrl("https://tse3-mm.cn.bing.net/th/id/OIP-C.1dtI4QakVVdBYf6FcYnZAQAAAA?rs=1&pid=ImgDetMain");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setProfile("我是大魔王");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setUserStatus(0);
            user.setIsDelete(0);
            user.setUserRole(0);
            user.setTags("[]");
            userMapper.insert(user);
        }
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());
    }

    @Test
    public void testIP() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress+"//"+inetAddress.getHostName());

    }
}