package p3;

import javax.swing.*;

public class loggedin {
    JFrame f;

    loggedin() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Succesfully Logged in", "Message", JOptionPane.DEFAULT_OPTION);
    }

    public static void main(String[] args) {
        new loggedin();
    }
}