package designPattern.commandPattern;

/**
 * @Classname MacroCommand
 * @Description
 * @Date 2021/5/14 11:08
 * @Created by mubai
 */
public interface MacroCommand extends Command {
    /**
     * 添加命令成员
     */
    void add(Command command);

    /**
     * 移除命令成员
     */
    void remove(Command command);
}
