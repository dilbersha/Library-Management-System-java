package p2;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class book_detail extends Frame{
    Label bname_l,category_l,author_l;
    TextField bname_f,category_f,author_f;
    String book_name,book_category,book_author;
    Button submit;
    book_detail(){

    //Defining the labels

     bname_l=new Label();
     bname_l.setText("Book name");
     bname_l.setBounds(50, 60, 100, 30);
     category_l=new Label();
     category_l.setText("category");
     category_l.setBounds(50, 100, 100, 30);
     author_l=new Label();
     author_l.setText("author");
     author_l.setBounds(50, 140, 100, 30);

     // Button
     submit = new Button("Submit");
     submit.setBounds(180, 190, 80, 30);


    //Defining the text fields

     bname_f=new TextField();
     bname_f.setBounds(160, 60, 200, 30);
     category_f=new TextField();
     category_f.setBounds(160, 100, 200, 30);
     author_f=new TextField();
     author_f.setBounds(160, 140, 200, 30);
     add(bname_l);
     add(bname_f);
     add(category_l);
     add(category_f);
     add(author_l);
     add(author_f);
     add(submit);
     setSize(400, 300);
     setTitle("Enter Book Details");
     setLayout(null);
     setVisible(true);
     addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e) {
        dispose();
        }
        });
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book_name = bname_f.getText();
                book_category = category_f.getText();
                book_author = author_f.getText();
    
                String sql = "INSERT INTO books_available (bname,category,author) VALUES ('" + book_name + "','" + book_category + "','" + book_author + "')";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
                    if (con != null) {
                        Statement stmt = con.createStatement();
                        int result = stmt.executeUpdate(sql);
                        if (result != -1) {
                            System.out.println("Inserted" + result + "Record(s) successfully");
                            new bookAdded();
                            
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
        new book_detail();
    }
}
