package javaBasic.jdk8Basic.function.easyImpl;

import es.entity.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Classname BinaryOperatorTest
 * @Description TODO
 * @Date 2022-7-15 23:11
 * @Created by mubai
 */
public class BinaryOperatorTest {

    /**
     * 进行BinaryOperator测试，BinaryOperator提供minBy 和 maxBy两个静态接口，这个回头可以研究一下函数式接口+静态接口的实现可以应用在场景
     * 集合stream流的toMap进行测试
     **/
    public static void main(String[] args) {
        BinaryOperator<Integer> op = BinaryOperator.maxBy(Integer::compareTo);
        System.out.println("BinaryOperator,maxBy:" + op.apply(11, 12));

        BinaryOperator<Integer> op2 = BinaryOperator.minBy(Integer::compareTo);
        System.out.println("BinaryOperator,minBy:" + op2.apply(11, 12));

        Student s1 = new Student(1L, 18, "wang", "key1");
        Student s2 = new Student(1L, 18, "wang", "key2");

        BinaryOperator<Student> op3 = BinaryOperator.maxBy((v1, v2) ->
                v1.getAge() > v1.getAge() ? 1 : (v1.getId().equals(v2.getId()) ? 0 : -1));

        BinaryOperator<Student> op4 = BinaryOperator.minBy((v1, v2) ->
                v1.getAge() > v1.getAge() ? 1 : (v1.getId().equals(v2.getId()) ? 0 : -1));

        /*
         * 在下面的测试中，输出的结果是不一致，所以当Object类型的对象，在Comparator中比较的结果为0时，返回的结果是第一个入参，就是v1
         */
        System.out.println("BinaryOperator,maxBy when Object type values are equal:" + op3.apply(s1, s2));

        System.out.println("BinaryOperator,minBy when Object type values are equal:" + op4.apply(s2, s1));

        /*
         * List是有序的， 所以得到的结果和上面一样规则
         */
        List<Student> testList = new ArrayList<>();
        testList.add(s1);
        testList.add(s2);
        testList.add(new Student(2L, 19, "wang", "key3"));
        testList.add(new Student(2L, 19, "wang", "key4"));
        Map<Long, Student> mergeList = testList.stream().collect(Collectors.toMap(Student::getId,
                Function.identity(), op3));
        System.out.println(mergeList);

        /*
         * set测试时，得到的结果和list一致
         * */
        Set<Student> testSet = new HashSet<>();
        testSet.add(s1);
        testSet.add(s2);
        testSet.add(new Student(2L, 19, "wang", "key3"));
        testSet.add(new Student(2L, 19, "wang", "key4"));
        testSet.add(new Student(2L, 19, "wang", "key5"));
        testSet.add(new Student(2L, 19, "wang", "key6"));
        testSet.add(new Student(2L, 19, "wang", "key7"));
        Map<Long, Student> mergeSet = testSet.stream().collect(Collectors.toMap(Student::getId,
                Function.identity(), op3));
        System.out.println(mergeSet);
    }

}
