package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleBinaryOperator;

/**
 * @Classname DoubleBinaryOperatorTest
 * @Description TODO
 * @Date 2022-7-16 22:14
 * @Created by mubai
 */
public class DoubleBinaryOperatorTest {
    /**
     * DoubleBinaryOperator只提供一个函数接口applyAsDouble
     * 用于接受两个double类型的入参，同时返回一个double的参数
     */
    public static void main(String[] args) {

        DoubleBinaryOperator dbo = Double::sum;

        DoubleBinaryOperator dbo2 = (a, b) -> a * b;

        DoubleBinaryOperator dbo3 = (a, b) -> a / b;

        double a = 1.34;
        double b = 2.59;

        System.out.println(dbo.applyAsDouble(a, b));
        System.out.println(dbo2.applyAsDouble(a, b));
        System.out.println(dbo3.applyAsDouble(a, b));

    }
}
