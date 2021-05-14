package designPattern.commandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MacroAudioCommand
 * @Description
 * @Date 2021/5/14 11:11
 * @Created by mubai
 */
public class MacroAudioCommand implements MacroCommand {
    private List<Command> commandList = new ArrayList<>();

    @Override
    public void add(Command command) {
        commandList.add(command);
    }

    @Override
    public void remove(Command command) {
        commandList.remove(command);
    }

    @Override
    public void execute() {
        System.out.println("宏命令集开始执行");
        commandList.forEach(Command::execute);
        System.out.println("宏命令集执行结束");
    }
}
