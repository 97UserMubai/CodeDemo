package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.DoubleUnaryOperator;

/**
 * @Classname DoubleUnaryOperatorTest
 * @Description TODO
 * @Date 2022-7-17 16:51
 * @Created by mubai
 */
public class DoubleUnaryOperatorTest {

    /**
     * DoubleUnaryOperator 表示一元运算的double 函数，其提供四个函数
     * identity 返回一个入参本身
     * applyAsDouble 进行定义的函数计算，并返回一个double值
     * andThen
     * compose 对一个已经定义的DoubleUnaryOperator进行重新定义，其结果是，会进行compose定义的内容先执行，再执行原始对象定义的内容
     * 相当于将andThen的顺序调换，通过builder的形式进行实现
     * e.g: a->a*2+1 , compose(a-a*3); 输入2 ，得到的计算顺序为 2*3=6->6*2+1 = 13
     */
    public static void main(String[] args) {
        //这个位置就像是一个Function<Double,Double> function = Function.identity() 的实现
        DoubleUnaryOperator doubleUnaryOperator = DoubleUnaryOperator.identity();

        System.out.println("DoubleUnaryOperator identify 测试:" + doubleUnaryOperator.applyAsDouble(12.0));

        DoubleUnaryOperator doubleUnaryOperator1 = d -> d * 12 + 1;

        System.out.println("DoubleUnaryOperator applyAsDouble 测试：" + doubleUnaryOperator1.applyAsDouble(12));

        System.out.println("DoubleUnaryOperator identify applyAsDouble andThen 测试:" + doubleUnaryOperator
                .andThen(doubleUnaryOperator1).applyAsDouble(4));

        doubleUnaryOperator1 = doubleUnaryOperator1.compose(d -> d / 2);

        System.out.println("DoubleUnaryOperator compose 测试：" + doubleUnaryOperator1.applyAsDouble(12));

    }

}
