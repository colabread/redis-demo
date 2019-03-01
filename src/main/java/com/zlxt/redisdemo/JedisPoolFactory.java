package com.zlxt.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisPoolFactory {

    //自动注入redis配置属性文件
    @Autowired
    private RedisProperties redisProperties;

    @Bean()
    public JedisPool getJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
        config.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
        config.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
        config.setMaxWaitMillis(redisProperties.getJedis().getPool().getMaxWait().toMillis());
        JedisPool pool = new JedisPool(config, redisProperties.getHost(), redisProperties.getPort(),100 , redisProperties.getPassword());
        return pool;
    }

}
