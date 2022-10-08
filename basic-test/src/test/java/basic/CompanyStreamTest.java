package basic;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @name: CompanyStreamTest
 * @author: Mubai.Wang
 * @date: 2022/10/8
 * @version: 1.0
 * @description:
 */
public class CompanyStreamTest {

    @Test
    public void testSkipAndLimit() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("-------test skip--------");
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("-------test limit --------");
        list.stream().limit(2).forEach(System.out::println);
    }

    /**
     * peek操作 将一个流元素处理完成之后会马上生成一个新的流继续执行中间操作
     */
    @Test
    public void testPeek() {
        List<String> list = new ArrayList<>();
        list.add("zhuhai");
        list.add("guangzhou");
        list.add("foshan");
        list.stream().peek(x -> System.out.println("welcome to " + x))
                .peek(x -> System.out.println("welcome to " + x + " again"))
                .forEach(System.out::println);
        //output:
        //welcome to zhuhai
        //welcome to zhuhai again
        //zhuhai
        //welcome to guangzhou
        //welcome to guangzhou again
        //guangzhou
        //welcome to foshan
        //welcome to foshan again
        //foshan
        System.out.println("-------- center line --------");
        list.stream().peek(x -> System.out.println("welcome to " + x))
                .map(x -> x + " 123")
                .forEach(System.out::println);
        //output:
        //welcome to zhuhai
        //zhuhai 123
        //welcome to guangzhou
        //guangzhou 123
        //welcome to foshan
        //foshan 123
    }

    @Test
    public void testMatch() {
        Stream<String> stream = Stream.of("ab", "ac", "bc");
        //anyMatch相当于or
        boolean isMatch = stream.anyMatch(s -> s.contains("b"));
        System.out.println("anyMatch:" + isMatch);
        //allMatch相当于and
        Stream<String> stream2 = Stream.of("ab", "ac", "bc");
        boolean isMatch2 = stream2.allMatch(s -> s.contains("b"));
        System.out.println("allMatch:" + isMatch2);
        //nonMatch相当于!or
        Stream<String> stream3 = Stream.of("ab", "ac", "bc");
        boolean isMatch3 = stream3.noneMatch(s -> s.contains("c"));
        System.out.println("noneMatch:" + isMatch2);
    }

    /**
     * findAny方法匹配得到optional()对象在get的时候返回的依然有序流的第一个元素
     * 但是如果开启了并行则不一定返回第一个
     */
    @Test
    public void testFindAny() {
        System.out.println("---------test  normal----------");
        //output: always is 6
        for (int i = 1; i <= 20; i++) {
            Stream<Integer> stream = Stream.of(1, 3, 6, 5, 7, 8, 9);
            Optional<Integer> value = stream.filter(x -> x > 3).findAny();
            value.ifPresent(System.out::println);
        }
        //output: more time is 7 ,sometimes is 6
        System.out.println("---------test parallel----------");
        for (int i = 1; i <= 20; i++) {
            Stream<Integer> stream = Stream.of(1, 3, 6, 5, 7, 8, 9);
            Optional<Integer> value = stream.parallel().filter(x -> x > 3).findAny();
            value.ifPresent(System.out::println);
        }
        //output: always is 6
        System.out.println("---------test unordered----------");
        for (int i = 1; i <= 20; i++) {
            Stream<Integer> stream = Stream.of(1, 3, 6, 5, 7, 8, 9);
            Optional<Integer> value = stream.unordered().filter(x -> x > 3).findAny();
            value.ifPresent(System.out::println);
        }
        //结论：unordered不会影响findAny结果，并行处理时会影响
        System.out.println("---------test parallel again----------");
        Map<Integer, Long> valueMap = new HashMap<>();
        valueMap.put(5, 0L);
        valueMap.put(6, 0L);
        valueMap.put(7, 0L);
        valueMap.put(8, 0L);
        for (int i = 1; i <= 10000000; i++) {
            Stream<Integer> stream = Stream.of(1, 3, 6, 5, 7, 8);
            Optional<Integer> value = stream.parallel().filter(x -> x > 3).findAny();
            value.ifPresent(integer -> valueMap.put(integer, valueMap.get(integer) + 1));
        }
        System.out.println("the result size of 5 : " + valueMap.get(5));
        System.out.println("the result size of 6 : " + valueMap.get(6));
        System.out.println("the result size of 7 : " + valueMap.get(7));
        System.out.println("the result size of 8 : " + valueMap.get(8));

        System.out.println("---------test parallel again with sort list----------");
        //output:
        //the result size of 5 : 8402482
        //the result size of 6 : 1575073
        //the result size of 7 : 3
        //the result size of 8 : 22442
        //多次测试结果可以发现 filter-findAny得到的结果并不均匀
        //这个位置测试换成有序流
        valueMap.put(5, 0L);
        valueMap.put(6, 0L);
        valueMap.put(7, 0L);
        valueMap.put(8, 0L);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(7);
        list.add(8);
        for (int i = 1; i <= 10000000; i++) {
            Stream<Integer> stream = list.stream();
            Optional<Integer> value = stream.parallel().filter(x -> x > 3).findAny();
            value.ifPresent(integer -> valueMap.put(integer, valueMap.get(integer) + 1));
        }
        System.out.println("the result size of 5 : " + valueMap.get(5));
        System.out.println("the result size of 6 : " + valueMap.get(6));
        System.out.println("the result size of 7 : " + valueMap.get(7));
        System.out.println("the result size of 8 : " + valueMap.get(8));
        //output:
        //the result size of 5 : 8602863
        //the result size of 6 : 1378390
        //the result size of 7 : 3
        //the result size of 8 : 18744

        //结论1：Stream.of返回的是一个有序流
        //结论2：并行处理结果并不均匀并且耗时比不开并行要慢，所以在使用filter的时候不需要开并行的情况下要用parallel方法
    }

}
