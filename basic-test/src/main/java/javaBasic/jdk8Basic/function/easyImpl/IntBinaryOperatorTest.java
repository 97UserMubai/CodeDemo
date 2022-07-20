package javaBasic.jdk8Basic.function.easyImpl;

import java.util.function.IntBinaryOperator;

/**
 * @Classname IntBinaryOperatorTest
 * @Description TODO
 * @Date 2022-7-17 17:56
 * @Created by mubai
 */
public class IntBinaryOperatorTest {
    /**
     * IntBinaryOperator 类型与一个BiFunction<Integer,Integer,Integer>的简化使用
     * 提供applyAsInt方法，用于两个int类型的入参，同时返回一个int类型的值
     * 参数定义里面两个参数分别命名为left 和 right ，并且该接口有Binary字样，TODO 查询一下该函数再二叉树的场景中是否有特别的应用
     */
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (x, y) -> {
            int fact1 = 1;
            for (int i = 2; i <= x; i++) {
                fact1 *= i;
            }
            int fact2 = 1;
            for (int i = 2; i <= y; i++) {
                fact2 *= i;
            }
            return fact1 / fact2;
        };
        System.out.println("5! divided by 7! = "
                + intBinaryOperator.applyAsInt(5, 7));
        System.out.println("7! divided by 5! = "
                + intBinaryOperator.applyAsInt(7, 5));
    }
}
