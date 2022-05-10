package javaBasic.jdk8Basic.function.fibonacci;

import javaBasic.jdk8Basic.function.IntCall;

/**
 * 斐波那契函数的lambda实现过程
 * 斐波那契数列：
 * 自然数列从第3项开始，每一项都等于前两项之和
 * 1,1,2,3,5,8,13,21,34,55,89
 */
public class FibonacciLambda {

    IntCall fib;

    static int acc = 0;

    /**
     * 在构造函数中初始化IntCall接口的实例，同时用lambda表达式结合函数接口的特点，进行递归处理
     */
    FibonacciLambda() {
        /*
         * 通过两个三元表达式，来做递归判断的出口，最后将递归的结果进行累加
         * 这里最大的区别在于构造函数中直接通过接口函数的特性进行IntCall接口的call方法的内部定义，当实例被回收时对应的实现类也将被直接回收
         * */
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        FibonacciLambda rf = new FibonacciLambda();
        for (int i = 0; i <= 10; i++) {
            System.out.println(rf.fibonacci(i));
        }

        System.out.println("----------------------------------传统递归----------------------------------");

        int i = 11;
        System.out.println(test(i));
        System.out.println("result:" + i);
        System.out.println("计算第10位的斐波那契数总共执行了多少次test==0/1的判断：" + acc);

    }

    /**
     * 传统斐波那契数列实现方式
     */
    public static int test(int i) {
        if (i <= 0) {
            acc++;
            return 0;
        }
        if (i == 1) {
            acc++;
            return i;
        } else {
            return test(i - 1) + test(i - 2);
        }
    }

}
