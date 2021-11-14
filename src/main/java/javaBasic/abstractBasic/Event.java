package javaBasic.abstractBasic;

/**
 * @Classname Event
 * @Description 这是一个经典的抽象类运用方式，很多应用框架采用这种基础结构进行程序设计
 * @Date 2021/11/14 17:02
 * @Created by mubai
 */
abstract public class Event {
    private final long eventTime;
    public Event(long eTime){
        eventTime = eTime;
    }

    /**
     * 进行是否执行的判断，往往作为基础的事件监控判断
     * 子类可以重写这个方法，进行自定义监控判断
     */
    public boolean ready(){
        return System.currentTimeMillis()>=eventTime;
    }

    /**
     * 下面两个方法是抽象方法，用于子类在监控事件触发的时候进行操作
     */
    abstract public void action();
    abstract public String desc();
}
