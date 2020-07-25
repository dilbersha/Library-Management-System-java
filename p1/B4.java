package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;
public class B4 implements ActionListener
{


JFrame f=new JFrame();
	JTextField tf1;
        JPasswordField value;
		public B4()
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
 

			
		}
                      
	public void actionPerformed(ActionEvent e)
	{
		try{
                    String s1=tf1.getText();
                    String s2=value.getText();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","anandu1998@mysql");
			Statement stmt=con.createStatement();
String q0="UPDATE `library`.`login` SET `name` = '"+s1+"', `password` = '"+s2+"' WHERE (`key` = '1');";

			int x=stmt.executeUpdate(q0);

			String q1="Select * from student_list where password='"+s2+"'";

			ResultSet rs = stmt.executeQuery(q1);
			if (rs.next())
			{
				

				if((rs.getString(5).equals(value.getText()))&&(rs.getString(2).equals(tf1.getText())))
				{
				new B5();
				
				}



			else
			{
			JOptionPane.showMessageDialog(f,"Invalid");
			}
			}
			con.close();
		}
		catch(Exception ex)
		{
		System.out.println(ex);
		}

			//System.exit(0);


	}
		public static void main(String[] args)
		{

		new B4();
		}
}


