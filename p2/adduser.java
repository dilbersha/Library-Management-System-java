package p2;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class adduser extends Frame {
    Label username, password,class_l,branch,sex,phone;
    TextField user_f, pass_f,class_f,branch_f,sex_f,phone_f;
    CheckboxGroup type;
    Checkbox admin, user;
    Button create;
    String _username, _password,_class,_branch,_sex,_phone;

    adduser() {

        // Defining the labels
        username = new Label();
        username.setText("Name");
        username.setBounds(50, 60, 100, 30);
        class_l = new Label();
        class_l.setText("Class");
        class_l.setBounds(50, 100, 100, 30);
        branch = new Label();
        branch.setText("Branch");
        branch.setBounds(50, 140, 100, 30);
        sex = new Label();
        sex.setText("Sex");
        sex.setBounds(50, 180, 100, 30);
        phone = new Label();
        phone.setText("Phone");
        phone.setBounds(50, 220, 100, 30);
        password = new Label();
        password.setText("Password");
        password.setBounds(50, 260, 100, 30);
        // Button
        create = new Button("Create");
        create.setBounds(180, 300, 80, 30);

        // Defining the text fields

        user_f = new TextField();
        user_f.setBounds(160, 60, 200, 30);
        class_f = new TextField();
        class_f.setBounds(160, 100, 200, 30);
        branch_f = new TextField();
        branch_f.setBounds(160, 140, 200, 30);
        sex_f = new TextField();
        sex_f.setBounds(160, 180, 200, 30);
        phone_f = new TextField();
        phone_f.setBounds(160, 220, 200, 30);
        pass_f = new TextField();
        pass_f.setBounds(160, 260, 200, 30);
        add(username);
        add(user_f);
        add(password);
        add(pass_f);
        add(class_f);
        add(class_l);
        add(sex);
        add(sex_f);
        add(phone);
        add(phone_f);
        add(branch);
        add(branch_f);
        add(create);
        setSize(500, 500);
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
                _class = class_f.getText();
                _branch = branch_f.getText();
                _sex = sex_f.getText();
                _phone = phone_f.getText();

                String sql = "INSERT INTO student_list (name,class,branch,password,sex,PHONE) VALUES ('" + _username + "','" + _class + "','" + _branch + "','" + _password + "','" + _sex + "','" + _phone + "')";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
                    if (con != null) {
                        Statement stmt = con.createStatement();
                        int result = stmt.executeUpdate(sql);
                        if (result != -1) {
                            System.out.println("Inserted" + result + "Record(s) successfully");
                            new user_added();
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
