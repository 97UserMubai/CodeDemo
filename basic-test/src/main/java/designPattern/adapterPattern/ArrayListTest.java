package designPattern.adapterPattern;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname ArrayListTest
 * @Description TODO
 * @Date 2022-4-4 11:11
 * @Created by mubai
 */
public class ArrayListTest {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        List<String> list = Arrays.asList(arr);
        list.set(2, "4");
        //输出1,2,4
        System.out.println(list);
        //输出数组下标越界异常
//        list.set(3, "5");
        //抛出UnsupportedOpe
        list.add("4");
        // rationException异常
        list.remove(1);
    }

}
