package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleFunction;

/**
 * @Classname DoubleFunctionTest
 * @Description TODO
 * @Date 2022-7-16 22:36
 * @Created by mubai
 */
public class DoubleFunctionTest {
    /**
     * Function类的Double变种，支持double类型的入参，并返回一个R
     * 因为固定了一个入参，所以只需要定义一个固定的返回参数类型
     */
    public static void main(String[] args) {
        DoubleFunction<String> doubleFunction = String::valueOf;

        DoubleFunction<String> doubleFunction1 = d -> String.valueOf(d * 2);

        System.out.println(doubleFunction.apply(2.0));

        System.out.println(doubleFunction1.apply(2.0));
    }
}
