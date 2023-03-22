package javaBasic.interfaceBasic;

/**
 * @name: DemoFunction
 * @author: Mubai.Wang
 * @date: 2023/3/9
 * @version: 1.0
 * @description:
 */
@FunctionalInterface
public interface DemoFunction<T> {
    T data();
}
