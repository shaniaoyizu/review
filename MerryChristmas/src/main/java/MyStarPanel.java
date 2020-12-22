import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * Created on 2020-12-18
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MyStarPanel extends JPanel implements Runnable {

    private int width;
    private int height;
    int[] xx = new int[300];
    int[] yy = new int[300];
    BufferedImage image;
    int[] fonts = new int[300];

    public MyStarPanel(int width, int height) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < 200; ++i) {
            this.xx[i] = (int) (Math.random() * width);
            this.yy[i] = (int) (Math.random() * height);
        }
        try {
            this.image = ImageIO.read(MyStarPanel.class.getResource("sds.jpg"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(this.image, 0, 0, width, height, (ImageObserver) null);
        g.setColor(Color.WHITE);

        for (int i = 0; i < 200; ++i) {
            Font ft = new Font("微软雅黑", 1, this.fonts[i]);
            g.setFont(ft);
            g.drawString("*", this.xx[i], this.yy[i]);
        }
    }

    public void run() {
        int segment = 9;
        while (true) {
            for (int i = 0; i < 200; ++i) {
                this.yy[i]++;
                this.xx[i]++;
                if (this.yy[i] >= height - 30) {
                    this.yy[i] = 0;
                }
                if (this.xx[i] > width) {
                    this.xx[i] = 0;
                }
                if (this.yy[i] > 0 && this.yy[i] < height / segment) {
                    this.fonts[i] = 15;
                } else if (this.yy[i] > height / segment && this.yy[i] < height / segment * 2) {
                    this.fonts[i] = 19;
                } else if (this.yy[i] > height / segment * 2 && this.yy[i] < height / segment * 3) {
                    this.fonts[i] = 24;
                } else if (this.yy[i] > height / segment * 3 && this.yy[i] < height / segment * 4) {
                    this.fonts[i] = 28;
                } else if (this.yy[i] > height / segment * 4 && this.yy[i] < height / segment * 5) {
                    this.fonts[i] = 32;
                } else if (this.yy[i] > height / segment * 5 && this.yy[i] < height / segment * 6) {
                    this.fonts[i] = 36;
                }else if (this.yy[i] > height / segment * 6 && this.yy[i] < height / segment * 7) {
                    this.fonts[i] = 40;
                } else if (this.yy[i] > height / segment * 7 && this.yy[i] < height / segment * 8) {
                    this.fonts[i] = 45;
                } else {
                    this.fonts[i] = 50;
                }
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
            this.repaint();
        }
    }
}
