package com.code;

import com.code.lock.Lock;
import com.code.service.IRedisOperate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname StandAloneRedisTest
 * @Description 单例类型的redis数据测试
 * @Date 2022-9-11 23:22
 * @Created by mubai
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class StandAloneRedisTest {
    @Autowired
    private IRedisOperate iRedisOperate;

    private static final String LOCK_TEST_KEY = "testApplyLock";

    @Test
    public void testSet() {
        iRedisOperate.set("name", "wangbaitao");
    }

    @Test
    public void testGet() {
        String name = iRedisOperate.get("name");
        Assert.assertEquals(name, "wangbaitao");
    }

    /**
     * 测试锁占用时间
     * 锁占用时间由redis自动释放
     */
    @Test
    public void testApplyLock() {
        Lock lock = iRedisOperate.applyLock(LOCK_TEST_KEY, 10, 60);
        Assert.assertNotNull("成功获取锁资源", lock);
    }

    /**
     * 多线程测试锁等待时间
     * 锁等待时间由redisson进行控制
     */
    @Test
    public void testApplyLockWait() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(16);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, workQueue);
        //这里进行主线程的预热
        executor.prestartAllCoreThreads();
        AtomicInteger integer = new AtomicInteger();
        for (int i = 1; i <= 4; i++) {
            executor.execute(() -> {
                Lock lock = iRedisOperate.applyLock(LOCK_TEST_KEY, 10, 30);
                do {
                    System.out.println("当前线程编号[" + integer.get() + "]尝试获取锁" + (Objects.isNull(lock) ? "失败" : "成功")
                            + ",当前时间：" + LocalDateTime.now());
                } while (Objects.nonNull(lock));
                System.out.println("线程执行结束");
            });
        }
    }

    @Test
    public void testGenerateKey() {
        System.out.println("获取默认自增key:" + iRedisOperate.generateKey("20220912", null));
        System.out.println("获取初始化自增key:" + iRedisOperate.generateKey("20220912", 100));
    }
}
