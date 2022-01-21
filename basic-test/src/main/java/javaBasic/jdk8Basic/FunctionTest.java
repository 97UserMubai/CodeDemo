package javaBasic.jdk8Basic;

import java.util.function.Consumer;

/**
 * @name: FunctionTest
 * @author: mubai.
 * @date: 2022/1/6
 * @version: 1.0
 * @description: 什么是函数式接口？
 * 1.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。
 * 2.可以通过Lambda表达式来创建该接口的对象。
 * <p>
 * Jdk8中关于Lambda表达式提供的4个基本的函数式接口：
 * 1.Consumer<T> 消费型接口，void类型，对类型为T的对象应用操作，包含方法void accept(T t)
 * 2.Supplier<T> 供给型接口，返回T类型，不需要入参，返回类型为T的对象，包含方法 T get()
 * 3.Function<T,R> 函数型接口，入参T类型，返参R类型，对类型为T的对象应用操作，并返回R类型对象，包含方法 R apply(T t)
 * 4.Predicate<T> 断定性接口，入参T类型，返回布尔值，判断类型为T的对象是否满足某种约束，包含方法 boolean test(T t)
 */
public class FunctionTest {

    public static void main(String[] args) {
        /*
         * 测试案例要点：
         * 1、使用Jdk8提供的基础函数式接口
         * 2、使用lambda表达式去调用该接口
         */
        testConsumer(6000, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("崖今天出粮了，收入" + aDouble);
            }
        });
        testConsumer(8000, money -> System.out.println("崖今天也出粮了，收入" + money));


        System.out.println("------------开始测试函数式接口-------------");
        FunctionFace functionFace = new FunctionFaceImpl();
        FunctionFace functionFace1 = new FunctionFace2Impl();
        functionFace.method();
        System.out.println(functionFace.defaultMethod());
        functionFace1.method();
        System.out.println(functionFace1.defaultMethod());
    }

    /**
     * 要点一：函数式接口本身也是interface关键字定义的，所以可以当成对象进行入参
     * 要点二：通过函数式接口提供的唯一方法进行调用
     */
    public static void testConsumer(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
