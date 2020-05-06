import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LunarPhase extends JFrame implements ActionListener {
    //private JPanel main;
    private JPanel upperPanel;
    private JPanel downPanel;
    private JComboBox<String> selection;
    private JLabel up;
    private JLabel down;
    ImageIcon[] myImages;
    private final String[] names = {"New", "Waxing Crescent", "First Quarter", "Waxing Gibbous",
            "Full", "Waning Gibbous", "Third Quarter", "Waning Crescent"};

    private BufferedImage image;

    LunarPhase() {
        super("Lunar Phases");
        setLayout(new GridLayout(0, 1));
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setResizable(false);
        setSize(247, 535);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        myImages = new ImageIcon[8];

        myImages[0] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//1.jpg");
        myImages[1] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//2.jpg");
        myImages[2] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//3.jpg");
        myImages[3] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//4.jpg");
        myImages[4] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//5.jpg");
        myImages[5] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//6.jpg");
        myImages[6] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//7.jpg");
        myImages[7] = new ImageIcon("C://Users//david//IdeaProjects//lab6.A//src//8.jpg");


        upperPanel = new JPanel();
        //upperPanel.setBounds(0,0,235,190);
        upperPanel.setBackground(new Color(255, 245, 245));
        upperPanel.setBorder(BorderFactory.createEtchedBorder(0));
        upperPanel.setLayout(null);

        up = new JLabel("Select Phase:");
        up.setBounds(20, 20, 102, 20);
        upperPanel.add(up);

        selection = new JComboBox<String>(names);
        selection.setBounds(40, 60, 150, 30);

        selection.addActionListener(this);

        upperPanel.add(selection);
        add(upperPanel);

        downPanel = new JPanel();
        downPanel.setBackground(new Color(255, 245, 245));
        downPanel.setBorder(BorderFactory.createEtchedBorder(0));

        downPanel.setLayout(new BoxLayout(downPanel, BoxLayout.Y_AXIS));
        JLabel down1 = new JLabel("Display phase:");
        down1.setBounds(0, 0, 160, 160);
        downPanel.add(down1);

        down = new JLabel(myImages[0], JLabel.CENTER);
        down.setBounds(40, 0, 130, 130);
        downPanel.add(down);


        add(downPanel);

        //add(main);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = selection.getItemAt(selection.getSelectedIndex());

        switch (choice) {
            case "New": {
                down.setIcon(myImages[0]);
                break;
            }
            case "Waxing Crescent": {
                down.setIcon(myImages[1]);
                break;
            }
            case "First Quarter": {
                down.setIcon(myImages[2]);
                break;
            }
            case "Waxing Gibbous":{
                down.setIcon(myImages[3]);
                break;
            }
            case "Full":{
                down.setIcon(myImages[4]);
                break;
            }
            case "Waning Gibbous":{
                down.setIcon(myImages[5]);
                break;
            }
            case "Third Quarter":{
                down.setIcon(myImages[6]);
                break;
            }
            case "Waning Crescent":{
                down.setIcon(myImages[7]);
                break;
            }
        }
    }

}
