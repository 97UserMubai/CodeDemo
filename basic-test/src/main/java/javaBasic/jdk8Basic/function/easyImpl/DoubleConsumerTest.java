package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleConsumer;

/**
 * @Classname DoubleConsumerTest
 * @Description TODO
 * @Date 2022-7-16 22:29
 * @Created by mubai
 */
public class DoubleConsumerTest {
    /**
     * Consumer的变种，入参为double类型的参数，其他和Consumer一致
     * TODO 或许应该查询一下为啥JAVA 8 要提供大量的Double ,Int ,Long类型独立的Function函数
     */
    public static void main(String[] args) {
        DoubleConsumer doubleConsumer = System.out::println;

        DoubleConsumer doubleConsumer1 = a -> System.out.println(a * 2);

        doubleConsumer.accept(2.0);

        doubleConsumer.andThen(doubleConsumer1).accept(2.4);
    }
}
