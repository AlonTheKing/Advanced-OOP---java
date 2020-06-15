package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
ZooMenuPanel is a class that is in charge of the menubar of the main frame
 */
public class ZooMenuPanel {
    private JMenuBar menuBar;
    private JMenu fileMenu1, fileMenu2;
    private JMenuItem item1, item2;
    /*
     ZooMenuPanel constructor
     @param : JFrame
     */
    public ZooMenuPanel(JFrame other){
        menuBar = new JMenuBar();
        fileMenu1 = new JMenu("File");
        fileMenu2 = new JMenu("Help");

        item1 = new JMenuItem("Exit");
        item2 = new JMenuItem("Help");
        fileMenu1.add(item1);

        item1.addActionListener((ActionListener) other);
        item2.addActionListener((ActionListener) other);

        menuBar.add(fileMenu1);
        fileMenu2.add(item2);
        menuBar.add(fileMenu2);

        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(menuBar, BorderLayout.CENTER);
        other.add(menuPanel, BorderLayout.NORTH);
    }
}
