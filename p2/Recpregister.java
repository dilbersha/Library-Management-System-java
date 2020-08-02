package p2;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Recpregister extends Frame {
  Button b;
  Label l1, l2, l3, l4;
  TextField tf1, tf2, tf3, tf4;
  String username, password, email, phn;

  Recpregister() {
    setBackground(Color.LIGHT_GRAY);
    setTitle("Login");
    l1 = new Label("Username:", Label.CENTER);
    l2 = new Label("Password:", Label.CENTER);
    l3 = new Label("Email:", Label.CENTER);
    l4 = new Label("Phone no:", Label.CENTER);

    tf1 = new TextField();
    tf2 = new TextField();
    tf3 = new TextField();
    tf4 = new TextField();

    tf2.setEchoChar('*');
    b = new Button("Register");
    l1.setBounds(10, 45, 90, 25);
    l2.setBounds(10, 85, 90, 25);
    l3.setBounds(10, 125, 90, 25);
    l4.setBounds(10, 165, 90, 25);
    tf1.setBounds(100, 50, 140, 25);
    tf2.setBounds(100, 90, 140, 25);
    tf3.setBounds(100, 130, 160, 25);
    tf4.setBounds(100, 170, 140, 25);
    b.setBounds(85, 225, 80, 30);
    b.setBackground(Color.BLACK);
    b.setForeground(Color.WHITE);
    add(l1);
    add(tf1);
    add(l2);
    add(tf2);
    add(l3);
    add(tf3);
    add(l4);
    add(tf4);
    add(b);
    setSize(300, 350);
    setLayout(null);
    setVisible(true);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
        dispose();
      }
    });

    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        username = tf1.getText();
        password = tf2.getText();
        email = tf3.getText();
        phn = tf4.getText();

        String sql = "INSERT INTO register (Username,Password,Email,Phone) VALUES ('" + username + "','" + password
            + "','" + email + "','" + phn + "');";

        try {

          


          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "root", "Athila99*");
          // here Hospital is database name, root is username
          if (con != null) {
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
            if (rs != -1) {
              System.out.println("Inserted" + rs + "Recorded Successfully!");
            } else {
              System.out.println("Unable to insert record");
            }
            stmt.close();
            con.close();
          } else {
            System.out.println("Unable to get connection!");
          }

        } catch (Exception ex) {
          System.out.println(ex);
        }
      }
    });

  }

  public static void main(String args[]) {
    new Recpregister();
  }
}