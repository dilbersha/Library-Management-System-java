package p1;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Adminp2b2 extends JFrame implements ActionListener    // how to use Auto increment //check
{

JTextField tf1,tf2,tf3,tf4;
	Adminp2b2()
	{
		
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
                JLabel l3=new JLabel();
                JLabel l4=new JLabel();
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();

		l1.setText("Name");
		l1.setBounds(50,50,150,20);
		tf1.setBounds(210,50,150,20);
		l2.setText("Date_join");
		l3.setText("Designation");
		l4.setText("Password");
		l2.setBounds(50,100,150,20);
		tf2.setBounds(210,100,150,20);
		l3.setBounds(50,140,150,20);
		tf3.setBounds(210,140,150,20);
		l4.setBounds(50,200,150,20);
		tf4.setBounds(210,200,150,20);





		JButton b1=new JButton("Add");
		b1.setBounds(225,300,150,20);
		b1.addActionListener(this);
		add(l1);add(tf1);add(l2);add(tf2);add(l3);add(tf3);add(l4);add(tf4);add(b1);
		setLayout(null);
		setVisible(true);
		setSize(600, 400);
		setTitle("ADD STAFF");
		
	}
	public void actionPerformed(ActionEvent e)
	{
try{
			
Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Anandu1998@mysql");
			Statement stmt = con.createStatement();
			
			
String s1="'"+tf1.getText()+"'";
String s2="'"+tf2.getText()+"'";
String s3="'"+tf3.getText()+"'";
String s4="'"+tf4.getText()+"'";
String q="Insert into library.staff_list(name,date_join,designation,password) values("+s1+","+s2+","+s3+","+s4+");";
//String q="Insert into library.staff_list values(4,'Anandu','2020-05-01','Assistant','anandu');";
stmt.executeUpdate(q);

con.close();

JOptionPane.showMessageDialog(this,"Succefully Added");
		//f.setSize(400,400);
}
catch(Exception ex)
{
System.out.println(ex);
}

		

	}
		
       
}

