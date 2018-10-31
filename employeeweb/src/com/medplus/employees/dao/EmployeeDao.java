package com.medplus.employees.dao;

import java.util.List;

import com.medplus.employees.beans.Employee;

public interface EmployeeDao {
	int addEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(int empcode);
	Employee getEmployee(int empcode);
	List<Employee> getEmpls();
	void openDBConnection();
	void close();
}
