package javaBasic.jdk8Basic.function.factorial;

import javaBasic.jdk8Basic.function.IntCall;

public class FactorialTest {
    static IntCall intCall;

    public static void main(String[] args) {
        intCall = n -> n <= 0 ? 1 : n * intCall.call(n - 1);
        System.out.println("递归结果:");
        for (int i = 0; i < 10; i++) {
            System.out.println(intCall.call(i));
        }

        System.out.println("普通结果:");
        for (int i = 0; i < 10; i++) {
            System.out.println(normalFactorial(i));
        }

    }

    public static int normalFactorial(int i) {
        if (i <= 0) {
            return 1;
        }
        return i * normalFactorial(i - 1);
    }
}
