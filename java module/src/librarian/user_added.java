package librarian;

import javax.swing.*;

public class user_added {
    JFrame f;

    public user_added() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "User Added ", "Message", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new user_added();
    }
}
