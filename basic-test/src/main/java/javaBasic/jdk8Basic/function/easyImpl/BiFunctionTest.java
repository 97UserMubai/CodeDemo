package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.BiFunction;

/**
 * @Classname BiFunctionTest
 * @Description TODO
 * @Date 2022-7-15 18:03
 * @Created by mubai
 */
public class BiFunctionTest {
    /**
     * 和Function类相比，BiFunction，提供了两个入参
     * 并且andThen方法的入参是一个Function对象，因为BiFunction的outPut只有一个参数
     */
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        System.out.println("sum:" + add.apply(1, 2));

        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        System.out.println("multiply:" + multiply.apply(1, 2));

        System.out.println("multiply andThen * 3 : " + multiply.andThen(a -> a * 3).apply(1, 2));

    }

}
