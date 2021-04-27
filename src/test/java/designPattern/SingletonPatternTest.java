package designPattern;

import designPattern.singletonPattern.SingletonTest;
import org.junit.Test;

import java.util.Random;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>设计模式测试案例</h>
 * @Date 2021/4/27
 **/
public class SingletonPatternTest {

    @Test
    public void singletonTestOne() {
        designPattern.singletonPattern.SingletonTest singletonTest = designPattern.singletonPattern.SingletonTest.getInstanceNoSafe();
        singletonTest.setName("这是一个测试");
        designPattern.singletonPattern.SingletonTest singletonTest1 = designPattern.singletonPattern.SingletonTest.getInstanceNoSafe();
        singletonTest1.setName("这是最新的测试");
        singletonTest.printInfo();
        singletonTest1.printInfo();
        String name = singletonTest == singletonTest1 ? "这是同一个实例" : "这是不同实例";
        System.out.println(name);
    }

    /**
     * 模拟多线程获取对象
     */
    @Test
    public void singletonTestTwo() {
        for (int i = 1; i <= 100; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }

    @Test
    public void singletonTestThree() {
        for (int i = 1; i <= 100; i++) {
            MyThread2 thread = new MyThread2();
            thread.start();
        }
    }

    @Test
    public void singletonTestFour() {
        for (int i = 1; i <= 100; i++) {
            MyThread3 thread = new MyThread3();
            thread.start();
        }
    }

    @Test
    public void singletonTestFive() {
        for (int i = 1; i <= 100; i++) {
            MyThread4 thread = new MyThread4();
            thread.start();
        }
    }

    class MyThread extends Thread {
        public void run() {
            Random random = new Random();
            designPattern.singletonPattern.SingletonTest singletonTest = designPattern.singletonPattern.SingletonTest.getInstanceNoSafe();
            singletonTest.setCode(random.nextInt(100000));
            System.out.println(singletonTest);
        }
    }

    class MyThread2 extends Thread {
        public void run() {
            Random random = new Random();
            designPattern.singletonPattern.SingletonTest singletonTest = designPattern.singletonPattern.SingletonTest.getInstanceSafeOne();
            singletonTest.setCode(random.nextInt(100000));
            System.out.println(singletonTest);
        }
    }

    class MyThread3 extends Thread {
        public void run() {
            Random random = new Random();
            designPattern.singletonPattern.SingletonTest singletonTest = designPattern.singletonPattern.SingletonTest.getInstanceSafeTwo();
            singletonTest.setCode(random.nextInt(100000));
            System.out.println(singletonTest);
        }
    }

    class MyThread4 extends Thread {
        public void run() {
            Random random = new Random();
            designPattern.singletonPattern.SingletonTest singletonTest = designPattern.singletonPattern.SingletonTest.getInstanceSafeThree();
            singletonTest.setCode(random.nextInt(100000));
            System.out.println(singletonTest);
        }
    }

}
