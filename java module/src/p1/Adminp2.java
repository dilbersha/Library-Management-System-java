package p1;
import java.awt.event.*;
import javax.swing.*;
class Adminp2 extends JFrame implements ActionListener
{

	JButton b1,b2,b3;
	Adminp2()
	{
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		setTitle("Staff Details");
		setSize(600,400);
		b1.setBounds(210,60,150,20);
		b2.setBounds(210,100,150,20);
		b3.setBounds(210,140,150,20);
		setLayout(null);
		setVisible(true);
                add(b1);add(b2);add(b3);
		b1.setText("Details");
		b2.setText("Add Staff");
		b3.setText("Delete Staff");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
                 new Adminp2t1();
		}
		if(e.getSource()==b2)
		{
                 new Adminp2b2();
		}
		if(e.getSource()==b3)
		{
                 new Adminp2b3();
		}
	}

	
}
