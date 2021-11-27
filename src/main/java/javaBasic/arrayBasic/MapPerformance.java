package javaBasic.arrayBasic;

import java.util.*;

/**
 * @name: MapPerformance
 * @author: mubai.
 * @date: 2021/11/25
 * @version: 1.0
 * @description:
 * <pre>
 *     性能测试结果：
 *     1、TreeMap的Put和遍历时效果最好，但是get性能不佳，有时可以将teeMap作为创建顺序列表的一个途径
 *     填充了一个treeMap，可以调用keySet获取一个键的set集合，这个时候的set是有序的，通过转换成array后可以通过Array.binarySearch方法快速查找内容
 *     2、上面的做法一般发生在hashMap不可使用的情况，因为hashmap的设计宗旨就是进行快速的检索操作
 *     另外相对于hashMap，treeMap的创建速度会更快
 * </pre>
 */
public class MapPerformance {
    private static final int REPS = 200;
    public static Map fill(Map m, int size) {
        for(int i = 0; i < size; i++) {
            String x = Integer.toString(i);
            m.put(x, x);
        }
        return m;
    }
    private abstract static class Tester {
        String name;
        Tester(String name) { this.name = name; }
        abstract void test(Map m, int size);
    }
    private static Tester[] tests = {
            new Tester("put") {
                void test(Map m, int size) {
                    for(int i = 0; i < REPS; i++) {
                        m.clear();
                        fill(m, size);
                    }
                }
            },
            new Tester("get") {
                void test(Map m, int size) {
                    for(int i = 0; i < REPS; i++)
                        for(int j = 0; j < size; j++)
                            m.get(Integer.toString(j));
                }
            },
            new Tester("iteration") {
                void test(Map m, int size) {
                    for(int i = 0; i < REPS * 10; i++) {
                        Iterator it = m.entrySet().iterator();
                        while(it.hasNext())
                            it.next();
                    }
                }
            },
    };
    public static void test(Map m, int size) {
        // A trick to print out the class name:
        System.out.println("Testing " +
                m.getClass().getName() + " size " + size);
        fill(m, size);
        for(int i = 0; i < tests.length; i++) {
            System.out.print("length:" + size + ",action:" + tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(m, size);
            long t2 = System.currentTimeMillis();
            System.out.println(",execute mills:" +
                    ((double)(t2 - t1)/(double)size));
        }
    }
    public static void main(String[] args) {
        // Small:
        System.out.println("test------------->size:10");
        test(new Hashtable(), 10);
        test(new HashMap(), 10);
        test(new TreeMap(), 10);
        System.out.println();
        // Medium:
        System.out.println("test------------->size:100");
        test(new Hashtable(), 100);
        test(new HashMap(), 100);
        test(new TreeMap(), 100);
        System.out.println();
        // Large:
        System.out.println("test------------->size:1000");
        test(new HashMap(), 1000);
        test(new Hashtable(), 1000);
        test(new TreeMap(), 1000);
    }

}
