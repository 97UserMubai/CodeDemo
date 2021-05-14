package designPattern.commandPattern;

/**
 * @Classname StopCommand
 * @Description
 * @Date 2021/5/14 10:56
 * @Created by mubai
 */
public class StopCommand implements Command {
    private final AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.stop();
    }
}
