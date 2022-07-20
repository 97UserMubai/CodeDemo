package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleToIntFunction;

/**
 * @Classname DoubleToIntFunctionTest
 * @Description TODO
 * @Date 2022-7-17 16:37
 * @Created by mubai
 */
public class DoubleToIntFunctionTest {

    /**
     * Function<Double,Integer>的简化使用
     */
    public static void main(String[] args) {
        DoubleToIntFunction doubleToIntFunction = d -> (int) d;

        System.out.println("DoubleToIntFunction 简单测试:" + doubleToIntFunction.applyAsInt(10.5));

    }
}
