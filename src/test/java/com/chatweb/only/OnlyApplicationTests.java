package com.chatweb.only;

import com.chatweb.only.tableEntity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlyApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId("12331111");
        user.setAccount("掌声");
        user.setCreationDate(new Date());
        user.setMobile("1172533");
        user.setPassword("123456");
        user.setRealName("哈哈哈哈哈哈哈哈哈哈");
        RedisSerializer defaultSerializer = redisTemplate.getDefaultSerializer();
        System.out.println(defaultSerializer.getClass());
        redisTemplate.opsForValue().set("user", user);
        User redisUser = (User) redisTemplate.opsForValue().get("user");
        System.out.println(redisUser);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testRabbitmq(){
        // rabbitTemplate.convertAndSend("amq.direct","cs", "sss");
        Object receive = rabbitTemplate.receiveAndConvert("测试队列");
        System.out.println(receive);
    }

}

