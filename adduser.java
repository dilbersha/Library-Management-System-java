import java.awt.event.*;
import java.awt.*;

public class adduser extends Frame {
    Label username, password;
    TextField user_f, pass_f;
    CheckboxGroup type;
    Checkbox admin,user;
    Button create;

    adduser() {

        // Defining the labels
        type=new CheckboxGroup();
        username = new Label();
        username.setText("Username");
        username.setBounds(50, 60, 100, 30);
        password = new Label();
        password.setText("Password");
        password.setBounds(50, 100, 100, 30);
        admin= new Checkbox("Admin",type,false);
        admin.setBounds(100,140,80,30);
        user= new Checkbox("User",type,false);
        user.setBounds(200,140,80,30);
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
        add(admin);
        add(user);
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
    }

    public static void main(String[] args) {
        new adduser();
    }
}