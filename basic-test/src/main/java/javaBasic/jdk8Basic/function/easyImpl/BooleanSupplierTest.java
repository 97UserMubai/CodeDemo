package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.BooleanSupplier;

/**
 * @Classname BooleanSupplierTest
 * @Description TODO
 * @Date 2022-7-16 21:56
 * @Created by mubai
 */
public class BooleanSupplierTest {
    /**
     * BooleanSupplier 是一个简单的返回布尔值的function函数，没有入参，只有一个返回的参数
     * 这是一个类似于Supplier<Boolean>的简化使用
     */
    public static void main(String[] args) {
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println("这是一个简单的BooleanSupplier测试：" + booleanSupplier.getAsBoolean());
    }
}
