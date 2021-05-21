package designPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Topic
 * @Description 抽象主题
 * @Date 2021/5/21 16:21
 * @Created by mubai
 */
public abstract class Topic {
    private final List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     * @param observer 观察者对象
     */
    public void add(Observer observer) {
        this.observers.add(observer);
        System.out.println("增加了主题");
    }

    /**
     * 移除观察者
     * @param observer 观察者对象
     */
    public void delete(Observer observer) {
        this.observers.remove(observer);
        System.out.println("删除了主题");
    }

    /**
     * 通知更新，推模式
     * @param newState 新的状态
     */
    public void notify(String newState) {
        observers.forEach(observer -> observer.update(newState));
    }
}
