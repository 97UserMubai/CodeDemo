package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleSupplier;

/**
 * @Classname DoubleSupplierTest
 * @Description TODO
 * @Date 2022-7-17 16:30
 * @Created by mubai
 */
public class DoubleSupplierTest {

    /**
     * Supplier的double类型， 不需要入参，单纯返回一个double类型的值
     */
    public static void main(String[] args) {

        DoubleSupplier doubleSupplier = () -> 2.3;

        System.out.println("double supplier 测试： " + doubleSupplier.getAsDouble());

    }

}
