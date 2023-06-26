package javaz.swing;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class KeyEventTest extends JFrame implements KeyListener{
    
    public KeyEventTest() {
        JTextField inputTxt = new JTextField(10);
        JButton clearBtn = new JButton("clear");
        JLabel inputLbl = new JLabel("INPUT");
        
        // Main Frame 기본 설정
        setSize(250, 80);
        setTitle("ActionEvent");
        setLocationRelativeTo(null);    // 프레임 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        clearBtn.addActionListener(e -> {
            inputTxt.setText("");
            inputTxt.requestFocus();
        });
        inputTxt.addKeyListener(this);
        
        add(inputLbl);
        add(inputTxt);
        add(clearBtn);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyEventTest();
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("keyPressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("keyReleased");
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
        System.out.println(e.isActionKey());
        System.out.println(e.isControlDown());
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER: System.out.println("ENTER");
                                    break;
            case KeyEvent.VK_UP:    System.out.println("UP");
                                    break;
        }
    }

}
