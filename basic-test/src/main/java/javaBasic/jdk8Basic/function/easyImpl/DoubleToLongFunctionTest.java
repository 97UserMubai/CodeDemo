package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleToLongFunction;

/**
 * @Classname DoubleToLongFunctionTest
 * @Description TODO
 * @Date 2022-7-17 16:45
 * @Created by mubai
 */
public class DoubleToLongFunctionTest {
    /**
     * Function<Double,Long>的简化使用
     */
    public static void main(String[] args) {
        DoubleToLongFunction doubleToLongFunction = d -> (long) d;

        System.out.println("DoubleToLongFunction 简单测试：" + doubleToLongFunction.applyAsLong(22222222.333333));
    }
}
