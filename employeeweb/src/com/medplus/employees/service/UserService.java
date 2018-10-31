package com.medplus.employees.service;

import java.util.List;

import com.medplus.employees.beans.Employee;

public interface UserService {
	Employee getEmployee(int empcode);
	List<Employee> getEmpls();
}
