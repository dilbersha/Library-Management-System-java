package p1;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class B1 extends JFrame implements ActionListener
{

JTextField tf1,tf2;
	B1()
	{
		
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
		
		tf1=new JTextField();
		tf2=new JTextField();
		l1.setText("Issue ID (ID)");
		l1.setBounds(50,50,150,20);
		tf1.setBounds(210,50,150,20);
		l2.setText("Return Date (YYYY-MM-DD)");
		l2.setBounds(50,100,150,20);
		tf2.setBounds(210,100,150,20);
		JButton b1=new JButton("Return");
		b1.setBounds(250,300,150,20);
		b1.addActionListener(this);
		add(l1);add(tf1);add(l2);add(tf2);add(b1);
		setLayout(null);
		setVisible(true);
		setSize(600, 400);
		setTitle("Enter Details");
		
	}
	public void actionPerformed(ActionEvent e)
	{
try{
			
Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
			Statement stmt = con.createStatement();
			
			
String s1=tf1.getText();
String s2="'"+tf2.getText()+"'";
String q="update books_issued set return_date="+s2+" where iid ="+s1+";"; 
stmt.executeUpdate(q);
String q1="select bid from books_issued where iid ="+s1+";"; 

ResultSet rs=stmt.executeQuery(q1);
boolean t=rs.next();


int bid =rs.getInt(1);

String q2="update books_available set available='T' where bid ="+bid+";"; 
stmt.executeUpdate(q2);

con.close();

JOptionPane.showMessageDialog(this,"Book Returned");
		//f.setSize(400,400);
}
catch(Exception ex)
{
System.out.println(ex);
}

		
System.exit(0);
	}
		
         public static void main(String[] args)
		{
		new B1();

                }
}

