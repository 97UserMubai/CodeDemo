package designPattern.commandPattern;

/**
 * @Classname Command
 * @Description 抽象命令，提供执行动作的唯一入口
 * @Date 2021/5/14 10:43
 * @Created by mubai
 */
public interface Command {
    /**
     * 命令统一入口，具体调用接收者的哪个方法有实现类决定
     */
    void execute();
}
