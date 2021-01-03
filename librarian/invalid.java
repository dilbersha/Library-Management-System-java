package librarian;
import javax.swing.*;

public class invalid {
    JFrame inv;
    invalid (){
        inv=new JFrame();
        JOptionPane.showMessageDialog(inv,"Invalid Details Entered","Alert",JOptionPane.WARNING_MESSAGE);
    }
    public static void main(String[] args) {
        new invalid ();
    }
}
