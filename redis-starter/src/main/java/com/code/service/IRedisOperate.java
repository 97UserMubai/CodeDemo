package com.code.service;

import com.code.lock.Lock;

/**
 * @name: IRedisOperate
 * @author: mubai.
 * @date: 2022/2/21
 * @version: 1.0
 * @description: 用于redis调用时需要
 */
public interface IRedisOperate {

    /**
     * 设置指定key的value，不进行校验直接覆盖
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 获取key对应的value
     *
     * @param key key
     * @return 获取key对应的value
     */
    String get(String key);

    /**
     * 申请锁资源
     * 这个位置的本质是一个hash类型的key-value
     * useTime会成为expire的设置，当时间超过时redis会自动释放锁资源
     * 而redisson则负责判断当前锁是什么类型的锁，如果是可重入锁，
     * 则会直接在redis中set一个key等待资源的释放,
     * todo 但是在多线程并行的时候并不会在一个hashkey下面看到多个线程的key在排队获取锁，这个可重入锁具体是怎么工作的还需要再检查一下
     *
     * @param lockName 目标锁名称
     * @param waitTime 等待时间
     * @param useTime  占用时间
     * @return Lock
     */
    Lock applyLock(String lockName, long waitTime, long useTime);

    /**
     * 获取一个业务key下面的自增id
     *
     * @param key       key
     * @param baseValue 大于等于0的自增的默认值，为空时默认从0开始
     * @return Integer
     */
    Integer generateKey(String key, Integer baseValue);
}
