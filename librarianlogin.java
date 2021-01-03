package libpro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class librarianlogin {
    public static void main(String[] args){
        JFrame log=new JFrame("Librarian Login");
        final JLabel l1=new JLabel("Username:");
        final JLabel l2=new JLabel("Password");
        l1.setBounds(20,20,80,30);
        l2.setBounds(20,75,80,30);
        final JTextField t1=new JTextField();
        final JPasswordField p1=new JPasswordField();
        t1.setBounds(100,20,100,30);
        p1.setBounds(100,75,100,30);
        JButton b=new JButton("Login");
        b.setBounds(100,120,80,30);
        log.add(l1);log.add(l2);log.add(t1);log.add(p1);log.add(b);
        log.setSize(300,200);
        log.setLayout(null);
        log.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1=t1.getText();
                    String s2= String.valueOf(p1.getPassword());
                    //Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Anandu1998@mysql");
                    Statement stmt=con.createStatement();
                    String q1="Select * from staff_list where password='"+s2+"'";
                    ResultSet rs=stmt.executeQuery(q1);
                    if (rs.next())
                    {
                        if((rs.getString(5).equals(s2))&&(rs.getString(2).equals(s1)))
                        {

                            new librarian();

                        }

                    }
                    else
                    {
                        new invalid();
                    }
                    con.close();


                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }



            }
        });
    }
}
