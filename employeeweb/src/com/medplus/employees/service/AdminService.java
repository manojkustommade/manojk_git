package com.medplus.employees.service;

import java.util.List;

import com.medplus.employees.beans.Employee;

public interface AdminService {
	int addEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(int empcode);
	Employee getEmployee(int empcode);
	List<Employee> getEmpls();
}
