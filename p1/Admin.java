package p1;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Admin extends JFrame implements ActionListener
{

	JButton b1,b2,b3;JTable table;    int c=5; 
	Admin()
	{
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		setTitle("Admin");
		setSize(600,400);
		b1.setBounds(210,60,150,20);
		b2.setBounds(210,100,150,20);
		b3.setBounds(210,140,150,20);
		setLayout(null);
		setVisible(true);
                add(b1);add(b2);add(b3);
		b1.setText("General");
		b2.setText("staff");
		b3.setText("Students");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
                  new Adminp1();
		}
		if(e.getSource()==b2)
		{
                    new Adminp2();
		}
		if(e.getSource()==b3)
		{
                 new Adminstudenttable();
                }
	}

	public static void main(String args[])
	{
	new Admin();
	}
}



 /*String[][] data=new String[c][5];
        
			String q2="Select name,class,branch,sex,PHONE from library.student_list";
                        String column[]={"NAME","CLASS","BRANCH","SEX","PHONE"};
			try
                        {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","anandu1998@mysql");
				Statement stmt=con.createStatement();

				ResultSet rs1=stmt.executeQuery(q2);
				
		                int i=0,j=0,a=1;
				
				
		                   
                                        while((rs1.next())&&(i<c))
					{a=1;
		                                for(j=0;j<5;j++)
						{
		                                
						data[i][j]=rs1.getString(a);
		                                 a++;
						}
                                         i++;
                                        }
			             
			         
				con.close();
		                table=new JTable(data,column);
				table.setBounds(30,40,200,300);          
				JScrollPane sp=new JScrollPane(table);    
				add(sp);
			}
			catch(Exception ex)
			{
			System.out.println(ex);
			}*/
       
