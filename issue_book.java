import java.awt.event.*;
import java.util.Date;
import java.awt.*;
public class issue_book extends Frame{
    Label book_l,user_l,period_l,date_l;
    TextField book_f,user_f,period_f;
    Date date_f;
    Button submit;
    issue_book(){

    //Defining the labels

     book_l=new Label();
     book_l.setText("Book ID(BID)");
     book_l.setBounds(50, 60, 100, 30);
     user_l=new Label();
     user_l.setText("User ID(UID)");
     user_l.setBounds(50, 100, 100, 30);
     period_l=new Label();
     period_l.setText("Periods(days)");
     period_l.setBounds(50, 140, 100, 30);
     date_l=new Label();
     date_l.setText("Issued date(DD-MM-YYYY");
     date_l.setBounds(50, 180, 160, 30);

     // Button
     submit = new Button("Submit");
     submit.setBounds(180, 220, 80, 30);


    //Defining the text fields

     book_f=new TextField();
     book_f.setBounds(160, 60, 200, 30);
     user_f=new TextField();
     user_f.setBounds(160, 100, 200, 30);
     period_f=new TextField();
     period_f.setBounds(160, 140, 200, 30);
     date_f=new Date();
     add(book_l);
     add(book_f);
     add(user_l);
     add(user_f);
     add(period_l);
     add(period_f);
     add(date_l);
     add(submit);
     setSize(400, 300);
     setLayout(null);
     setVisible(true);
     addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e) {
        dispose();
        }
        });
    }
    public static void main(String[] args) {
        new issue_book();
    }
}