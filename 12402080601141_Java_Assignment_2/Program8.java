//Program:8->Develop GUI-based Investment Calculator using Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Program8 extends JFrame implements ActionListener {

    JTextField principalField, rateField, timeField;
    JLabel resultLabel;
    JButton calculateBtn;

    
    Program8() {

        setTitle("Investment Calculator");
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Principal Amount:"));
        principalField = new JTextField();
        add(principalField);

        add(new JLabel("Rate (%):"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Time (years):"));
        timeField = new JTextField();
        add(timeField);

        calculateBtn = new JButton("Calculate");
        add(calculateBtn);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        calculateBtn.addActionListener(this);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double p = Double.parseDouble(principalField.getText());
            double r = Double.parseDouble(rateField.getText());
            double t = Double.parseDouble(timeField.getText());

            double amount = p * Math.pow((1 + r / 100), t);

            resultLabel.setText("Result: " + amount);

        } catch (Exception ex) {
            resultLabel.setText("Invalid Input!");
        }
    }

    public static void main(String[] args) {
        new Program8(); 
    }
}