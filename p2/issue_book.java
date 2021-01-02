package p2;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class issue_book extends Frame {
    Label book_l, user_l, period_l, date_l;
    TextField book_f, user_f, period_f, date_f;
    Button submit;
    String _bid, _uid, _period, _date;

    issue_book(){

    //Defining the labels

     book_l=new Label();
     book_l.setText("Book ID(BID)");
     book_l.setBounds(50, 60, 100, 30);
     user_l=new Label();
     user_l.setText("User ID(UID)");
     user_l.setBounds(50, 100, 100, 30);
     period_l=new Label();
     period_l.setText("Periods(days)");
     period_l.setBounds(50, 140, 100, 30);
     date_l=new Label();
     date_l.setText("Issued date(DD-MM-YYYY)");
     date_l.setBounds(50, 180, 160, 30);

     // Button
     submit = new Button("Submit");
     submit.setBounds(180, 220, 80, 30);


    //Defining the text fields

     book_f=new TextField();
     book_f.setBounds(160, 60, 200, 30);
     user_f=new TextField();
     user_f.setBounds(160, 100, 200, 30);
     period_f=new TextField();
     period_f.setBounds(160, 140, 200, 30);
     date_f=new TextField();
     date_f.setBounds(230,180,130,30);
     add(book_l);
     add(book_f);
     add(user_l);
     add(user_f);
     add(period_l);
     add(period_f);
     add(date_l);
     add(date_f);
     add(submit);
     setSize(400, 300);
     setTitle("Enter Details");
     setLayout(null);
     setVisible(true);
     addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e) {
        dispose();
        }
        });
    


    submit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            _uid = user_f.getText();
            _bid = book_f.getText();
            _period = period_f.getText();
            _date = date_f.getText();

            String sql = "INSERT INTO books_issued (uid,bid,issued_date,period) VALUES ('" + _uid + "','" + _bid + "','" + _date + "','" + _period + "')";
            try {
                Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
                if (con != null) {
                    Statement stmt = con.createStatement();
                    int result = stmt.executeUpdate(sql);
                    if (result != -1) {
                        System.out.println("Inserted" + result + "Record(s) successfully");
                        new book_issued();
                    } else {
                        System.out.println("Unable to insert record. Please check your SQL syntax");
                    }
                    stmt.close();
                    con.close();
                } else {
                    System.out.println("Unable to get the connection");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    });
}

    public static void main(String[] args) {
        new issue_book();
    }
}
