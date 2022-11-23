package javaz.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class JTextFieldTest extends JFrame {
    
    public JTextFieldTest() {
        setSize(300, 200);
        setTitle("JFrame Extends");
        setLocation(960-450, 540-100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JLabel l1 = new JLabel("JTextField", JLabel.LEFT);
        add(l1);
        JTextField t1 = new JTextField(10);
        add(t1);
        
        JLabel l2 = new JLabel("JPasswordField");
        add(l2);
        JPasswordField p1 = new JPasswordField(10);
        add(p1);
        
        add(new JLabel("JComboBox1"));
        JComboBox<String> cb1 = new JComboBox<>(new String[] {"item1", "item2"});
        cb1.addItem("item3");
        cb1.addItem("item4");
        add(cb1);
        
        add(new JLabel("JComboBox1"));
        String[] rgb = new String[] {"red", "green", "blue"};
        JComboBox<String> cb2 = new JComboBox<>(rgb);
        add(cb2);
        
        add(new JLabel("JSpinner"));
        SpinnerModel numModel = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner sp = new JSpinner(numModel);
        add(sp);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new JTextFieldTest();
    }

}
