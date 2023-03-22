package javaBasic.interfaceBasic;

/**
 * @name: DemoFunction2
 * @author: Mubai.Wang
 * @date: 2023/3/10
 * @version: 1.0
 * @description: 一个携带入参和返参泛型的函数式接口
 */
@FunctionalInterface
public interface DemoFunction2<R> {
    R data();
}
