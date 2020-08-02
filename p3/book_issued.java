package p3;

import javax.swing.*;

public class book_issued {
    JFrame f;

    book_issued() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Book Issued ", "Message", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new book_issued();
    }
}