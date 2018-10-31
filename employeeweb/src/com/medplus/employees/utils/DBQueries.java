package com.medplus.employees.utils;

public class DBQueries {
    
	public static String addempl="insert into Employee values(?,?,?,?,?)";
	public static String Updateempl="update Employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
	public static String deleteempl="delete from Employee where empcode=?";
	public static String recordempl="select empcode,empname,job,salary,dateofbirth from Employee where empcode=?"; 
	public static String allrecords="select empcode,empname,job,salary,dateofbirth from Employee";
	
}
