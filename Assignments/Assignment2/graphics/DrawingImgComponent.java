package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingImgComponent extends JComponent{
    private BufferedImage img;

    public DrawingImgComponent(String img) throws IOException {
        setLayout(new GridBagLayout());
        try { this.img = ImageIO.read(new File(img)); }
        catch (IOException e) { System.out.println("Cannot load image"); }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 15, 105, 150, 150, this);
//        revalidate();
        repaint();
    }
}
