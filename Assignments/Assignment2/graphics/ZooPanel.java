package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
ZooPanel is a class that is in charge of displaying the buttons on the main screen
 */
public class ZooPanel extends JPanel {
    private JButton competition, addAnimal, clear, eat, info, exit;

    /*
    ZooPanel constructor
    @param : JFrame other
     */
    ZooPanel(JFrame other){
        JPanel CompetitionPanel = new JPanel(new GridLayout(1,7));

        competition = new JButton("Competition");
        addAnimal = new JButton("Add Animal");
        clear = new JButton("Clear");
        eat = new JButton("Eat");
        info = new JButton("Info");
        exit = new JButton("Exit");

        competition.setBounds(1, 875, 180, 35);
        addAnimal.setBounds(185, 875, 180, 35);
        clear.setBounds(369, 875, 180, 35);
        eat.setBounds(553, 875, 180, 35);
        info.setBounds(737, 875, 180, 35);
        exit.setBounds(921, 875, 180, 35);

        addAnimal.setEnabled(false);


        //listeners

        competition.addActionListener((ActionListener) other);
        addAnimal.addActionListener((ActionListener) other);
        clear.addActionListener((ActionListener) other);
        eat.addActionListener((ActionListener) other);
        info.addActionListener((ActionListener) other);
        exit.addActionListener((ActionListener) other);

        CompetitionPanel.add(competition,BorderLayout.WEST);
        CompetitionPanel.add(addAnimal,BorderLayout.WEST);
        CompetitionPanel.add(clear,BorderLayout.WEST);
        CompetitionPanel.add(eat,BorderLayout.WEST);
        CompetitionPanel.add(eat,BorderLayout.WEST);
        CompetitionPanel.add(info,BorderLayout.WEST);
        CompetitionPanel.add(exit,BorderLayout.WEST);
        //CompetitionPanel.setBounds(0,100,getWidth(),60);
        other.add(CompetitionPanel, BorderLayout.SOUTH);
    }

    // additional getters:

    public JButton getCompetition() {
        return competition;
    }

    public JButton getAddAnimal() {
        return addAnimal;
    }

    public JButton getClear() {
        return clear;
    }

    public JButton getEat() {
        return eat;
    }

    public JButton getInfo() {
        return info;
    }

    public JButton getExit() {
        return exit;
    }
}
