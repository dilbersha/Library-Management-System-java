package student;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class B5 extends JFrame implements ActionListener
{


JButton b1=new JButton("View Books");
JButton b2=new JButton("My Books");
	public B5()
	{
		
		
		
		
		
		
				
		b1.setBounds(50,100,150,20);
				
		
				
		
		setSize(600,400);
                b2.setBounds(250,100,150,20);              		                             
                b1.addActionListener(this);
                b2.addActionListener(this);
		add(b1);add(b2);
                
		setLayout(null);
		setVisible(true);
		setTitle("User Functions");
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==b1)
		{
		
		new Table();
                }
                if (e.getSource()==b2)
		{
		
		new Table2();
                }
	}
	
	
}





