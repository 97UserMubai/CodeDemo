package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.Consumer;

/**
 * @Classname ConsumerTest
 * @Description TODO
 * @Date 2022-7-16 22:05
 * @Created by mubai
 */
public class ConsumerTest {
    /**
     * Consumer 消费者function函数，核心方法是accept，该函数需要一个入参，但是不需要任何返回内容
     */
    public static void main(String[] args) {
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(1);

        Consumer<Integer> consumer1 = a -> System.out.println(a * 2);

        consumer.andThen(consumer1).accept(2);
    }
}
