package designPattern.observerPattern;

/**
 * @Classname ConcreteObserver
 * @Description 具体的观察者一号
 * @Date 2021/5/21 16:22
 * @Created by mubai
 */
public class ConcreteObserverOne implements Observer {
    //观察者一号的状态
    private String observerState;

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    public String getObserverState() {
        return observerState;
    }

    public ConcreteObserverOne(String observerState) {
        this.observerState = observerState;
    }

    @Override
    public void update(String state) {
        System.out.println("被通知需要更新状态，当前状态为：" + observerState);
        this.observerState = state;
        System.out.println("状态更新成功，当前状态为：" + observerState);
    }

    @Override
    public void updatePull(Topic topic) {
        ConcreteTopic concreteTopic = (ConcreteTopic) topic;
        System.out.println("被通知需要更新状态，当前状态为：" + observerState);
        this.observerState = concreteTopic.getState();
        System.out.println("状态更新成功，当前状态为：" + observerState);
    }
}
