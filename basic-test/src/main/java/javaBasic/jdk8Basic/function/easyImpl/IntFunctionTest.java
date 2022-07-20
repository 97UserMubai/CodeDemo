package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.IntFunction;

/**
 * @Classname IntFunctionTest
 * @Description TODO
 * @Date 2022-7-20 22:37
 * @Created by mubai
 */
public class IntFunctionTest {
    public static void main(String[] args) {
        IntFunction<String> intFunction = String::valueOf;

        System.out.println("简单测试：" + intFunction.apply(22));
    }
}
