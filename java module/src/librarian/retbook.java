package librarian;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class retbook extends JFrame implements ActionListener{
    JTextField tf1;
    public retbook (){
        JLabel l1=new JLabel();
        tf1=new JTextField();
        l1.setText("Book ID");
        l1.setBounds(50,50,150,20);
        tf1.setBounds(210,50,150,20);
        JButton b1=new JButton("Return");
        b1.setBounds(225,100,150,20);
        b1.addActionListener(this);
        add(l1);add(b1);add(tf1);
        setLayout(null);
        setVisible(true);
        setSize(600, 200);
        setTitle("RETURN BOOK");
    }
    public void actionPerformed(ActionEvent e){

        try{

//Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","devmodeon");
            Statement stmt = con.createStatement();
            System.out.println("hello00");
            String s1=tf1.getText();
            System.out.println(s1);
            int n=Integer.parseInt(s1);
            System.out.println("hello0");
            String q1="UPDATE `library`.`books_available` SET `available` = 'T' WHERE bid="+n+";";
            stmt.executeUpdate(q1);
            System.out.println("hello1");
            String q2="Delete from `books_issued` where bid="+n+";";
stmt.executeUpdate(q2);
            con.close();
            dispose();
            JOptionPane.showMessageDialog(this,"Successfully Returned");
            //f.setSize(400,400);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }


    }
    public static void main(String[] args){
        new retbook();
    }
}
