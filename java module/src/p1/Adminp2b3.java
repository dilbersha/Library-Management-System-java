package p1;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Adminp2b3 extends JFrame implements ActionListener
{

JTextField tf1,tf2,tf3,tf4;
	Adminp2b3()
	{
		
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
                JLabel l3=new JLabel();
                
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		

		l1.setText("Name");
		l1.setBounds(50,50,150,20);
		tf1.setBounds(210,50,150,20);
		l2.setText("ID");
		l3.setText("Designation");
		
		l2.setBounds(50,100,150,20);
		tf2.setBounds(210,100,150,20);
		l3.setBounds(50,140,150,20);
		tf3.setBounds(210,140,150,20);
		





		JButton b1=new JButton("Remove");
		b1.setBounds(225,300,150,20);
		b1.addActionListener(this);
		add(l1);add(tf1);add(l2);add(tf2);add(l3);add(tf3);add(b1);
		setLayout(null);
		setVisible(true);
		setSize(600, 400);
		setTitle("REMOVE STAFF");
		
	}
	public void actionPerformed(ActionEvent e)
	{
try{
			
//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","devmodeon");
			Statement stmt = con.createStatement();
			
			
String s1="'"+tf1.getText()+"'";
String s2=tf2.getText();
String s3="'"+tf3.getText()+"'";
int n=Integer.parseInt(s2);
String q="Delete From library.staff_list WHERE id="+n+";";

stmt.executeUpdate(q);

con.close();
	dispose();
JOptionPane.showMessageDialog(this,"Succefully Removed");
		//f.setSize(400,400);
}
catch(Exception ex)
{
System.out.println(ex);
}

		

	}
		
       
}

