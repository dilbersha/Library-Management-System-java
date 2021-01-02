package p3;

import javax.swing.*;

public class book_not_added {
    JFrame f;

    book_not_added() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Book adding failed", "Message", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new book_not_added();
    }
}