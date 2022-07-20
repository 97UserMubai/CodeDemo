package javaBasic.jdk8Basic.function.easyImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @Classname BiConsumerTest
 * @Description TODO
 * @Date 2022-7-15 16:10
 * @Created by mubai
 */
public class BiConsumerTest {

    /**
     * BiConsumer和Consumer用法类型，不一样的是BiConsumer可以携带两个参数
     * 同时和Consumer一样，提供andThen方法用于BiConsumer继续处理的场景
     * 相同的是：andThen方法不能传入一个空的BiConsumer对象，会抛出空指针
     */
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        list2.add(2);

        BiConsumer<List<Integer>, List<Integer>> equals = (l1, l2) ->
        {
            if (l1.size() != l2.size()) {
                System.out.println("Size 不一致");
            } else {
                for (int i = 0; i < l1.size(); i++) {
                    if (!l1.get(i).equals(l2.get(i))) {
                        System.out.println("内容不一致，index:" + i + ",l1:" + l1.get(i) + ",l2:" + l2.get(i));
                        return;
                    }
                    System.out.println("完全匹配");
                }
            }
        };

        BiConsumer<List<Integer>, List<Integer>> biConsumer = (l1, l2) ->
        {
            System.out.println(l1);
            System.out.println(l2);
        };
        equals.accept(list1, list2);
        equals.andThen(biConsumer).andThen(biConsumer).accept(list1, list2);
    }


}
