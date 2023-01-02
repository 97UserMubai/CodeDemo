package basic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @Classname AtomicTest
 * @Date 2022-12-24 21:43
 * @Created by mubai
 * @Description 这个测试针对juc包下面的atomic包的原子类进行测试
 * @see java.util.concurrent.atomic
 * atomic包下的原子类在多线程的环境中发生变更操作时，可以保证不会被其他线程干扰，避免或者降低ABA问题
 * @see java.util.concurrent.atomic.AtomicMarkableReference 这个标记引用原子类只能降低ABA问题出现的概率
 * juc.atomic包下的原子类按照操作目标的类型可以分为四种：
 * <li>更新基本类型例如：AtomicInteger,AtomicLong,AtomicBoolean</li>
 * <li>更新数组类型例如：AtomicIntegerArray,AtomicLongArray,AtomicReferenceArray</li>
 * <li>更新引用类型例如：AtomicReference,AtomicMarkableReference,AtomicStampedReference</li>
 * <li>更新对象的属性类型例如：AtomicIntegerFieldUpdater,AtomicLongFieldUpdater,AtomicReferenceFieldUpdater</li>
 * 简单描述一下背景和实现原理：
 * 1.在不使用原子类时，为了保证线程安全，我们一般通过volatile+synchronize关键字来保证变量的原子性，但是由于synchronized是个悲观锁
 * 所以会导致程序有性能上忧虑
 * 2.在原子类的操作中，会先通过unsafe.objectFieldOffset方法获取操作操作目标的内存地址，源代码如下
 * long valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredFiled("value"))
 * 其中"value"时通过volatile修饰的，保证内存可见，从而让JVM可以获取该变量最新的值
 * 由于上述的这些操作包括原子类对外提供的方法都是native的，最后获取最新的内存地址之后再进行内容的CAS变更，从而保证原子操作
 * 3.简单总结一下：CAS+volatile+native方法保证原子操作，同时避免synchronized的高开销
 */
public class AtomicTest {
    private static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100, false);

    public static void main(String[] args) {
        Thread refT1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicMarkableReference.compareAndSet(100, 101, atomicMarkableReference.isMarked(), !atomicMarkableReference.isMarked());
            atomicMarkableReference.compareAndSet(101, 100, atomicMarkableReference.isMarked(), !atomicMarkableReference.isMarked());
        });

        Thread refT2 = new Thread(() -> {
            boolean marked = atomicMarkableReference.isMarked();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean c3 = atomicMarkableReference.compareAndSet(100, 101, marked, !marked);
            System.out.println(c3); // 返回true,实际应该返回false
        });

        refT1.start();
        refT2.start();
    }
}
