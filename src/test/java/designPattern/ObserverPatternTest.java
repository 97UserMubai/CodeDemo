package designPattern;

import designPattern.observerPattern.ConcreteObserverOne;
import designPattern.observerPattern.ConcreteObserverTwo;
import designPattern.observerPattern.ConcreteTopic;
import designPattern.observerPattern.Observer;
import org.junit.Test;

/**
 * @Classname ObserverPatternTest
 * @Description 观察者模式测试类
 * @Date 2021/5/21 16:33
 * @Created by mubai
 */
public class ObserverPatternTest {
    @Test
    public void test() {
        ConcreteTopic topic = new ConcreteTopic();
        Observer observerOne = new ConcreteObserverOne("一号状态");
        Observer observerTwo = new ConcreteObserverTwo("二号状态");
        topic.add(observerOne);
        topic.add(observerTwo);
        topic.change("这是一个新状态");
        topic.delete(observerTwo);
        topic.change("这是一个更新的状态");
        System.out.println("下面使用pull模式\n");
        topic.add(observerTwo);
        topic.changePull("我是拉模式");
    }
}
