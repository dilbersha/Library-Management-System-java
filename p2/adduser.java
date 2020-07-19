package p2;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class adduser extends Frame {
    Label username, password;
    TextField user_f, pass_f;
    CheckboxGroup type;
    Checkbox admin, user;
    Button create;
    String _username, _password;

    adduser() {

        // Defining the labels
        type = new CheckboxGroup();
        username = new Label();
        username.setText("Username");
        username.setBounds(50, 60, 100, 30);
        password = new Label();
        password.setText("Password");
        password.setBounds(50, 100, 100, 30);
        // Button
        create = new Button("Create");
        create.setBounds(180, 180, 80, 30);

        // Defining the text fields

        user_f = new TextField();
        user_f.setBounds(160, 60, 200, 30);
        pass_f = new TextField();
        pass_f.setBounds(160, 100, 200, 30);
        add(username);
        add(user_f);
        add(password);
        add(pass_f);
        add(create);
        setSize(400, 250);
        setTitle("Enter Details");
        setLayout(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _username = user_f.getText();
                _password = pass_f.getText();

                String sql = "INSERT INTO users (username,password) VALUES ('" + _username + "','" + _password + "')";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/library";
                    Connection con = DriverManager.getConnection(url, "root", "root");
                    if (con != null) {
                        Statement stmt = con.createStatement();
                        int result = stmt.executeUpdate(sql);
                        if (result != -1) {
                            System.out.println("Inserted" + result + "Record(s) successfully");
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
        new adduser();
    }
}