import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Created on 2020-12-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Music extends JFrame {
    public void playMusic(URL musicLocation) {
        try {
            AudioClip music = Applet.newAudioClip(musicLocation);
            music.play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loopMusic(URL musicLocation){
        try {
            AudioClip music = Applet.newAudioClip(musicLocation);
            music.loop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

