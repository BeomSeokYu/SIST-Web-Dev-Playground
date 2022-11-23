package javaz.swing;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseEventTest extends JFrame implements MouseListener, MouseMotionListener {
    
    public MouseEventTest() {
        JTextField inputTxt = new JTextField(10);
        JButton clearBtn = new JButton("clear");
        JLabel inputLbl = new JLabel("INPUT");
        
        // Main Frame 기본 설정
        setSize(200, 200);
        setTitle("ActionEvent");
        setLocationRelativeTo(null);    // 프레임 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MouseEventTest();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("mouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("mouseMoved (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouseClicked");
        int count = e.getClickCount();
        System.out.println(count);
        if(count == 2)
            System.out.println("더블 클릭");
        else if (count == 1) {
            System.out.println("클릭");
        }
        System.out.println("(" +e.getX() + ", " + e.getY() + ")");
        
        switch (e.getButton()) {
            case 1:System.out.println("좌클릭");break;
            case 2:System.out.println("휠클릭");break;
            case 3:System.out.println("우클릭");break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited");
    }

}
