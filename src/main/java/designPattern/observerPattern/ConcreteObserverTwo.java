package designPattern.observerPattern;

/**
 * @Classname ConcreteObserverTwo
 * @Description 具体的观察者二号
 * @Date 2021/5/21 16:25
 * @Created by mubai
 */
public class ConcreteObserverTwo implements Observer {
    //观察者二号的状态
    private String observerState;

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    public String getObserverState() {
        return observerState;
    }

    public ConcreteObserverTwo(String observerState) {
        this.observerState = observerState;
    }

    @Override
    public void update(String state) {
        System.out.println("被通知需要更新状态，当前状态为：" + observerState);
        this.observerState = state;
        System.out.println("状态更新成功，当前状态为：" + observerState);
    }
}
