package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Part2and6
 * @Description 针对String.intern方法的常量池内存异常测试，JVM参数 -XX:MaxPermSize=10M -XX:PermSize=10M
 * TODO 这个测试案例，只能在1.7里面测试
 * 1.8 移除了MaxPermSize 和 PermSize 参数
 * 上面这两个"永久代"的参数在1.8之后通过-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M 这两个参数进行替换，新概念词时"元空间"
 * 很遗憾，可能是第二版的案例太久远了，在1.8的JDK上跑并没有什么效果
 * @Date 2023-1-20 21:44
 * @Created by mubai
 */
public class Part2and6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf("很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                    "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长"+i++).intern());
        }
    }
}
