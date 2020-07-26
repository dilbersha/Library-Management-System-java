package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
    public class Adminp1t2{    
        JFrame f;  int c=0;  JTable table;
       public Adminp1t2(){    
        f=new JFrame();    
        
        f.setSize(600,600);
        f.setTitle("Books Available");
			String q2="Select * from library.books_issued";
                        String column[]={"iid","uid","bid","issue_date","return_date","period","fine"};
			try
                        {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","anandu1998@mysql");
				Statement stmt=con.createStatement();

				


				ResultSet rs2=stmt.executeQuery(q2);

				while(rs2.next())
				{
				c++;
				}

				ResultSet rs1=stmt.executeQuery(q2);

				  String[][] data=new String[c][7];
		                int i=0,j=0,a=1;
				
				
		                   
                                        while((rs1.next())&&(i<c))
					{a=1;
		                                for(j=0;j<7;j++)
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
				f.add(sp);
			}
			catch(Exception ex)
			{
			System.out.println(ex);
			}
        f.setVisible(true);    
    }     
   
    }  
