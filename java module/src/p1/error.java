package p1;

import javax.swing.*;

public class error {
    JFrame f;

    public error() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Error Occured", "Message", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new error();
    }
}
