package com.code.lock;

/**
 * @Classname Lock
 * @Description 锁接口
 * @Date 2022-9-11 23:10
 * @Created by mubai
 */
public interface Lock {

    /**
     * 申请锁资源
     *
     * @param lockName 锁名称
     * @param waitTime 锁申请等待时间
     * @param useTime  锁占用时间
     * @return boolean
     */
    boolean applyLock(String lockName, long waitTime, long useTime);


    /**
     * 释放锁资源
     *
     * @param lock     锁对象
     * @param lockName 锁名称
     * @return boolean
     */
    boolean releaseLock(Lock lock, String lockName);
}
