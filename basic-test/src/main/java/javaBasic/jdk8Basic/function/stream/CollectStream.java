package javaBasic.jdk8Basic.function.stream;

import es.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Classname MapStream
 * @Description TODO
 * <pre>
 *     这个类用于测试如果熟练将Java Function 的函数类熟练的和Java Stream结合
 * </pre>
 * @Date 2022-6-12 11:04
 * @Created by mubai
 */
public class CollectStream {

    public static void main(String[] args) {
        System.out.println("debug");
        getMapStream();
    }


    /**
     * 该方法用于测试Stream Collectors提供的toMap方法
     * 应用的业务场景如下：
     * 1.使用toMap(Function,Function)方法时，key为bean中的组合key
     * 2.使用toMap(Function,Function,BinaryFunction)方法实现重复key的处理问题
     * 在应用场景中toMap的第三个参数可能会因为value存在null值而出现NPE
     */
    public static void getMapStream() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, 18, "小明", "key1"));
        students.add(new Student(1L, 19, "小红", "key2"));
        students.add(new Student(2L, 20, "小王", "key3"));
        //释放下面这行代码，在进行toMap重复key的合并的时候会出现NPE
//        students.add(new Student(2L, null, "小黄", "key4"));
        Map<String, Student> studentMap = students.stream().collect(Collectors.toMap(Student.havingKey, Function.identity()));
        System.out.println("使用Student内部定义的Function方法来实现Key的自定义");
        System.out.println(studentMap.keySet());
        //使用toMap<Function,Function,BinaryOperator>进行重复key的操作
        //todo 这个位置的minAgeBy通过比较年纪，当id相同时，以最大的value进行处理
        Map<Long, Student> studentMap2 = students.stream().collect(Collectors.toMap(Student::getId, Function.identity(), Student.minAgeBy));
        System.out.println("使用BinaryOperator进行map重复Key的合并");
        System.out.println(studentMap2.keySet());
        System.out.println("debug");
    }


    /**
     * 进行stream的性能比较测试，一般业务场景中，通过stream获取list对象，或者进行比较的过滤，合并操作
     * 上述操作在没有stream之前，一般都是通过foreach遍历后编写业务代码来实现，而在这块业务代码中，可能会产生很多的局部变量
     * 在stream流的操作中通过java8的function接口，实现用最小的内存来实现相同的业务需求
     * 而本身Stream对象是否对集合对象的寻址有一定的优化还需要进行考察
     */
    public void testStreamPerformance() {

    }


}
