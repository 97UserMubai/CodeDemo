package designPattern.observerPattern;

/**
 * @Classname Observer
 * @Description 观察者接口
 * @Date 2021/5/21 16:21
 * @Created by mubai
 */
public interface Observer {
    /**
     * 更新接口
     *
     * @param state 主题推送的新状态
     */
    void update(String state);
}
