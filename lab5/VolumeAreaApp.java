import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumeAreaApp extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextField widthText;
    private JTextField heightText;
    private JTextField lengthText;
    private JButton calculateButton;
    private JTextField volumeText;
    private JTextField areaText;
    private TextPanel textPanel;
    private JButton button;
    private ToolBar toolBar;
    private LabelsClass labels;

    private JLabel area;
    private JLabel volume;
    private JLabel width;
    private JLabel height;
    private JLabel length;


    public VolumeAreaApp() {
        super("Volume & Area App");
        this.setResizable(false);
        setSize(390, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        height = new JLabel("Height:");
        width = new JLabel("Width:");
        length = new JLabel("Length:");


        height.setFont(new Font("Serif", Font.PLAIN,24));
        width.setFont(new Font("Serif", Font.PLAIN,24));
        length.setFont(new Font("Serif", Font.PLAIN,24));


        width.setBounds(10,10,120,35);
        height.setBounds(10,60,120,35);
        length.setBounds(10,110,120,35);

        mainPanel.add(width);
        mainPanel.add(height);
        mainPanel.add(length);

        widthText = new JTextField();
        heightText = new JTextField();
        lengthText = new JTextField();

        widthText.setBounds(100,10,250,35);
        heightText.setBounds(100,60,250,35);
        lengthText.setBounds(100,110,250,35);

        mainPanel.add(widthText);
        mainPanel.add(heightText);
        mainPanel.add(lengthText);

        calculateButton = new JButton("Calculate");

        calculateButton.setBounds(10, 160, 87, 40);

        calculateButton.addActionListener(this);
        mainPanel.add(calculateButton);

        volume = new JLabel("Volume:");
        area = new JLabel("Area:");

        volume.setBounds(110,160,120,35);
        area.setBounds(250,160,120,35);

        volume.setFont(new Font("Serif", Font.PLAIN,24));
        area.setFont(new Font("Serif", Font.PLAIN,24));

        mainPanel.add(volume);
        mainPanel.add(area);

        volumeText = new JTextField();
        areaText = new JTextField();
        volumeText.setBounds(200,160,40,35);
        areaText.setBounds(310,160,40,35);

        volumeText.setEnabled(false);
        areaText.setEnabled(false);

        mainPanel.add(volumeText);
        mainPanel.add(areaText);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        volumeText.setEnabled(true);
        areaText.setEnabled(true);

        Integer x = Integer.parseInt(heightText.getText());
        Integer y = Integer.parseInt(widthText.getText());
        Integer z = Integer.parseInt(lengthText.getText());

        int volume = x*y*z;
        int area = x*y*2+y*z*2+x*z*2;
        volumeText.setText(Integer.toString(volume));
        areaText.setText(Integer.toString(area));
    }
}
