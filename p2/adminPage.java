package p2;

import java.awt.event.*;
import java.awt.*;

public class adminPage implements ActionListener{
    Button admin,librarian,student;
    Frame f;

    adminPage() {
        f=new Frame();
        Button admin = new Button("admin");
        admin.setBounds(150, 100,100,40);
        f.add(admin);
        admin.addActionListener(this);
        Button librarian = new Button("librarian");
        librarian.setBounds(150, 160,100,40);
        f.add(librarian);
        librarian.addActionListener(this);
        Button student = new Button("student");
        student.setBounds(150, 220,100,40);
        f.add(student);
        student.addActionListener(this);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setTitle("Library - Admin Panel");
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==admin){
                adminlogin admin=new adminlogin();
                admin.setVisible(true);
            }
            else if(e.getSource()==admin){
                adminlogin admin=new adminlogin();
                admin.setVisible(true);
            }
            else {
                adminlogin admin=new adminlogin();
                admin.setVisible(true);
            }
        }

        // admin.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //     }
        // });
    

    public static void main(String[] args) {
        new adminPage();
    }
}