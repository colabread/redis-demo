package com.zlxt.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisUtils {

    @Autowired
    private JedisPool jedisPool;

    public String set(String key, String value){
        Jedis jedis = jedisPool.getResource();  //获取一个连接
        try {
            //NX：只有当key不存在时才set，XX：只有当key存在的时候才set
            //EX：秒，PX：毫秒
            return jedis.set(key, value, "NX", "EX", 5);
        }finally {
            jedis.close();
        }
    }

    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        }finally {
            jedis.close();
        }
    }

}
