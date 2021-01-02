package p3;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class issue_book {
    static String _bid, _uid, _period, _date;

    public static void main(String[] args) {
        JFrame f = new JFrame("Issue Book");
        final JLabel l1 = new JLabel("Book ID(BID) : ");
        l1.setBounds(20, 20, 300, 50);
        final JLabel l2 = new JLabel("User ID(UID) : ");
        l2.setBounds(20, 75, 300, 50);
        final JLabel l3 = new JLabel("Periods(days) : ");
        l3.setBounds(20, 130, 300, 50);
        final JLabel l4 = new JLabel("Issued date(DD-MM-YYYY) : ");
        l4.setBounds(20, 185, 300, 50);
        JTextField book_f = new JTextField();
        book_f.setBounds(300, 30, 150, 30);
        JTextField user_f = new JTextField();
        user_f.setBounds(300, 85, 150, 30);
        JTextField period_f = new JTextField();
        period_f.setBounds(300, 140, 150, 30);
        JTextField date_f = new JTextField();
        date_f.setBounds(300, 195, 150, 30);
        JButton b = new JButton("Add Book");
        b.setBounds(200, 360, 150, 30);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(user_f);
        f.add(book_f);
        f.add(period_f);
        f.add(date_f);
        f.add(b);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _uid = user_f.getText();
                _bid = book_f.getText();
                _period = period_f.getText();
                _date = date_f.getText();

                String sql = "INSERT INTO books_issued (uid,bid,issued_date,period) VALUES ('" + _uid + "','" + _bid
                        + "','" + _date + "','" + _period + "')";
                try {
                   Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
                    if (con != null) {
                        Statement stmt = con.createStatement();
                        int result = stmt.executeUpdate(sql);
                        if (result != -1) {
                            System.out.println("Inserted" + result + "Record(s) successfully");
                            new book_issued();
                            f.dispose();
                        } else {
                            System.out.println("Unable to insert record. Please check your SQL syntax");
                            new user_not_added();
                        }
                        stmt.close();
                        con.close();
                    } else {
                            new user_not_added();
                            System.out.println("Unable to get the connection");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    new error();
                }
            }
        });
    }
}
