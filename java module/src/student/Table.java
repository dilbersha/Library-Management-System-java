package student;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
    public class Table {    
        JFrame f;  int c=10;  JTable table;
       public Table(){    
        f=new JFrame();    
        String[][] data=new String[c][3];
        f.setSize(600,600);
        f.setTitle("Books Available");
			String q2="Select bid,bname,category from books_available where available='T'";
                        String column[]={"bid","bname","category"};
			try
                        {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","devmodeon");
				Statement stmt=con.createStatement();

				ResultSet rs1=stmt.executeQuery(q2);
				
		                int i=0,j=0,a=1;
				
				
		                   
                                        while((rs1.next())&&(i<c))
					{a=1;
		                                for(j=0;j<3;j++)
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
