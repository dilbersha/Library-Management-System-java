package librarian;

import p1.error;
import p1.user_not_added;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class addstu {
    static String _username, _password, _class, _branch, _sex, _phone;
public addstu() {
    JFrame f = new JFrame("Add user");
    final JLabel l1 = new JLabel("Name : ");
    l1.setBounds(20, 20, 200, 50);
    final JLabel l2 = new JLabel("Class : ");
    l2.setBounds(20, 75, 200, 50);
    final JLabel l3 = new JLabel("Branch : ");
    l3.setBounds(20, 130, 200, 50);
    final JLabel l4 = new JLabel("Sex : ");
    l4.setBounds(20, 185, 200, 50);
    final JLabel l5 = new JLabel("Phone : ");
    l5.setBounds(20, 240, 200, 50);
    final JLabel l6 = new JLabel("Password : ");
    l6.setBounds(20, 295, 200, 50);
    final JPasswordField pass_f = new JPasswordField();
    pass_f.setBounds(100, 305, 130, 30);
    JTextField username_f = new JTextField();
    username_f.setBounds(100, 30, 150, 30);
    JTextField class_f = new JTextField();
    class_f.setBounds(100, 85, 150, 30);
    JTextField branch_f = new JTextField();
    branch_f.setBounds(100, 140, 150, 30);
    JTextField sex_f = new JTextField();
    sex_f.setBounds(100, 195, 150, 30);
    JTextField phone_f = new JTextField();
    phone_f.setBounds(100, 250, 150, 30);
    JButton b = new JButton("Add");
    b.setBounds(100, 360, 150, 30);
    f.add(l1);
    f.add(l2);
    f.add(l3);
    f.add(l4);
    f.add(l5);
    f.add(l6);
    f.add(class_f);
    f.add(branch_f);
    f.add(sex_f);
    f.add(phone_f);
    f.add(pass_f);
    f.add(username_f);
    f.add(b);
    f.setSize(450, 500);
    f.setLayout(null);
    f.setVisible(true);

    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new user_added();

            _username = username_f.getText();
            _password = new String(pass_f.getPassword());
            _class = class_f.getText();
            _branch = branch_f.getText();
            _sex = sex_f.getText();
            _phone = phone_f.getText();

            String sql = "INSERT INTO student_list (name,class,branch,password,sex,PHONE) VALUES ('" + _username
                    + "','" + _class + "','" + _branch + "','" + _password + "','" + _sex + "','" + _phone + "')";
            try {

                String url = "jdbc:mysql://localhost:3306/library";
                Connection con = DriverManager.getConnection(url, "root", "devmodeon");
                if (con != null) {
                    Statement stmt = con.createStatement();
                    int result = stmt.executeUpdate(sql);
                    if (result != -1) {
                        System.out.println("Inserted" + result + "Record(s) successfully");
                        f.dispose();
                        new user_added();
                    } else {
                        System.out.println("Unable to insert record. Please check your SQL syntax");
                        new user_not_added();
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
    public static void main(String[] args) {
        new addstu();
    }}