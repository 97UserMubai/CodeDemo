package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.IntConsumer;

/**
 * @Classname IntConsumerTest
 * @Description TODO
 * @Date 2022-7-20 22:28
 * @Created by mubai
 */
public class IntConsumerTest {
    public static void main(String[] args) {
        IntConsumer intConsumer = a -> {
            System.out.println("这只是一个简单Consumer Integer类型的测试：" + a);
        };

        IntConsumer intConsumer1 = a -> {
            System.out.println("再次简单测试:" + a);
        };

        intConsumer.andThen(intConsumer1).accept(22);
    }
}
