package javaBasic.interfaceBasic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * @name: Demo
 * @author: Mubai.Wang
 * @date: 2023/3/9
 * @version: 1.0
 * @description:
 */
public class Demo<T extends Collection> {

    public Demo addData(T t, DemoFunction function) {
        if (t.contains(function.data())) {
            System.out.println("data:" + function.data() + " exist");
        } else {
            t.add(function.data());
            System.out.println("add data successfully," + function.data());
        }
        return this;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Demo demo = new Demo();
        demo.addData(list, () -> "666")
                .addData(list, () -> "666")
                .addData(list, () -> true);
        System.out.println(list);
    }

}
