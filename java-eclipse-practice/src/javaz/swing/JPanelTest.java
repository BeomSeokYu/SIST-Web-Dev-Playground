package javaz.swing;

import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;

public class JPanelTest extends JFrame {
    public JPanelTest() {
        setSize(500, 300);
        setTitle("JPanel Test");
        setLocation(960-250, 540-250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JPanel yellowPanel = new JPanel();
        JPanel bluishPanel = new JPanel();
        
        yellowPanel.setBackground(Color.yellow);
        bluishPanel.setBackground(new Color(50, 50, 255));
        
        JButton b1 = new JButton("X");
        b1.addActionListener(e -> System.exit(0));
        bluishPanel.add(b1);
        JButton b2 = new JButton("2nd Button");
        b2.addActionListener(null);
        bluishPanel.add(b2);
        JButton b3 = new JButton("3rd Button");
        b3.addActionListener(null);
        bluishPanel.add(b3);
        
        JLabel l1 = new JLabel("Hello");
        JLabel l2 = new JLabel();
        l2.setText("Duke~");
        l2.setFont(new Font("Arial Black", Font.BOLD, 30));
        l2.setForeground(Color.green);
        JLabel l3 = new JLabel(new ImageIcon("C:\\dev\\workspace\\javaz\\Duke.png"));
        yellowPanel.add(l1);
        yellowPanel.add(l2);
        yellowPanel.add(l3);
        
        add(bluishPanel);
        add(yellowPanel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new JPanelTest();
    }

}
