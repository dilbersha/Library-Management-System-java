package p3;

import javax.swing.*;

public class book_issued {
    JFrame f;

    book_issued() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Book Issued ", "Message", JOptionPane.DEFAULT_OPTION);
    }

    public static void main(String[] args) {
        new book_issued();
    }
}