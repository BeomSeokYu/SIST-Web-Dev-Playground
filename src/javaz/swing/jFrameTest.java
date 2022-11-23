package javaz.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class jFrameTest extends JFrame {
    
    public jFrameTest() {
        setSize(300, 200);
        setTitle("JFrame Extends");
        setLocation(960-450, 540-100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.PINK);
        
        JButton btnX = new JButton("X");
        btnX.addActionListener(e -> System.exit(0));
        add(btnX);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame("jFrame Object");             // 프레임 객체 생성
        JButton btn = new JButton("CLOSE");                 // 버튼 객체 생성
        btn.addActionListener(new ActionListener() {        // 버튼 클릭 이벤트 
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();                                // 자원 반납
                System.exit(0);                             // 프로그램 
            }
        });
        f.add(btn);                                         // 프레임에 버튼 추가 
        f.setLayout(new FlowLayout());                      // 프레임의 레이아웃 
        f.pack();                                           // 자동 크기 설정
        f.setSize(300, 200);                                // 크기 임의 설정
        f.setResizable(false);                              // 사이즈 조절 불가
        f.setLocation(960-50, 540-100);                     // 프레임 위치 조정
        f.getContentPane().setBackground(new Color(55, 55, 55));    // 프레임 배경색 지정
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 닫기 시 기본 설정
        f.setVisible(true);                                 // 보이게 설정
        new jFrameTest();
    }

}