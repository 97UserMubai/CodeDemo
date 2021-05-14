package designPattern.commandPattern;

/**
 * @Classname AudioPlayer
 * @Description 接收者，提供具体执行的业务逻辑代码
 * @Date 2021/5/14 10:46
 * @Created by mubai
 */
public class AudioPlayer {
    public void play() {
        System.out.println("成功播放音乐");
    }

    public void rewind() {
        System.out.println("目前音乐播放模式：倒带");
    }

    public void stop() {
        System.out.println("已经为您停止音乐播放");
    }
}
