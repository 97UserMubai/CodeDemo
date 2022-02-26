package com.code.service.impl;

import com.code.service.IRedisOperate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @name: RedisStandAloneOperate
 * @author: mubai.
 * @date: 2022/2/21
 * @version: 1.0
 * @description: 单机模式的redis 操作实现类
 */
@Component
public class RedisStandAloneOperate implements IRedisOperate {

    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }
}
