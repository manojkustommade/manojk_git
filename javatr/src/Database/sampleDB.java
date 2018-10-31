package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class sampleDB {
     public static void main(String[] args) throws SQLException {
    	 Scanner s=new Scanner(System.in);
    	 Driver driver=new Driver();
    	 String url="jdbc:mysql://localhost:3306/medplus";
    	 String user="root";
    	 String pass="root";
    	 DriverManager.registerDriver(driver);
    	 Connection conn=DriverManager.getConnection(url,user,pass);
    	 
    	 String ch=new String();
    	 while(!ch.equals("x")) {
    		 
    		 System.out.println("i--> for insertion");
    		 System.out.println("u--> for update");
    		 System.out.println("d--> for delete");
    		 System.out.println("s--> for select");    		     		 
    		 System.out.println("x--> for exit");
    		 ch=s.next();
    	   switch(ch) {
    	 
	    	  case "i":
		    	 String sql="insert into employee values(?,?,?)";
		    	 PreparedStatement pst=conn.prepareStatement(sql);
		    	 System.out.println("Enter the code");
		    	 pst.setInt(1, s.nextInt());
		    	 System.out.println("Enter the name");
		    	 pst.setString(2, s.next());
		    	 System.out.println("Enter the salary");
		    	 pst.setDouble(3, s.nextDouble());
		    	 
		    	 int rows=pst.executeUpdate();
		    	 if(rows>0) {
		    		 System.out.println("inserted");
		    	 }
		    	 else {
		    		 System.out.println("Not inserted");
		    	 }
		    	 break;
	    	  case "u": 	 
	    		  System.out.println("-------------------");
	    		  System.out.println("Update the records");
		    	 String sql1="update employee set name=? where code=?";
		    	 PreparedStatement pstu=conn.prepareStatement(sql1);
		    	 System.out.println("Enter the name");
		    	 pstu.setString(1, s.next());
		    	 System.out.println("Enter the code");
		    	 pstu.setInt(2, s.nextInt());
		    	 
		    	 int update=pstu.executeUpdate();
		    	 if(update>0) {
		    		 System.out.println("Data Updated");
		    	 }
		    	 else {
		    		 System.out.println("Not Updated");
		    	 }
		     	 break;
	    	  case "d":	 
	    		  System.out.println("------------------");
	    		  System.out.println("Delete the record");
		    	 String sql3="delete from employee where code=?";
		    	 PreparedStatement pstd=conn.prepareStatement(sql3);
		    	 System.out.println("-----------------");
		    	 System.out.println("Deletion");
		    	 System.out.println("Enter the code");
		    	 pstd.setInt(1, s.nextInt());
		    	 int delete=pstd.executeUpdate();
		         if(delete>0) {
		        	 System.out.println("Record deleted successfully");
		         }
		         else {
		        	 System.out.println("deletion unsuccessful");
		         }
		         break;
	    	  case "s":
	    		  System.out.println("For Display entire table");
	    		  System.out.println("--------------------------");
	    		  String sqls="select * from employee";
			      PreparedStatement psts=conn.prepareStatement(sqls);
			      ResultSet select=psts.executeQuery();
			      if(select.next()) {
			    	  do {
			    		  System.out.println(select.getInt(1)+" "+select.getString(2)+" "+select.getDouble(3));
			    	  }while(select.next());
			      }
			      else {
			    	  System.out.println("Records Not Found");
			      }
			      break;
	    	 default:
	    		  System.out.println("you enetered wrong option.......");
	    
	     
    	   }
    	 }  
	    	 
     }
}
