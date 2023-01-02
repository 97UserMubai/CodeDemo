package com.code.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ReentrantLock
 * @Description 可重入锁
 * @Date 2022-9-11 23:09
 * @Created by mubai
 */
public class ReentrantLock implements Lock {

    /**
     * redisson的rLock
     */
    private RLock rLock;

    private RedissonClient redissonClient;

    public ReentrantLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 申请锁资源
     *
     * @param lockName 锁名称
     * @param waitTime 锁申请等待时间
     * @param useTime  锁占用时间
     * @return 申请结果：成功时为true
     */
    @Override
    public boolean applyLock(String lockName, long waitTime, long useTime) {
        try {
            rLock = redissonClient.getLock(lockName);
            return rLock.tryLock(waitTime, useTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * 释放锁资源
     *
     * @param lock     锁对象
     * @param lockName 锁名称
     * @return 释放锁资源
     */
    @Override
    public boolean releaseLock(Lock lock, String lockName) {
        if (rLock.isHeldByCurrentThread()) {
            try {
                return rLock.forceUnlockAsync().get();
            } catch (InterruptedException | ExecutionException e) {
                return false;
            }
        }
        return false;
    }
}
