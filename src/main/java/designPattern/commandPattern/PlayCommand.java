package designPattern.commandPattern;

/**
 * @Classname PlayCommand
 * @Description
 * @Date 2021/5/14 10:49
 * @Created by mubai
 */
public class PlayCommand implements Command {
    private final AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.play();
    }
}
