package javaz.swing;

import java.awt.*;

import javax.swing.*;

public class JButtonTest extends JFrame {
    
    public JButtonTest() {
        setSize(300, 300);
        setTitle("JFrame Extends");
        setLocation(960-450, 540-100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JButton imgB = new JButton("Image Button", new ImageIcon("C:\\dev\\workspace\\javaz\\dukeSmall.png"));
        imgB.setVerticalTextPosition(AbstractButton.BOTTOM);
        imgB.setHorizontalTextPosition(AbstractButton.CENTER);
        add(imgB);
        
        JCheckBox cb1 = new JCheckBox("RED");
        JCheckBox cb2 = new JCheckBox("GREEN");
        JCheckBox cb3 = new JCheckBox("BLUE");
        add(cb1);
        add(cb2);
        add(cb3);
        
        JRadioButton rb1 = new JRadioButton("RED");
        JRadioButton rb2 = new JRadioButton("GREEN");
        JRadioButton rb3 = new JRadioButton("BLUE");
        add(rb1);
        add(rb2);
        add(rb3);
        
        JRadioButton rb4 = new JRadioButton("RED");
        JRadioButton rb5 = new JRadioButton("GREEN");
        JRadioButton rb6 = new JRadioButton("BLUE");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb4);
        bg.add(rb5);
        bg.add(rb6);
        add(rb4);
        add(rb5);
        add(rb6);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new JButtonTest();
    }

}
