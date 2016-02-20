package bank_stimulator;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlquery {

 String Query(String acc, String pass) {

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
	         SQL="SELECT * FROM login";
	         rs=stmt.executeQuery(SQL);
	         String col = null;
	         
	         while(rs.next())
	         {
	        	 //String s=rs.getString(2);
	        	 
	        	if(rs.getString(1).equalsIgnoreCase(acc)&&rs.getString(2).equals(pass))
	        	{			//Unable to enter though pass and getstring(2) are equal
	        		String r=rs.getString(3);
        			return r;
        		} 
	        	
	      }
	        // return col;
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

 String genarateAcc() {

		//Connection String
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		                       "databaseName=java;integratedSecurity=true";
		String s="";
		 String SQL;
		      Connection con = null;
		      Statement stmt = null;
		      ResultSet rs = null;

		      try {
		        //Connecting with database if connection fails throws Error
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         con = DriverManager.getConnection(connectionUrl);
		         stmt = con.createStatement();
	         
		         
		         
		         SQL="SELECT * FROM login";
		         rs=stmt.executeQuery(SQL);
		         String col = null;
		         if(rs.next())
		         {
		        	 s=rs.getString(1);
		         while(rs.next())
		         {
		        	 
		        	 s=rs.getString(1);
		        	 
		      }
		        // return s;
		         int i=(Integer.parseInt(s)+1);
		        	s=Integer.toString(i);
		         //s=""+i;
       	
		         return s;
		        // return col;*/
		      }
		         else
		        	 	return "1000";
		      }
		      catch (Exception e) {
		         System.out.println("Error oopsss:"+e);
		       
		      }
		      finally {
		         if (rs != null) try { rs.close(); } catch(Exception e) {}
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		         if (con != null) try { con.close(); } catch(Exception e) {}
		      }
		     
	return "0000";
	}

 
 
 void  createtable(String acc) {

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
	         
/* CONSTRAINT [PK_lol] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]";"
	*/	
		 		         
		         
SQL="CREATE TABLE ["+acc+"] ("+
	"Slno bigint IDENTITY(1,1) PRIMARY KEY NOT NULL,"+
	"[Date] [nvarchar](50) NULL,"+
	"[Particulars] [nvarchar](50) NULL,"+
	"[Deposits] [nvarchar](50) NULL,"+
	"[withdraw] [nvarchar](50) NULL,"+
	"[Balance] [nvarchar](50) NULL)";

rs=stmt.executeQuery(SQL);       	
	       	
	        
		        // return col;*/
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


 
 
 
 
 
 
 
 
 
 

 boolean changepassword(String acc, String pass) {

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
			       //  SQL="SELECT * FROM login";
			        // rs=stmt.executeQuery(SQL);
			         
			         // System.out.println(acc);
			         //String col = null;
			  		         
		        // while(rs.next())
		         //{
		        	 //String s=rs.getString(2);
		        	 
		        		//String r="Success";
		        		SQL="UPDATE login SET password=('"+pass+"')"+"WHERE acc=('"+acc+"')";//"+"VALUE('"+pass+"')";
		                //SQL="UPDATE login set [password]"+"VALUE(+pass+)";
				         rs=stmt.executeQuery(SQL);
				 //('"+pass+"')"
		        	
	        			
	        		 
		        	//return true;
		        	
		      //}
		         
		         
		         
		        // return col;
		      }
		      
		      catch (Exception e) {
		         System.out.println("Error oopsss:"+e);
		       
		      }
		      finally {
		         if (rs != null) try { rs.close(); } catch(Exception e) {}
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		         if (con != null) try { con.close(); } catch(Exception e) {}
		      }
		     
			return true;
	}



 void deleteAccount(String acc) {

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
			         
		        		SQL="DELETE FROM login WHERE acc='"+acc+"' ";
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
 
 
 
 
 String forget(String acc, String name,String que,String ans) {

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
		         SQL="SELECT * FROM login";
		         rs=stmt.executeQuery(SQL);
		         String col = null;
		         
		         while(rs.next())
		         {
		        	 //String s=rs.getString(2);
		        	 
		        	if(rs.getString(1).equalsIgnoreCase(acc)&&rs.getString(3).equalsIgnoreCase(name)&&rs.getString(6).equalsIgnoreCase(que)&&rs.getString(7).equals(ans))
		        	{			//Unable to enter though pass and getstring(2) are equal
		        		//String r="Success";
		        		String s=rs.getString(2);
	        			return s;
	        		} 
		        	
		      }
		        // return col;
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

 
 
 
 
 
 
 
 
 
 void insert(String acc,String pass, String name,String gen,String ag, String que, String ans,String mob) {
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
		        
		        
		         SQL="INSERT INTO login ([acc],[password],[name],[gender],[age],[question],[answer],[mobileno])"+"VALUES('"+acc+"','"+pass+"','"+name+"','"+gen+"','"+ag+"','"+que+"','"+ans+"','"+mob+"')";
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
}

