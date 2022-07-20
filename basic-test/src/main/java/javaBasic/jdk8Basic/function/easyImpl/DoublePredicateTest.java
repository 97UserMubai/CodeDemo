package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoublePredicate;

/**
 * @Classname DoublePredicateTest
 * @Description TODO
 * @Date 2022-7-17 16:14
 * @Created by mubai
 */
public class DoublePredicateTest {
    /**
     * 一个指定了double类型入参的，并返回一个布尔值，大体用法和Predicate差不多
     */
    public static void main(String[] args) {
        DoublePredicate doublePredicate = d -> d * 100 < 100;

        DoublePredicate doublePredicate1 = d -> d - 100 > 0;

        System.out.println("test * 100 < 100:" + doublePredicate.test(1.2));

        System.out.println("test *1 00 < 100 and result test - 100 > 0: " + doublePredicate.and(doublePredicate1).test(0.2));

        System.out.println("test *1 00 < 100 or result test - 100 > 0: " + doublePredicate.or(doublePredicate1).test(0.2));
    }
}
