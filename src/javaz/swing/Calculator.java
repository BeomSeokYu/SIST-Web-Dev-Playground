package javaz.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame {
    private JPanel displayPanel;
    private JPanel buttonPanel;
    private JButton[] button;
    private JLabel displayLabel;
    private String[] buttonName =  {"%", "√", "X²", "¹/x",
                                    "CE", "C", "←", "/",
                                    "7", "8", "9", "*",
                                    "4", "5", "6", "-",
                                    "1", "2", "3", "+",
                                    "0", ".", "±", "=",};
    public Calculator() {
        // Main Frame 기본 설정
        setSize(350, 450);
        setTitle("Calculator v.1");
        setLocationRelativeTo(null);    // 프레임 가운데 배치
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // DisplayPanel 생성
        displayPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        // DisplayLabel 생성
        displayLabel = new JLabel("0", JLabel.RIGHT);
        displayLabel.setFont(new Font("Consolas", Font.PLAIN, 50));
        displayLabel.setBackground(Color.gray);
        displayLabel.setForeground(Color.white);
        displayPanel.add(displayLabel);
        displayPanel.setBackground(Color.darkGray);
        // ButtonPanel 생성
        buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBackground(Color.darkGray);
        // Button 생성
        button = new JButton[24];
        Font buttonFont = new Font("Consolas", Font.PLAIN, 20);
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(buttonName[i]);
            button[i].setFont(buttonFont);
            button[i].setBackground(Color.gray);
            button[i].setForeground(Color.white);
            buttonPanel.add(button[i]);
        }
        // Frame에 Panel 추가
        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        // 화면 출력
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
