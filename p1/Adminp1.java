package p1;
import java.awt.event.*;
import javax.swing.*;
class Adminp1 extends JFrame implements ActionListener
{

	JButton b1,b2,b3;
	Adminp1()
	{
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		setTitle("General");
		setSize(600,400);
		b1.setBounds(210,60,150,40);
		b2.setBounds(210,120,150,40);
		
		setLayout(null);
		setVisible(true);
                add(b1);add(b2);
		b1.setText("View Books");
		b2.setText("Issued Books");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
                new Adminp1t1();
		}
		if(e.getSource()==b2)
		{
                new Adminp1t2();
		}
		
	}

	
}
