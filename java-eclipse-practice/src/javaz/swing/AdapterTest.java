package javaz.swing;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class AdapterTest extends JFrame {
    
    public AdapterTest() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.gray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.yellow);
            }
            
        });
        
        setSize(200, 200);
        setTitle("AdapterTest");
        setLocationRelativeTo(null);    // 프레임 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(panel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AdapterTest();
    }
}
