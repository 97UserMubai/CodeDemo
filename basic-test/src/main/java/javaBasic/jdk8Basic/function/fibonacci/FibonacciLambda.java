package javaBasic.jdk8Basic.function.fibonacci;

/**
 * 斐波那契函数的lambda实现过程
 */
public class FibonacciLambda {

    IntCall fib;

    FibonacciLambda() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        FibonacciLambda rf = new FibonacciLambda();
        for (int i = 0; i <= 10; i++)
            System.out.println(rf.fibonacci(i));
    }

}
