package com.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Spring Framework 提供的通知容器创建对象的注解
 * （1）@Compoment：通用注解
 * （2）@Service：仅是用来让开发同学看着容易分辨，该实体类主要进行业务处理
 * （3）@Repository：仅是用来让开发同学看着容易分辨，该实体类主要进行数据库相关操作
 * 三个注解功能一样：都是用来通知SpringFramework穿件出该类型的对象
 */

@Component
public class RedisAPI {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    //1.设置值
    public void set(String key , String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }
    //2.设置值以及设置值的过期时间
    public void set(String key, String value, Long expireTime){
        this.redisTemplate.opsForValue().set(key, value);
        this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    //3.针对key设置过期时间
    public void expire(String key, Long expireTime){
        this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    //4.获取数据
    public String get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }
}
