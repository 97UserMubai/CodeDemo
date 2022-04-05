package designPattern.adapterPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname AsListAdapter
 * @Description 模仿asList的方式进行重写，将静态的内部类替换成ArrayList都西昂
 * @Date 2022-4-5 8:58
 * @Created by mubai
 */
public class AsListAdapter {
    public static <T> List<T> asList(T... a) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, a);
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        List<String> list = asList(arr);
        List<String> list2 = Arrays.asList(arr);
        System.out.println("debug");
        System.out.println(list);
        System.out.println(list2);
        list.add("4");
        System.out.println(list);
        Object[] arr2 = list.toArray();
        System.out.println("debug");
    }
}
