package javaBasic.arrayBasic;

import java.util.*;

/**
 * @name: ListPerformance
 * @author: mubai.
 * @date: 2021/11/25
 * @version: 1.0
 * @description:
 * <pre>
 *     输出：
 *     Testing java.util.ArrayList
 *     length:300,action:get,execute mills:0
 *     length:300,action:iteration,execute mills:0
 *     length:1000,action:insert,execute mills:4
 *     length:5000,action:remove,execute mills:20
 *     Testing java.util.LinkedList
 *     length:300,action:get,execute mills:0
 *     length:300,action:iteration,execute mills:0
 *     length:1000,action:insert,execute mills:1
 *     length:5000,action:remove,execute mills:1
 *
 *     这里比较了arrayList和linkedList两种集合增删查遍历的性能，很明显的是对于insert和remove操作，linkedList的效率比arrayList要高很多
 *     特别是remove操作，size越大arrayList的remove操作越慢
 * </pre>
 */
public class ListPerformance {
    private static final int REPS = 100;

    private abstract static class Tester {
        String name;
        int size; // Test quantity

        Tester(String name, int size) {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    private static Tester[] tests = {
            new Tester("get", 300) {
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < a.size(); j++)
                            a.get(j);
                    }
                }
            },
            new Tester("iteration", 300) {
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        Iterator it = a.iterator();
                        while (it.hasNext())
                            it.next();
                    }
                }
            },
            new Tester("insert", 1000) {
                void test(List a) {
                    int half = a.size() / 2;
                    String s = "test";
                    ListIterator it = a.listIterator(half);
                    for (int i = 0; i < size * 10; i++)
                        it.add(s);
                }
            },
            new Tester("remove", 5000) {
                void test(List a) {
                    ListIterator it = a.listIterator(3);
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
            },
    };

    public static void test(List a) {
        // A trick to print out the class name:
        System.out.println("Testing " +
                a.getClass().getName());
        for (int i = 0; i < tests.length; i++) {
            Collections.fill(a, tests[i].size);
            System.out.print("length:" + tests[i].size + ",action:" + tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(a);
            long t2 = System.currentTimeMillis();
            System.out.println(",execute mills:" + (t2 - t1));
        }
    }

    public static void main(String[] args) {
        test(new ArrayList());
        test(new LinkedList());
    }

}
