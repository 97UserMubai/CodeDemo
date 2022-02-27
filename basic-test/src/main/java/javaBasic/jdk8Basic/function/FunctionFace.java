package javaBasic.jdk8Basic.function;

/**
 * @name: FunctionFacse
 * @author: mubai.
 * @date: 2022/1/19
 * @version: 1.0
 * @description: 进行java8函数式接口的测试
 * <pre>
 *     java8针对接口新增了如下特性：
 *     1、函数式接口(只包含一个需要实现的接口，使用@FunctionalInterface进行修饰)
 *     2、静态方法和default接口不会编译报错，实现类可以直接调用父接口的默认/静态方法，也可以进行重写
 * </pre>
 */
@FunctionalInterface
public interface FunctionFace {
    void method();

    default String defaultMethod(){
            return "Default method from super interface";
    }

}
