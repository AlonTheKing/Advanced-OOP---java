package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*
DrawingComponent class is responsible with paining an Jcomponent on the screen
 */
public class DrawingComponent extends JComponent {
    private BufferedImage img;
    private boolean flag;
    private String myPath;


    /*
    DrawingComponent constructor
    @param : String img
    @param : boolean flag
     */
    public DrawingComponent(String img, boolean flag) throws IOException {
        setLayout(new GridBagLayout());

        this.img = ImageIO.read(new File(img));
        this.flag = flag;
        this.myPath = img;

    }
    /*
  DrawingComponent constructor
  @param : BufferedImage img
  @param : boolean flag
   */
    public DrawingComponent(BufferedImage img, boolean flag){
        setLayout(new GridBagLayout());

        this.img = img;
        this.flag = flag;
    }

    /*
    getPrefferedSize method can change the size of the component
     */
    public Dimension getPreferredSize() {
        if (flag) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(1100, 870);

        }

    }
    /*
    paintComponent is a method that running on the backstage, it called when there is a need to paint/draw s certain image
    on the screen
    @param : Graphics g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (flag) {

            g.drawImage(img, 0, 0, 100, 100, null);

        } else {
            g.drawImage(img, 0, 0, 1100, 870, null);


        }
    }

    public String getMyPath(){
        return this.myPath;
    }

}


