import java.awt.event.*;
import java.awt.*;

public class user_added extends Frame {
    Label heading;
    Button ok;

    user_added() {
        Label heading = new Label();
        heading.setBounds(110, 60, 100, 30);
        heading.setText("User Added");
        Button ok = new Button("OK");
        ok.setBounds(130, 100, 50, 30);
        add(heading);
        add(ok);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setTitle("Message");
        setSize(300, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new user_added();
    }
}