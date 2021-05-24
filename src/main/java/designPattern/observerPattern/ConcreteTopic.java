package designPattern.observerPattern;

/**
 * @Classname ConcreteTopic
 * @Description 具体主题
 * @Date 2021/5/21 16:31
 * @Created by mubai
 */
public class ConcreteTopic extends Topic {
    private String state;

    public String getState() {
        return state;
    }

    /**
     * 变更同时，进行父通知接口的调用
     *
     * @param newState 新状态
     */
    public void change(String newState) {
        this.state = newState;
        System.out.println("主题状态变更为：" + state);
        this.notify(state);
    }

    public void changePull(String newState) {
        this.state = newState;
        System.out.println("主题状态变更为：" + state);
        this.notifyPull();
    }
}
