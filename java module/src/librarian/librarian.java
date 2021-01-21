package librarian;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class librarian {
    public librarian()
    {
        JFrame lib=new JFrame("Librarian Menu");
        JButton b1=new JButton("View Books");
        JButton b2=new JButton("View Students");
        JButton b3=new JButton("View Issued Books");
        JButton b4=new JButton("Issue Book");
        JButton b5=new JButton("Add Student");
        JButton b6=new JButton("Add Book");
        JButton b7=new JButton("Return Book");
        b1.setBounds(20,30,150,40);
        b2.setBounds(180,30,150,40);
        b3.setBounds(340,30,150,40);
        b4.setBounds(500,30,150,40);
        b5.setBounds(95,80,150,40);
        b6.setBounds(255,80,150,40);
        b7.setBounds(415,80,150,40);

        lib.add(b1);lib.add(b2);lib.add(b3);lib.add(b4);lib.add(b5);lib.add(b6);lib.add(b7);
        lib.setSize(680,200);
        lib.setLayout(null);
        lib.setVisible(true);
        b1.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new p1.Adminp1t1();

            }
        }));
        b2.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new p1.Adminstudenttable();

            }
        }));
        b3.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		new p1.Adminp1t2();
            }
        }));
        b4.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		new p2.issue_book();
            }
        }));
        b5.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
new addstu();
            }
        }));
        b6.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
new book_detail();
            }
        }));
        b7.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
new retbook();
            }
        }));

    }
    public static void main(String[] args){
        new librarian();


}
}
