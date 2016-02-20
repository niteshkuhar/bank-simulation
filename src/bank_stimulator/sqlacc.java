package bank_stimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class sqlacc {

 String Query(String acc) {

	//Connection String
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
	                       "databaseName=java;integratedSecurity=true";

	 String SQL;
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	        //Connecting with database if connection fails throws Error
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         stmt = con.createStatement();
	         SQL="SELECT * FROM ["+acc+"]";
	         rs=stmt.executeQuery(SQL);
	         String col = null;
	         String s="";
	         
	         if(rs.next())
	         {
	        	 s=rs.getString(6);
	         while(rs.next())
	         {
	        	 
	        	 s=rs.getString(6);
	        	 
	      }
	        // return s;
	         //int i=(Integer.parseInt(s)+1);
	        //	s=Integer.toString(i);
	         //s=""+i;
   	
	         return s;
	        // return col;*/
	      }
	
	         
	         
	      }
	      catch (Exception e) {
	         System.out.println("Error oopsss:"+e);
	       
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
	     
		return "";
}

 
 
 
 void insert(String acc,String date, String particular,String deposit,String withdraw, String balance){
		Connection String;
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		                       "databaseName=java;integratedSecurity=true";

		 String SQL;
		      Connection con = null;
		      Statement stmt = null;
		      ResultSet rs = null;

		      try {
		        //Connecting with database if connection fails throws Error
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         con = DriverManager.getConnection(connectionUrl);
		         stmt = con.createStatement();
		       // System.out.println(acc);
		         //String col = null;
		         
		        
		         SQL="INSERT INTO ["+acc+"] ([Date],[Particulars],[Deposits],[withdraw],[Balance])"+"VALUES('"+date+"','"+particular+"','"+deposit+"','"+withdraw+"','"+balance+"')";
		         rs=stmt.executeQuery(SQL);
		      
		     
		      }
		         catch (Exception e) {
		         System.out.println("Error oopsss:"+e);
		       
		      }
		      finally {
		         if (rs != null) try { rs.close(); } catch(Exception e) {}
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		         if (con != null) try { con.close(); } catch(Exception e) {}
		      }
		     
 }
	

void ministatement(DefaultTableModel model,String acc) {
			String Slno,Date,Particular,Withdraw,Deposit,Balance;
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
				                       "databaseName=java;integratedSecurity=true";
					String SQL;
				      Connection con = null;
				      Statement stmt = null;
				      ResultSet rs = null;
				      	try {
				        //Connecting with database if connection fails throws Error
				         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				         con = DriverManager.getConnection(connectionUrl);
				         stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				         SQL="SELECT * FROM ["+acc+"]";
				         rs=stmt.executeQuery(SQL);
				         String col = null;
				        int i=0;
				         if(rs.last())
				         {
				        	 do{
				        	 i++;
				        	 Slno=rs.getString(1);
				        	 Date=rs.getString(2);
				        	 Particular=rs.getString(3);
				        	 Withdraw=rs.getString(4);
				        	 Deposit=rs.getString(5);
				        	 Balance=rs.getString(6);
				        	 model.addRow(new Object[]{Slno,Date,Particular,Withdraw,Deposit,Balance});
				        	 if(i>9)
				        		 	break;
				        	
				         }while(rs.previous());
				         }
				         else
				        	 model.addRow(new Object[]{"There","Is","NO","Transaction","Done","Yet"});
			        	 
				      	}
				         /* String s="";
				         int i=0;
				         while(rs.next())
				          	 i++;
				         SQL="SELECT * FROM ["+acc+"]";
				         rs=stmt.executeQuery(SQL);
				         while(i>10)
				         {
				        	 rs.next();
				        	 i--;
				         }
				         while(rs.next())
				         {	 
				        	 Slno=rs.getString(1);
				        	 Date=rs.getString(2);
				        	 Particular=rs.getString(3);
				        	 Withdraw=rs.getString(4);
				        	 Deposit=rs.getString(5);
				        	 Balance=rs.getString(6);
				        	 model.addRow(new Object[]{Slno,Date,Particular,Withdraw,Deposit,Balance});
				         }
				      }*/
				      catch (Exception e) {
				         System.out.println("Error oopsss:"+e);
				       
				      }		      finally {
		         if (rs != null) try { rs.close(); } catch(Exception e) {}
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		         if (con != null) try { con.close(); } catch(Exception e) {}
		      }
		     
	}



void deleteAcctable(String acc) {
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
				                       "databaseName=java;integratedSecurity=true";
					String SQL;
				      Connection con = null;
				      Statement stmt = null;
				      ResultSet rs = null;
				      	try {
				        //Connecting with database if connection fails throws Error
				         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				         con = DriverManager.getConnection(connectionUrl);
				         stmt = con.createStatement();
				         SQL="DROP TABLE ["+acc+"]";
				         rs=stmt.executeQuery(SQL);
				         String col = null;
				      	}
				         catch (Exception e) {
				         System.out.println("Error oopsss:"+e);
				       
				      }		      finally {
		         if (rs != null) try { rs.close(); } catch(Exception e) {}
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		         if (con != null) try { con.close(); } catch(Exception e) {}
		      }
		     
	}




	} 
 
 


