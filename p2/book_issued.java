package p2;
import java.awt.event.*;


import java.awt.*;

public class book_issued extends Frame {
    Label heading;
    Button ok;

    book_issued() {
        Label heading = new Label();
        heading.setBounds(110, 60, 100, 30);
        heading.setText("Book issued");
        Button ok = new Button("OK");
        ok.setBounds(130, 100, 50, 30);
        add(heading);
        add(ok);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        setTitle("Message");
        setSize(300, 200);
        setLayout(null);
        setVisible(true);
    }

    

    public static void main(String[] args) {
        new book_issued();
    }
}