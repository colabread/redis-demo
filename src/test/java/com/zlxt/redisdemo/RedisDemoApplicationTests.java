package com.zlxt.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    private JedisUtils jedisUtils;

    @Test
    public void contextLoads() throws InterruptedException {

        String key = "3";
        String value = "{name : 'clearlove', age : 25}";
        System.out.println(jedisUtils.set(key, value));
        Thread.sleep(3000);
        System.out.println(jedisUtils.get(key));

        //
        System.out.println(jedisUtils.set("4", "{name : 'faker', age : 23}"));
        //

        Thread.sleep(3000);
        System.out.println(jedisUtils.get(key));

        //
        System.out.println(jedisUtils.get("4"));
        Thread.sleep(3000);
        System.out.println(jedisUtils.get("4"));
        //
    }

}
