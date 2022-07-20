package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.Function;

/**
 * @Classname FunctionTest
 * @Description TODO
 * @Date 2022-7-17 17:43
 * @Created by mubai
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, String> function = s -> s + " test";

        System.out.println("Function 简单测试：" + function.apply("123"));

        function = function.compose(s -> s + " || append");

        System.out.println("Function compose test: " + function.apply("234"));

        Function<Double, Double> function1 = Function.identity();

        System.out.println("Function identify test:" + function1.apply(2.22));

    }


}
