package by.mixail167;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo {
    
    public SwingDemo() {
        JFrame jFrame = new JFrame("Simple Program");
        jFrame.setSize(640, 480);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Simple Program");
        jLabel.setBorder(BorderFactory.createEtchedBorder());
        JButton jButton1 = new JButton("First");
        JButton jButton2 = new JButton("Second");
        jButton1.addActionListener(e -> jLabel.setText("First"));
        jButton2.addActionListener(e -> jLabel.setText("Second"));
        JTextField jTextField = new JTextField(10);
        jTextField.addActionListener(e -> jTextField.setText("Current content: " + jTextField.getText()));
        jFrame.setLayout(new FlowLayout());
        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.setLocationByPlatform(true);
        jFrame.setVisible(true);
    }
}
