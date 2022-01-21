package designPattern.commandPattern;

/**
 * @Classname CommandClient
 * @Description 客户端，模拟人为操作
 * @Date 2021/5/12 11:35
 * @Created by mubai
 */
public class CommandClient {
    public static void main(String[] args) {
        //创建接收者，并初始化到实际命令中
        AudioPlayer audioPlayer = new AudioPlayer();
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        //创建请求者对象
        System.out.println("使用请求者模式");
        Requester requester = new Requester();
        requester.setPlayCommand(playCommand);
        requester.setRewindCommand(rewindCommand);
        requester.setStopCommand(stopCommand);
        //调用请求者的方法
        requester.play();
        requester.remind();
        requester.stop();
        System.out.println("\n\n\n");
        System.out.println("使用宏命令模式");
        MacroCommand macroCommand = new MacroAudioCommand();
        macroCommand.add(stopCommand);
        macroCommand.add(rewindCommand);
        macroCommand.add(playCommand);
        macroCommand.execute();
        System.out.println("\n\n\n");
        System.out.println("进行宏命令集的对象移除");
        macroCommand.remove(stopCommand);
        macroCommand.remove(rewindCommand);
        macroCommand.execute();
    }
}
