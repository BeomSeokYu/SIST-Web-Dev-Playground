package javaz.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;

public class JTableTest extends JFrame {
    
    public JTableTest() {
        setSize(400, 150);
        setTitle("JTable Test");
        setLocation(960-200, 540-150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
        
        
        String[] tblHeader = {"Name", "Age", "Address"};
        String[][] tblData = {  
                                {"Kim", "20", "SEOUL"},
                                {"Lee", "30", "JEJU"}, 
                                {"Han", "40", "BUSAN"},
                                {"San", "50", "MUKO"},
                                {"Ann", "60", "ISLAND"},
                                {"Max", "70", "HONG"}
                             };
        JTable t = new JTable(tblData, tblHeader);
        JScrollPane sp = new JScrollPane(t);
        add(sp);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTableTest();
    }

}
