import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-12-18
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        JFrame frame = new JFrame("圣诞快乐");
        MyStarPanel panel = new MyStarPanel(width, height);
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component) null);
        frame.setDefaultCloseOperation(3);
        frame.setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Music music = new Music();
        Thread thread1 = new Thread(() -> {
            music.playMusic(Main.class.getResource("music1.WAV"));
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            music.playMusic(Main.class.getResource("music2.WAV"));
        });
        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            music.playMusic(Main.class.getResource("music3.WAV"));
        });
        Thread thread4 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            music.playMusic(Main.class.getResource("apple4.WAV"));
        });
        Thread thread5 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(128);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            music.playMusic(Main.class.getResource("music5.WAV"));
        });
        Thread thread6 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(133);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            music.playMusic(Main.class.getResource("marry6.WAV"));
        });
        Thread thread7 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(194);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            music.playMusic(Main.class.getResource("music7.WAV"));
        });
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread4.setDaemon(true);
        thread5.setDaemon(true);
        thread6.setDaemon(true);
        thread7.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
