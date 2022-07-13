package javaBasic.jdk8Basic.function.actualUse;

import es.entity.Student;

import java.util.function.Function;

/**
 * @name: ActualUseTest
 * @author: mubai.
 * @date: 2022/7/13
 * @version: 1.0
 * @description: 实际场景中会使用的function案例
 */
public class ActualUseTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(11);
        student.setName("test");
        testFunction(student, Student::getName);
        testFunction(student, student1 -> String.valueOf(student.getAge()));
    }

    /**
     * 定义一个<W>泛型的void方法
     * 这是一个简单的测试案例，用于测试相同业务场景不同实现的情况
     * 例如：
     * 短信预警服务有多种类型，前置条件里面每个类型需要加工的业务对象不一致
     * 但是最后都需要调用短信发送的公共方法，但是这个公共方法需要根据不同类型来获取对应的存储内容
     * 要实现上面这个需求，就需要定义泛型，那么这个泛型
     *
     * @param <W> 泛型W
     */
    public static <W> void testFunction(W object, Function<W, String> function) {
        System.out.println(function.apply(object));
    }
}
