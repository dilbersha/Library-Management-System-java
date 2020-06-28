import java.awt.event.*;
import java.awt.*;
public class book_detail extends Frame{
    Label bname_l,genre_l,price_l;
    TextField bname_f,genre_f,price_f;
    Button submit;
    book_detail(){

    //Defining the labels

     bname_l=new Label();
     bname_l.setText("Book name");
     bname_l.setBounds(50, 60, 100, 30);
     genre_l=new Label();
     genre_l.setText("Genre");
     genre_l.setBounds(50, 100, 100, 30);
     price_l=new Label();
     price_l.setText("Price");
     price_l.setBounds(50, 140, 100, 30);

     // Button
     submit = new Button("Submit");
     submit.setBounds(180, 190, 80, 30);


    //Defining the text fields

     bname_f=new TextField();
     bname_f.setBounds(160, 60, 200, 30);
     genre_f=new TextField();
     genre_f.setBounds(160, 100, 200, 30);
     price_f=new TextField();
     price_f.setBounds(160, 140, 200, 30);
     add(bname_l);
     add(bname_f);
     add(genre_l);
     add(genre_f);
     add(price_l);
     add(price_f);
     add(submit);
     setSize(400, 300);
     setTitle("Enter Book Details");
     setLayout(null);
     setVisible(true);
     addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e) {
        dispose();
        }
        });
    }
    public static void main(String[] args) {
        new book_detail();
    }
}