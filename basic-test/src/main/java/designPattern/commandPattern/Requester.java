package designPattern.commandPattern;

/**
 * @Classname Requester
 * @Description 请求者，封装command执行方法
 * @Date 2021/5/14 10:57
 * @Created by mubai
 */
public class Requester {
    //代码耦合部分
    //这里使用全局变量来完成这个指定command实现类的初始化，如果发生新的command的新增，这个位置需要同步修改代码。
    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    public void play(){
        this.playCommand.execute();
    }

    public void remind(){
        this.rewindCommand.execute();
    }

    public void stop(){
        this.stopCommand.execute();
    }
}
