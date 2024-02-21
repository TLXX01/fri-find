package com.itw.user_center.service;
import java.util.Date;

import com.itw.user_center.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class redisTest {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增
        valueOperations.set("yclmString","dog");
        valueOperations.set("yclmInt",1);
        valueOperations.set("yclmDouble",2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("yclm");

        valueOperations.set("yclmUser", user);

        System.out.println("======================================");
        //查
        Object yclm = valueOperations.get("yclmString");
        Assertions.assertTrue( "dog".equals((String)yclm));
        yclm = valueOperations.get("yclmInt");
        Assertions.assertTrue( 1 == (Integer) yclm );

        yclm = valueOperations.get("yclmDouble");
        Assertions.assertTrue( 2.0 == (Double) yclm );
        System.out.println(valueOperations.get("yclmUser"));
    }

}
