package com.medplus.employees.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.EmployeeDao;
import com.medplus.employees.utils.DBQueries;
import com.medplus.employees.utils.DateParsing;
import com.mysql.jdbc.Driver;

public class EmployeeDaoImpl implements EmployeeDao{

	Connection conn=null;
	PreparedStatement pst;
	ResultSet rs;
	@Override
	public int addEmployee(Employee employee) {
		int rows=0;
		openDBConnection();
		try {
			pst=conn.prepareStatement(DBQueries.addempl);
			pst.setInt(1, employee.getEmpcode());
			pst.setString(2,employee.getEmpname());
			pst.setString(3, employee.getJob());
			pst.setDouble(4, employee.getSalary());
			pst.setDate(5, DateParsing.convertToSqlDate(employee.getDateOfBirth()));
			rows=pst.executeUpdate();
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			close();
		}
		return rows;
	}
	
	
	

	@Override
	public void openDBConnection() {
         String url="jdbc:mysql://localhost:3306/medplus";
         String user="root";
         String pass="root";
         
         try {
        	 Driver driver=new Driver();
             DriverManager.registerDriver(driver);
             conn=DriverManager.getConnection(url,user,pass);
         }
         catch(SQLException e) {
        	 e.printStackTrace();
         }
	}

	@Override
	public void close() {
           try {
        	   conn.close();
           }
           catch(SQLException e) {
        	   e.printStackTrace();
           }
	}




	@Override
	public int updateEmployee(Employee employee) {
		int rows=0;
		openDBConnection();
		try {
			pst=conn.prepareStatement(DBQueries.Updateempl);
		    pst.setString(1, employee.getEmpname());
		    pst.setString(2,employee.getJob());
		    pst.setDouble(3, employee.getSalary());
		    pst.setDate(4, DateParsing.convertToSqlDate(employee.getDateOfBirth()));
		    pst.setInt(5, employee.getEmpcode());

		    rows=pst.executeUpdate();
		}
		catch(SQLException e) {
		    e.printStackTrace();
		}    
		finally {
			close();
		}
		return rows;
		
	}


	@Override
	public int deleteEmployee(int empcode) {
		int deleted=0;
		openDBConnection();
		try {
			pst=conn.prepareStatement(DBQueries.deleteempl);
		    pst.setInt(1, empcode);
		    deleted=pst.executeUpdate();
		}
		catch(SQLException e) {
		    e.printStackTrace();
		}    
		finally {
			close();
		}
		return deleted;
	}




	@Override
	public Employee getEmployee(int empcode) {
		openDBConnection();
		Employee emp=new Employee();
       try {
			pst=conn.prepareStatement(DBQueries.recordempl);
			pst.setInt(1, empcode);
			ResultSet rs=pst.executeQuery();
		   
			if(rs.next()) {
		
                         emp.setEmpcode(rs.getInt(1));
                         emp.setEmpname(rs.getString(2));
                         emp.setJob(rs.getString(3));
                         emp.setSalary(rs.getDouble(4));
                         emp.setDateOfBirth(rs.getDate(5));
					}
			else {
				throw new recordnotfoundException();
			}
			
	   }
       catch (SQLException e) {
			e.printStackTrace();
	   }
       catch(recordnotfoundException e) {
    	   System.out.println(e);
       }
       finally {
    	  close();
       }
	   return emp;
		
		//return null;
		
	}

	@Override
	public List<Employee> getEmpls() {
        openDBConnection();
        List<Employee> list=new ArrayList<Employee>();
       try {
    	pst=conn.prepareStatement(DBQueries.allrecords);
    	rs=pst.executeQuery();
         while(rs.next()) {
        	
        	list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5)));
        }
	}
    catch(SQLException e) {
    	e.printStackTrace();
    }
       finally {
    	   close();
       }
     return list;  
  }
}	
	


