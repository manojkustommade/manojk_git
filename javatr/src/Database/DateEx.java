package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class DateEx {
	public static void main(String[] args) throws SQLException, ParseException {
	   	 Scanner s=new Scanner(System.in);
	   	 Driver driver=new Driver();
	   	 String url="jdbc:mysql://localhost:3306/medplus";
	   	 String user="root";
	   	 String pass="root";
	   	 DriverManager.registerDriver(driver);
	   	 Connection conn=DriverManager.getConnection(url,user,pass);
	   	 System.out.println("connected");
	   	 String doj="03-07-2018";
	   	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	   	 Date dt=sdf.parse(doj);
	   	 System.out.println(dt);
	   	 
	   	 String sql="insert into employee values(?,?,?,?)";
	   	 PreparedStatement pst=conn.prepareStatement(sql);
	   	 pst.setInt(1,300);
	   	 pst.setString(2, "pavan");
	   	 pst.setDouble(3, 3000);
	   	 java.sql.Date sqldate=new java.sql.Date(dt.getTime());
	   	 pst.setDate(4, sqldate);
	   	 pst.executeUpdate();
	   	 System.out.println("Date added");
	}	 
}
