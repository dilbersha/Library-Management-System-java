package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
    public class Adminp2t1 {    
        JFrame f;  int c=0;  JTable table;
       public Adminp2t1(){    
        f=new JFrame();    
        
        f.setSize(600,600);
        f.setTitle("Staff Details");
			String q2="Select id,name,date_join,designation from library.staff_list";
                        String column[]={"id","name","date_join","designation"};
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
                                String[][] data=new String[c][4];
		                int i=0,j=0,a=1;
				
				
		                   
                                        while((rs1.next())&&(i<c))
					{a=1;
		                                for(j=0;j<4;j++)
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
