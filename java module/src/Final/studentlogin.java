package Final;
import librarian.invalid;
import student.B5;

import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;
public class studentlogin implements ActionListener
{


JFrame f=new JFrame();
	JTextField tf1;
        JPasswordField value;
		public studentlogin()
		{
			
			JLabel l1=new JLabel();
			JLabel l2=new JLabel();
			
			tf1=new JTextField();
		        value = new JPasswordField();
			l1.setText("Username");
			l1.setBounds(50,50,150,20);
			tf1.setBounds(210,50,150,20);
			l2.setText("Password");
			l2.setBounds(50,100,150,20);
			value.setBounds(210,100,150,20);
			JButton B4=new JButton("Login");
			B4.setBounds(250,180,150,20);
			B4.addActionListener(this);
			f.add(l1);f.add(tf1);f.add(l2);f.add(value);f.add(B4);
			f.setLayout(null);
			f.setVisible(true);
			f.setTitle("Login");
			f.setSize(600,600);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 

			
		}
    public String toString(char[] a) 
    { 
        String string = String.valueOf(a); 
  
        return string; 
    } 
	public void actionPerformed(ActionEvent e)
	{
		try{
                    String s1=tf1.getText();
                    String s2=toString(value.getPassword());
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","devmodeon");
			Statement stmt=con.createStatement();
			String q2="Delete from `login`;";
			stmt.executeUpdate(q2);
String q0="INSERT INTO login(name,password) VALUES ('"+s1+"','"+s2+"');";


			int x=stmt.executeUpdate(q0);

			String q1="Select * from student_list where password='"+s2+"'";

			ResultSet rs = stmt.executeQuery(q1);
			if (rs.next())
			{
				

				if((rs.getString(5).equals(toString(value.getPassword())))&&(rs.getString(2).equals(tf1.getText())))
				{
				new B5();
				
				}



				else
				{
					new invalid();
				}

			}
			else
			{
				new invalid();
			}
			con.close();

		}
		catch(Exception ex)
		{
		System.out.println(ex);
		}

			//System.exit(0);

f.dispose();
	}
		public static void main(String[] args)
		{

		new studentlogin();
		}
}


