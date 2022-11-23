package javaz.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ActionEventTest extends JFrame implements ActionListener{
    static JLabel resultLbl;
    
    public ActionEventTest() {
        JPanel panel = new JPanel();
        JButton inner = new JButton("inner");
        JButton outer = new JButton("outner");
        JButton impl = new JButton("impl");
        JButton anony = new JButton("anony");
        JButton lambda = new JButton("lambda");
        JButton clear = new JButton("clear");
        Border border = BorderFactory.createTitledBorder("SELECT");
        resultLbl = new JLabel("RESULT RABEL", JLabel.CENTER);
        
        // Main Frame 기본 설정
        setSize(500, 150);
        setTitle("ActionEvent");
        setLocationRelativeTo(null);    // 프레임 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        resultLbl.setFont(new Font("Arial Black", Font.BOLD, 30));
        resultLbl.setForeground(Color.gray);
        
        inner.addActionListener(new InnerActionLitener());
        outer.addActionListener(new OuterActionLitener());
        impl.addActionListener(this);
        anony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLbl.setText(e.getActionCommand());
            }
        });
        lambda.addActionListener(e -> resultLbl.setText(e.getActionCommand()));
        clear.addActionListener(e -> resultLbl.setText(""));
        clear.setBackground(Color.white);
        
        panel.setBorder(border);
        panel.add(inner);
        panel.add(outer);
        panel.add(impl);
        panel.add(anony);
        panel.add(lambda);
        panel.add(clear);
        
        add(resultLbl, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        resultLbl.setText(e.getActionCommand());
    }
    
    class InnerActionLitener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resultLbl.setText(e.getActionCommand());
        }
        
    }
    
    public static void main(String[] args) {
        new ActionEventTest();
    }
}

class OuterActionLitener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ActionEventTest.resultLbl.setText(e.getActionCommand());
    }
    
}
