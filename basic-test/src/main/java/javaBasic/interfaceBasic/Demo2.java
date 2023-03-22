package javaBasic.interfaceBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: Demo2
 * @author: Mubai.Wang
 * @date: 2023/3/10
 * @version: 1.0
 * @description:
 */
public class Demo2<T> {
    public static void main(String[] args) {
        List<? extends ParentObject> result = new ArrayList<>();
        addData(result, "1", OneChild::new);
        addData(result, "2", TwoChild::new);
        System.out.println("debug");
//        result.forEach(item -> System.out.println(item.));
    }

    public static void addData(List<? extends ParentObject> result, String resource, DemoFunction2<? extends ParentObject> function2) {
//        result.add(function2.data());
    }
}
