package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.BiPredicate;

/**
 * @Classname BiPredicateTest
 * @Description TODO
 * @Date 2022-7-16 13:11
 * @Created by mubai
 */
public class BiPredicateTest {

    /**
     * BiPredicate和Predicate接口拥有相同的函数定义，区别在于该接口支持两个入参
     * 这里进行test and negate or 四个函数的测试
     */
    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = String::equals;

        BiPredicate<String, String> biPredicate1 = String::contains;

        BiPredicate<String, String> biPredicate2 = String::startsWith;

        System.out.println(biPredicate.test("1", "2"));

        System.out.println(biPredicate1.test("1", "2"));

        System.out.println(biPredicate2.test("1", "2"));

        System.out.println(biPredicate1.or(biPredicate2).test("12", "2"));

        System.out.println(biPredicate1.and(biPredicate2).test("12", "2"));


    }

}
