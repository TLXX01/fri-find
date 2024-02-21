package com.itw.user_center.once;
import java.util.Date;

import com.itw.user_center.mapper.UserMapper;
import com.itw.user_center.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

    /**
     * 插入用户
     */
    //@Scheduled(fixedDelay = 5000) 定时任务
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final  int INSERT_USER  = 10000000;
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
            user.setTags("['Java']");
            userMapper.insert(user);
        }
        stopWatch.stop();
        stopWatch.getTotalTimeMillis();
    }


}
