package javaz.swing;

import javaz.member.*;
import java.awt.*;
import javax.swing.*;

public class LoginWindow extends JFrame {
    private JPanel loginPnl;
    private JButton loginBtn, cancelBtn;
    private JLabel idLbl, pwLbl;
    private JTextField idTxt;
    private JPasswordField pwTxt;
   
    public LoginWindow() {
        setSize(250, 130);
        setTitle("Login");
        setLocationRelativeTo(null);    // 프레임 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
        
        loginPnl = new JPanel(new FlowLayout());
        
        idLbl = new JLabel("ID                ");
        idTxt = new JTextField(12);
        
        pwLbl = new JLabel("Password");
        pwTxt = new JPasswordField(12);
        
        cancelBtn = new JButton("CANCEL");
        cancelBtn.addActionListener(e -> System.exit(0));
        loginBtn = new JButton("LOGIN");
        loginBtn.addActionListener(e -> {
            String id = idTxt.getText();
            String pw = String.valueOf(pwTxt.getPassword());
            if(id.equals("")) {
                JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요");
            }
            else if(pw.equals("")) {
                JOptionPane.showMessageDialog(this, "비밀번호를 입력해 주세요");
            }
            else if(new LoginCheck().checkMember(id, pw)) {
                JOptionPane.showMessageDialog(this, id + " 님 어서오세요.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 일치하지 않습니다.");
                idTxt.setText("");
                idTxt.requestFocus();
                pwTxt.setText("");
                //loginBtn.setfoc
            }
        });
        
        loginPnl.add(idLbl);
        loginPnl.add(idTxt);
        loginPnl.add(pwLbl);
        loginPnl.add(pwTxt);
        loginPnl.add(cancelBtn);
        loginPnl.add(loginBtn);
        
        add(loginPnl);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }

}
