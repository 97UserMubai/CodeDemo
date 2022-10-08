package basic;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Classname Jdk8StreamTest
 * @Description JDK 1.8 Stream 测试
 * <pre>
 *     1.Stream的特性：
 *     ①不存储数据，只按照设定的规则进行数据处理
 *     ②不改变数据源，操作时在原有的数据源创建副本，然后对副本进行处理，生成新的Stream
 *     ③具有惰性化：Stream的很多方法是向后延迟的，需要等到它弄清楚最后需要多少数据时才会开始，中间操作类型的方法则都是惰性化的
 *     ④可以是无限的：集合有固定大小，Stream则不一定，limit(n)和findFirst这类短路的操作，可以对无线的Stream快速完成运算处理
 *     ⑤支持并行能能力
 *     ⑥Stream的元素只能被访问一次，跟迭代器一样，只有生成新的Stream后，才能重新访问
 *     2.Stream操作分为中间操作和终端操作
 *     <li>
 *         (1)中间操作又分为有状态操作和无状态操作
 *         所谓中间操作的含义是：进行逻辑处理时，操作可以是一个或者是多个连续操作，将一个流转换成另一个流，这些来纳许操作不会消耗流，
 *         只有在终端操作发生之后，才会对数据处理的结果做最终执行
 *         ①有状态操作包含：
 *           有状态收到中间操作的影响，下面的方法在中间操作发生时会有更大的性能开销
 *           distinct(),sorted(),limit(),skip()
 *         ②无状态操作包含：
 *           无状态指数据处理时不受到中间操作的影响
 *           unordered(),filter(),map(),mapToInt(),mapToLong(),mapToDouble(),flatMap(),flatMapToInt(),
 *           flatMapToLong(),flatMapToDouble(),peek()
 *         (2)终端操作又分为非短路操作和短路操作
 *         一个Stream对象只能有一个终端操作，这个操作发生时，数据就会进行真实处理。
 *         ①非短路操作包含：
 *           forEach(),forEachOrdered(),toArray(),reduce(),collect(),max(),min(),count()
 *         ②短路操作包含：
 *           anyMatch(),allMatch(),noneMatch(),findFirst(),findAny()
 *     </li>
 *     3.数据转换成Stream的案例
 *     ① Stream stream = Stream.of("1","2","3");
 *     ② Stream stream = Arrays.stream(new String[]{"1","2","3"});
 *     ③ Stream stream = list.stream();
 *     ④ Stream stream = set.stream();
 *     ⑤ Stream stream = map.entrySet().stream();
 *     4.Collector配套使用的内置收集器
 *     ① toList(): 将元素收集到一个新的List集合
 *     ② toSet(): 将元素收集到一个新的Set集合
 *     ③ toCollection(): 将元素收集到一个新的ArrayList集合中
 *     ④ joining(): 将元素收集到一个可以分隔符链接的字符串中
 *     5.Stream结合基础数据类型做了封装：
 *     IntStream,LongStream,DoubleStream,除了基础方法和Stream类似之外，强制要求了元素类型是一个限制，另外提供了range(),rangeClosed()方法
 *     同时对于数值类型的操作提供了类似于average等求值函数，该类Stream对象可以避免使用Stream<Integer>的时候频繁封包解包，提高一定的效率
 *     至于为啥避免了封包解包的原因，是JDK在BasicStream中引入了Spliterator对象，该对象包含OfInt,OfDouble,OfLong等方法，
 *     这系列方法，将传入的array数组直接组装成Stream需要的元素，从而避免对包装类的转换
 *     具体测试案例查看testBasicDataStream单元测试案例
 * </pre>
 * @Date 2022-10-6 21:03
 * @Created by mubai
 */
public class Jdk8StreamTest {

    @Test
    public void testCollectorJoining() {
        Stream<String> stream = Stream.of("1", "2", "3");
        System.out.println(stream.collect(Collectors.joining(";")));
        //output: 1;2;3 当不指定CharSequence时会将所有元素直接拼起来
        //collect是一个终端操作，所以stream使用之后会被关闭，不能继续被使用
    }

    @Test
    public void testBasicDataStream() {
        IntStream intStream = IntStream.of(1, 2, 3);
        //IntStream.of或者其他range构造IntStream的时候会强制要求输入的参数是int[]，而后面构造Stream的时候对于入参都泛型T
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        //Stream<Integer>指定了Stream.of的方法得到的都是Integer[]，所有一开始就做了封包动作，后续对于终端处理时，都需要解包，处理完成之后再重新封包返回结果
        IntStream.range(1, 3).forEach(System.out::println);
        //outPut:1 2
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        //outPut:1 2 3 rangeClosed相当于Between，range方法相当于[1,2,3)
    }

