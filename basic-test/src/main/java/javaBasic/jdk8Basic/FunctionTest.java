package javaBasic.jdk8Basic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        System.out.println("------------开始测试Consumer接口-------------");

        testConsumer(6000, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("崖今天出粮了，收入" + aDouble + ",时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
            }
        });
        testConsumer(8000, money -> System.out.println("崖今天也出粮了，收入" + money +
                ",时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))));

        System.out.println("------------开始测试Supplier接口-------------");
        Supplier<String> supplier = () -> "快告诉老婆，今天发工资了";
        System.out.println(supplier.get());


        System.out.println("------------开始测试Function接口-------------");
        Function<Integer, Integer> function1 = e -> e * 2;
        Function<Integer, Integer> function2 = e -> e * e;
        //输出4
        System.out.println(function1.apply(2));
        //输出18
        System.out.println(function1.compose(function2).apply(3));
        //输出36
        System.out.println(function1.andThen(function2).apply(3));


        System.out.println("------------开始测试Predicate接口-------------");
        Predicate<Integer> predicate = t -> t > 0;
        //true
        System.out.println(predicate.test(1));
        Predicate<String> predicate1 = s -> s.length() > 0;
        Predicate<String> predicate2 = Objects::nonNull;
        //true
        System.out.println(predicate1.and(predicate2).test("测试"));
        //false
        System.out.println(predicate1.negate().test("取反"));
        //true
        System.out.println(Predicate.isEqual("test").test("test"));
        //false
        System.out.println(Predicate.isEqual("test").test("test1"));
        //false
        System.out.println(Predicate.isEqual(null).test("test2"));
        //true
        System.out.println(Predicate.isEqual(null).test(null));


        System.out.println("------------开始测试函数式接口-------------");
        FunctionFace functionFace = new FunctionFaceImpl();
        FunctionFace functionFace1 = new FunctionFace2Impl();
        functionFace.method();
        System.out.println(functionFace.defaultMethod());
        functionFace1.method();
        System.out.println(functionFace1.defaultMethod());
    }

    /**
     * 使用消费性接口
     * 要点一：函数式接口本身也是interface关键字定义的，所以可以当成对象进行入参
     * 要点二：通过函数式接口提供的唯一方法进行调用
     * 要点三：使用默认方法andThen进行再次消费
     * <p>
     * 总结：当一个方法使用了函数式接口，就在使用该方法的时候，需要内部实现Consumer接口
     */
    public static void testConsumer(double money, Consumer<Double> consumer) {
        //这个位置的accept方法的入参T为方法的入参money，等于这个位置进行了consumer accept方法的实现，同时调用了Consumer父接口的default方法andThen
        consumer.andThen(consumer).accept(money);
    }
}
