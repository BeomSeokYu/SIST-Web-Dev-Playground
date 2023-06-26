package javaz.swing;

import java.awt.*;
import javax.swing.*;

public class LayoutTest extends JFrame {
   
    LayoutTest() {
//        flowLayout();
//        setFrame("Layout");
    }
    
    public void setFrame(String layoutMgr) {
        setSize(300, 150);
        setTitle(layoutMgr);
        setLocation(960-150, 540-100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }

    public void flowLayout() {
        JButton first = new JButton("first");
        JButton second = new JButton("second");
        JButton third = new JButton("third");
        JButton fourth = new JButton("fourth");
        JButton fifth = new JButton("fifth");
        
        add(first);
        add(second);
        add(third);
        add(fourth);
        add(fifth);
        
        setLayout(new FlowLayout());
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setFrame("FlowLayout");
    }
    
    public void borderLayout() {
        setLayout(new BorderLayout(10, 20)); // 프레임의 기본 레이아웃 매니저, 간격 조절
        
        JButton first = new JButton("first");
        JButton second = new JButton("second");
        JButton third = new JButton("third");
        JButton fourth = new JButton("fourth");
        JButton fifth = new JButton("fifth");
        
        add(first, BorderLayout.PAGE_START);
        add(second, BorderLayout.WEST);
        add(third, BorderLayout.EAST);
        add(fourth, BorderLayout.CENTER);
        add(fifth, BorderLayout.PAGE_END);
        
        setFrame("BorderLayout");
    }
    
    public void gridLayout() {
        JButton first = new JButton("first");
        JButton second = new JButton("second");
        JButton third = new JButton("third");
        JButton fourth = new JButton("fourth");
        JButton fifth = new JButton("fifth");
        
        add(first);
        add(second);
        add(third);
        add(fourth);
        add(fifth);
        
        setLayout(new GridLayout());
        setLayout(new GridLayout(2, 3)); // 2행 3열
        setLayout(new GridLayout(2, 3, 5, 10)); //  열간격
        setFrame("GridLayout");
    }
    
    public void nullLayout() {
        JButton first = new JButton("first");
        first.setBounds(5, 5, 80, 30);
        JButton second = new JButton("second");
        second.setBounds(90, 5, 100, 30);
        JButton third = new JButton("third");
        third.setBounds(90, 50, 70, 30);
        JButton fourth = new JButton("fourth");
        JButton fifth = new JButton("fifth");
        
        add(first);
        add(second);
        add(third);
        add(fourth);
        add(fifth);
        
        setLayout(null);
        setFrame("NullLayout");
    }
    
    public static void main(String[] args) {
        LayoutTest lt = new LayoutTest();
//        lt.flowLayout();
//        lt.borderLayout();
//        lt.gridLayout();
        lt.nullLayout();
    }

}
