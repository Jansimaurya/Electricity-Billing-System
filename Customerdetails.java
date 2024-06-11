package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Customerdetails extends JFrame implements ActionListener {

    JTable table;
    JButton print;
   
    Customerdetails() {
        super("Customer Details");
        
        setSize(1200, 650);
        setLocation(200,150);
                
       table = new JTable();
       
       try {
            conn c = new conn();
          java.sql.ResultSet rs = c.s.executeQuery("select * from customer");
           
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       JScrollPane sp = new JScrollPane(table);
       add(sp);
        
        print= new JButton("Print");
       print.addActionListener(this);
        add(print, "South");
       
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         
              try {
                 table.print();
                  
                  
              } catch (Exception e) {
            e.printStackTrace();
        }
     }
    
    public static void main(String[] args) {
            new Customerdetails();
    }
    
}
