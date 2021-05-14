package designPattern.commandPattern;

/**
 * @Classname RewindCommand
 * @Description
 * @Date 2021/5/14 10:55
 * @Created by mubai
 */
public class RewindCommand implements Command{
    private final AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.rewind();
    }
}