    /**
     * 在Stream中无论是中间操作还是终端操作，默认都是串行动作，并行操作需要调用parallel或者parallelStream方法来开启并行执行
     * 其底层使用的是ForkJoinTask实现的并行处理，可以充分利用CPU的多核能力
     * PS: 从结果上看并行处理消耗的时间远低于串行花费的时间，但是在并行处理的时候还需要考虑是否需要顺序执行，是否涉及线程安全，是否涉及使用网络等情况
     */
    @Test
    public void testParallelStream() {
        long time = System.currentTimeMillis();

        long sumResult = LongStream.rangeClosed(1, 100000000L).sum();
        long time1 = System.currentTimeMillis();
        System.out.println("1亿累加串行执行完成，耗时：" + (time1 - time) + ",结果：" + sumResult);

        long sumResult1 = LongStream.rangeClosed(1, 1000000000L).sum();
        long time2 = System.currentTimeMillis();
        System.out.println("10亿累加串行执行完成，耗时：" + (time2 - time1) + ",结果：" + sumResult1);

        long sumResult2 = LongStream.rangeClosed(1, 10000000000L).sum();
        long time3 = System.currentTimeMillis();
        System.out.println("100亿累加串行执行完成，耗时：" + (time3 - time2) + ",结果：" + sumResult2);

        long sumResult3 = LongStream.rangeClosed(1, 100000000000L).sum();
        long time4 = System.currentTimeMillis();
        System.out.println("1000亿累加串行执行完成，耗时：" + (time4 - time3) + ",结果：" + sumResult3);

        long parallelSumResult = LongStream.rangeClosed(1, 100000000L).parallel().sum();
        long time5 = System.currentTimeMillis();
        System.out.println("1亿并行执行完成，耗时：" + (time5 - time4) + ",结果：" + parallelSumResult);

        long parallelSumResult1 = LongStream.rangeClosed(1, 1000000000L).parallel().sum();
        long time6 = System.currentTimeMillis();
        System.out.println("10亿并行执行完成，耗时：" + (time6 - time5) + ",结果：" + parallelSumResult1);

        long parallelSumResult2 = LongStream.rangeClosed(1, 10000000000L).parallel().sum();
        long time7 = System.currentTimeMillis();
        System.out.println("100亿并行执行完成，耗时：" + (time7 - time6) + ",结果：" + parallelSumResult2);

        long parallelSumResult3 = LongStream.rangeClosed(1, 100000000000L).parallel().sum();
        long time8 = System.currentTimeMillis();
        System.out.println("1000并行执行完成，耗时：" + (time8 - time7) + ",结果：" + parallelSumResult3);
        //当计算1亿时，串行计算耗时：90 并行耗时： 16
        //当计算10亿时，串行计算耗时：1607 并行耗时： 79
        //当计算100亿时，串行计算耗时：3856 并行耗时： 770
        //当计算1000亿时，串行计算耗时：37255，并行耗时：7746
    }

    /**
     * 测试中间状态 - 有状态 - distinct
     * distinct 不需要传参，通过hashCode()方法和equals()方法来判断元素是否需要去重
     * 如果distinct处理的流是有序的，那么结果会保留顺序，如果是无序的，那么则不一定会保证元素的顺序
     * 其次在并行处理的时候，distinct的有序行会造成很大的缓冲开销，所以如果并行处理时不需要保证有序性，可以配合unordered()方法来优化处理的速度
     */
    @Test
    public void testDistinct() {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100000000; i++) {
            integerList.add(random.nextInt(10));
        }
        long time = System.currentTimeMillis();
        List<Integer> orderList = integerList.stream().distinct().collect(Collectors.toList());
        long time1 = System.currentTimeMillis();
        System.out.println("1亿数据有序去重完成，耗时:" + (time1 - time));
        //output: 1亿数据有序去重完成，耗时:1542

        List<Integer> unorderedList = integerList.stream().unordered().distinct().collect(Collectors.toList());
        long time2 = System.currentTimeMillis();
        System.out.println("1亿数据无序去重完成，耗时:" + (time2 - time1));
        //output: 1亿数据无序去重完成，耗时:1010
    }

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
