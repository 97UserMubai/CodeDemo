package designPattern.adapterPattern;

/**
 * @Classname MainTest
 * @Description TODO
 * @Date 2022-4-3 22:57
 * @Created by mubai
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("开始测试类构造器：");
        Target target = new ClassAdapter();
        target.request();

        System.out.println("开始执行对象构造器：");
        Target target2 = new ObjectAdapter(new Adaptee());
        target2.request();
    }
}
