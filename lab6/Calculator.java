import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JTextArea outcome;
    private JPanel one = new JPanel();


    private JButton b_0 = new JButton("0");
    private JButton b_1 = new JButton("1");
    private JButton b_2 = new JButton("2");
    private JButton b_3 = new JButton("3");
    private JButton b_4 = new JButton("4");
    private JButton b_5 = new JButton("5");
    private JButton b_6 = new JButton("6");
    private JButton b_7 = new JButton("7");
    private JButton b_8 = new JButton("8");
    private JButton b_9 = new JButton("9");

    private JButton backSpace = new JButton("Backspace");
    private JButton flip = new JButton("+/-");
    private JButton dot = new JButton(".");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    private JButton ce = new JButton("CE");
    private JButton c = new JButton("C");
    private JButton sqrt = new JButton("sqrt");
    private JButton b_1_div_x = new JButton("1/x");
    private JButton mod = new JButton("%");
    private JButton equal = new JButton("=");
    private static final int max_int = 10000000;
    private int count = 0;
    private int num1 = max_int;
    private int num2 = max_int;
    private int result = -1;
    private String operation = "";
    private int before = 0;


    Calculator() {
        super("Java Swing Calculator");
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setResizable(false);
        setSize(378, 257);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new GridLayout(0, 1));

        //setLayout(null);
        menuBar = new JMenuBar();
        JMenu firstMenu = new JMenu("File");
        JMenu secondMenu = new JMenu("Help");
        menuBar.add(firstMenu);
        menuBar.add(secondMenu);
        setJMenuBar(menuBar);

        //outcome
        outcome = new JTextArea();
        outcome.setBounds(2, 2, 360, 30);
        outcome.setEditable(false);
        outcome.setVisible(true);

        one.setLayout(null);
        one.add(outcome);

        backSpace.setBounds(2, 35, 100, 30);
        ce.setBounds(218, 35, 70, 30);
        c.setBounds(290, 35, 70, 30);
        one.add(backSpace);
        one.add(ce);
        one.add(c);

        backSpace.addActionListener(this);
        c.addActionListener(this);
        ce.addActionListener(this);

        b_7.setBounds(2, 67, 70, 30);
        b_8.setBounds(74, 67, 70, 30);
        b_9.setBounds(146, 67, 70, 30);
        div.setBounds(218, 67, 70, 30);
        sqrt.setBounds(290, 67, 70, 30);
        one.add(b_7);
        one.add(b_8);
        one.add(b_9);
        one.add(div);
        one.add(sqrt);

        b_7.addActionListener(this);
        b_8.addActionListener(this);
        b_9.addActionListener(this);
        div.addActionListener(this);
        sqrt.addActionListener(this);


        b_4.setBounds(2, 99, 70, 30);
        b_5.setBounds(74, 99, 70, 30);
        b_6.setBounds(146, 99, 70, 30);
        mul.setBounds(218, 99, 70, 30);
        b_1_div_x.setBounds(290, 99, 70, 30);
        one.add(b_4);
        one.add(b_5);
        one.add(b_6);
        one.add(mul);
        one.add(b_1_div_x);

        mul.addActionListener(this);
        b_1_div_x.addActionListener(this);
        b_4.addActionListener(this);
        b_5.addActionListener(this);
        b_6.addActionListener(this);

        b_1.setBounds(2, 131, 70, 30);
        b_2.setBounds(74, 131, 70, 30);
        b_3.setBounds(146, 131, 70, 30);
        mod.setBounds(218, 131, 70, 30);
        minus.setBounds(290, 131, 70, 30);
        one.add(b_1);
        one.add(b_2);
        one.add(b_3);
        one.add(minus);
        one.add(mod);

        b_1.addActionListener(this);
        b_2.addActionListener(this);
        b_3.addActionListener(this);
        mod.addActionListener(this);
        minus.addActionListener(this);

        b_0.setBounds(2, 163, 70, 30);
        flip.setBounds(74, 163, 70, 30);
        dot.setBounds(146, 163, 70, 30);
        plus.setBounds(218, 163, 70, 30);
        equal.setBounds(290, 163, 70, 30);
        one.add(b_0);
        one.add(flip);
        one.add(dot);
        one.add(plus);
        one.add(equal);

        plus.addActionListener(this);
        equal.addActionListener(this);
        flip.addActionListener(this);
        dot.addActionListener(this);

        add(one);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // even == num1 , odd == num2

        if ("+-*/%".contains(e.getActionCommand())) {
            operation = e.getActionCommand();
            before = 0;
        }
        if (before == 1) {

            if ("0123456789".contains(e.getActionCommand())) {
                if (count % 2 == 1) {

                    num1 *= 10;
                    num1 += Integer.parseInt(e.getActionCommand());
                    outcome.setText(String.valueOf(num1));

                } else {
                    num2 *= 10;
                    num2 += Integer.parseInt(e.getActionCommand());
                    outcome.setText(String.valueOf(num2));
                }

            }
        }
        //before  == 0
        else {
            if ("0123456789".contains(e.getActionCommand())) {
                if (count % 2 == 0) {
                    num1 = Integer.parseInt(e.getActionCommand());
                } else {
                    num2 = Integer.parseInt(e.getActionCommand());
                }
                ++count;
                before = 1;
            } else if ("+-*/%".contains(e.getActionCommand())) {
                operation = e.getActionCommand();
                before = 0;
            }
        }

        if (e.getActionCommand().equals("=")) {


            if (num1 != max_int && num2 != max_int && !operation.equals("")) {
                switch (operation) {
                    case "+": {
                        result = num1 + num2;
                        outcome.setText("");
                        outcome.setText(String.valueOf(result));
                        num1 = result;
                        ++count;

                        break;
                    }
                    case "-": {
                        result = num1 - num2;
                        outcome.setText("");
                        outcome.setText(String.valueOf(num1 - num2));
                        num1 = result;
                        ++count;
                        break;
                    }
                    case "*": {
                        result = num1 * num2;
                        outcome.setText("");
                        outcome.setText(String.valueOf(num1 * num2));
                        num1 = result;
                        ++count;
                        break;
                    }
                    case "/": {
                        result = num1 / num2;
                        outcome.setText("");
                        outcome.setText(String.valueOf((float)num1 / num2));
                        num1 = result;
                        ++count;
                        break;
                    }
                    case "%": {
                        result = num1 % num2;
                        outcome.setText("");
                        outcome.setText(String.valueOf(num1 % num2));
                        num1 = result;
                        ++count;
                        break;
                    }

                }
            }
            before = 0;
        }
        if (e.getActionCommand().equals("CE")) {
            if (count % 2 == 0) {
                num2 = max_int;
            } else {
                num1 = max_int;
            }
            --count;
            before = 0;

        }
        if (e.getActionCommand().equals("C")) {
            count = 0;
            num1 = num2 = max_int;
            outcome.setText("");
            before = 0;
        }
        if (e.getActionCommand().equals("sqrt")) {
            if (count % 2 == 0) {
                outcome.setText(String.valueOf(Math.sqrt(num2)));
            } else {
                outcome.setText(String.valueOf(Math.sqrt(num1)));
            }
            before = 0;
        }
        if (e.getActionCommand().equals("+/-")) {
            String res;
            if (result > 0) {
                res = "-" + result;
            } else {
                res = "+" + result;
            }
            result = Integer.parseInt(res);
            outcome.setText(res);
            before = 0;
        }
        if (e.getActionCommand().equals("1/x")) {
            if (count % 2 == 0) {
                outcome.setText(String.valueOf((float) 1 / num2));
            } else {
                outcome.setText(String.valueOf(((float) 1 / num1)));
            }
            before = 0;
        }
        if (e.getActionCommand().equals(".")) {
            if (count % 2 == 0) {
                outcome.setText(String.valueOf((float) num2));
            } else {
                outcome.setText(String.valueOf(((float) num1)));
            }
            before = 0;
        }
        if (e.getActionCommand().equals("Backspace")) {
            result /= 10;
            outcome.setText(String.valueOf((result)));
            before = 0;
        }
    }
}






