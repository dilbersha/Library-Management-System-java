package p3;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class adminlogin {
    static String _a_username, _a_password;

    public static void main(String[] args) {
        JFrame f = new JFrame("Admin Login");
        JLabel a_username = new JLabel("Username:");
        a_username.setBounds(20, 20, 80, 30);
        JLabel a_password = new JLabel("Password:");
        a_password.setBounds(20, 75, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(100, 120, 80, 30);
        final JPasswordField pass_f = new JPasswordField();
        pass_f.setBounds(100, 75, 100, 30);
        final JTextField user_f = new JTextField();
        user_f.setBounds(100, 20, 100, 30);
        f.add(user_f);
        f.add(a_username);
        f.add(pass_f);
        f.add(b);
        f.add(a_password);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _a_username = user_f.getText();
                _a_password = new String(pass_f.getPassword());

                String sql = "SELECT password FROM staff_list where name='" + _a_username + "'";
                try {
                  Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
                    if (con != null) {
                        Statement stmt = con.createStatement();
                        ResultSet password = stmt.executeQuery(sql);
			
			password.next();
                        if (password.getString(1).equals(_a_password)) {
                             System.out.println("Logged in");
                          //  new loggedin();
                        }
                        stmt.close();
                        con.close();
                    } else {
                        System.out.println("Unable to get the connection");
                        new user_not_added();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    new error();
                }

            }
        });
    }
}
