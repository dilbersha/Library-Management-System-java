package p1;

import javax.swing.*;

public class user_not_added {
    JFrame f;

    user_not_added() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Failed", "Message", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new user_not_added();
    }
}
