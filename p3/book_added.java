package p3;

import javax.swing.*;

public class book_added {
    JFrame f;

    book_added() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Book Added ", "Message", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new book_added();
    }
}