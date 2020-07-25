package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Table2 
{    
             JFrame f;   
             JTable table;
             public Table2()
                          {    
	                    f=new JFrame();    
			       
			    f.setSize(600,600);
                            f.setTitle("My Books");
			    
                           
			   

			    String column[]={"IID","BID","ISSUE_DATE","RETURN_DATE","PERIOD","FINE","BOOK","CATEGORY","AUTHOR"};
			    try
			       {        String  q4="Select * from library.login";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","anandu1998@mysql");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(q4);
                                        boolean t1=rs.next();
                                        
					String str1=rs.getString(2);
					String str2=rs.getString(3);
					String q2="Select * from  library.student_list where name='"+str1+"' and password='"+str2+"'";

					ResultSet rs1=stmt.executeQuery(q2);


					boolean t=rs1.next();
					int uid=rs1.getInt(1);
                                        
			                //String q3="Select * From (books_issued natural join books_available on books_issued.bid=books_available.bid) where books_issued.uid="+uid+"and books_issued.return_date is NULL";
                                        String q3="Select iid,bid,issued_date,return_date,period,fine From library.books_issued where uid="+uid;
					
					

                                        ResultSet rs3=stmt.executeQuery(q3);
                                        int c1=0;
					while(rs3.next())                      //to find number rows in rs2
					{
					c1++;	
					}


					ResultSet rs4=stmt.executeQuery(q3);

					String data[][]=new String[c1][9];
					int i=0,j=0,a=1;
				
				
		                   
                                        while((rs4.next())&&(i<c1))
					{a=1;
		                                for(j=0;j<6;j++)
						{
		                                
						data[i][j]=rs4.getString(a);
		                                 a++;
						}
                                         i++;
                                        }



					int bid;
					String q5;
					ResultSet rs6;
					boolean t3;
					i=0;

					while(i<c1)
					{

						bid=Integer.parseInt(data[i][1]);
						 q5="Select bname,category,author From library.books_available where bid="+bid;

						rs6=stmt.executeQuery(q5);

						j=6;a=1;
					
					
				           
		                                t3=rs6.next();
						
				                        for(j=6;j<9;j++)
							{
				                        
								data[i][j]=rs6.getString(a);
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
