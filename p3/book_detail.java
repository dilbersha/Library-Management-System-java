package p3;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class book_detail {
    static String book_name, book_category, book_author;

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Add Book");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        JLabel l1 = new JLabel("Book name:");
        l1.setBounds(20, 20, 80, 30);
        JLabel l2 = new JLabel("Category:");
        l2.setBounds(20, 75, 80, 30);
        JLabel l3 = new JLabel("Author:");
        l3.setBounds(20, 130, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(100, 195, 80, 30);
        final JTextField bname_f = new JTextField();
        bname_f.setBounds(100, 20, 100, 30);
        final JTextField category_f = new JTextField();
        category_f.setBounds(100, 75, 100, 30);
        final JTextField author_f = new JTextField();
        author_f.setBounds(100, 130, 100, 30);

        f.add(l1);
        f.add(label);
        f.add(l2);
        f.add(l3);
        f.add(b);
        f.add(author_f);
        f.add(category_f);
        f.add(bname_f);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book_name = bname_f.getText();
                book_category = category_f.getText();
                book_author = author_f.getText();

                String sql = "INSERT INTO books_available (bname,category,author) VALUES ('" + book_name + "','"
                        + book_category + "','" + book_author + "')";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // String url = "jdbc:mysql://localhost:3306/library";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
                    if (con != null) {
                        Statement stmt = con.createStatement();
                        int result = stmt.executeUpdate(sql);
                        if (result != -1) {
                            System.out.println("Inserted" + result + "Record(s) successfully");
                            new book_added();
                            f.dispose();

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
                    new error();
                }

            }
        });
    }
}