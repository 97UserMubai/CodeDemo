package javaBasic.arrayBasic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @name: SetPerformance
 * @author: mubai.
 * @date: 2021/11/25
 * @version: 1.0
 * @description:
 */
public class SetPerformance {
    private static final int REPS = 200;

    private abstract static class Tester {
        String name;

        Tester(String name) {
            this.name = name;
        }

        abstract void test(Set s, int size);
    }

    static void fill(Set s, int size) {
        for (int i = 0; i < size; i++) {
            s.add(String.valueOf(i));
        }
    }

    private static Tester[] tests = {
            new Tester("add") {
                void test(Set s, int size) {
                    for (int i = 0; i < REPS; i++) {
                        s.clear();
                        fill(s, size);
                    }
                }
            },
            new Tester("contains") {
                void test(Set s, int size) {
                    for (int i = 0; i < REPS; i++)
                        for (int j = 0; j < size; j++)
                            s.contains(Integer.toString(j));
                }
            },
            new Tester("iteration") {
                void test(Set s, int size) {
                    for (int i = 0; i < REPS * 10; i++) {
                        Iterator it = s.iterator();
                        while (it.hasNext())
                            it.next();
                    }
                }
            },
    };

    public static void test(Set s, int size) {
        // A trick to print out the class name:
        System.out.println("Testing " +
                s.getClass().getName() + " size " + size);
        fill(s, size);
        for (int i = 0; i < tests.length; i++) {
            System.out.print("length:" + size + ",action:" + tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(s, size);
            long t2 = System.currentTimeMillis();
            System.out.println(",execute mills:" +
                    ((double) (t2 - t1) / (double) size));
        }
    }

    public static void main(String[] args) {
        // Small:
        System.out.println("test------------->size:10");
        test(new TreeSet(), 10);
        test(new HashSet(), 10);
        System.out.println();
        // Medium:
        System.out.println("test------------->size:100");
        test(new TreeSet(), 100);
        test(new HashSet(), 100);
        System.out.println();
        // Large:
        System.out.println("test------------->size:1000");
        test(new HashSet(), 1000);
        test(new TreeSet(), 1000);
    }

}
