package com.code.service.impl;

import com.code.lock.Lock;
import com.code.lock.ReentrantLock;
import com.code.service.IRedisOperate;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @name: RedisStandAloneOperate
 * @author: mubai.
 * @date: 2022/2/21
 * @version: 1.0
 * @description: 单机模式的redis 操作实现类
 * <pre>
 *     基本的全局参数：
 *     1.stringRedisTemplate 默认的redis-starter包里面的string类型的redisTemplate
 *     2.lockFactory  redis锁工厂
 *     3.redissonClient redisson客户端，配合redisson使用，简化一下简单方法的使用
 * </pre>
 */
@Component
public class RedisStandAloneOperate implements IRedisOperate, InitializingBean, DisposableBean {

    private RedissonClient redissonClient;

    /**
     * 尽管使用的jedis的版本是.1.4.1的，但是简单使用redissonClient依然会出现 can't found的异常
     *
     * @param redissonClient
     */
    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * string类型的redisTemplate , 默认使用string类型进行redis存取的序列化方式
     */
    private StringRedisTemplate stringRedisTemplate;

    /**
     * TODO 这个位置使用了Autowired注解，在RedisStrandAloneOperate被引用的时候，会先初始化这个对象，
     * todo 而方法的参数StringRedisTemplate来来自哪里的？
     *
     * @param stringRedisTemplate
     */
    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void set(String key, String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public Lock applyLock(String lockName, long waitTime, long useTime) {
        Lock lock = new ReentrantLock(redissonClient);
        if (lock.applyLock(lockName, waitTime, useTime)) {
            return lock;
        }
        return null;
    }

    @Override
    public Integer generateKey(String key, Integer baseValue) {
        RedisAtomicInteger redisAtomicInteger = new RedisAtomicInteger(key,
                Objects.requireNonNull(stringRedisTemplate.getConnectionFactory()));
        redisAtomicInteger.set(Objects.nonNull(baseValue) ? baseValue : 0);
        return redisAtomicInteger.incrementAndGet();
    }

    @Override
    public void destroy() throws Exception {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
