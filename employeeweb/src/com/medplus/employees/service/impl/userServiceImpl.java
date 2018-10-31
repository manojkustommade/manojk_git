package com.medplus.employees.service.impl;

import java.util.List;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.EmployeeDao;
import com.medplus.employees.dao.impl.EmployeeDaoImpl;
import com.medplus.employees.service.UserService;

public class userServiceImpl implements UserService {
    EmployeeDao dao=new EmployeeDaoImpl();
	@Override
	public Employee getEmployee(int empcode) {
		Employee emp=dao.getEmployee(empcode);
		return emp;
	}

	@Override
	public List<Employee> getEmpls() {
		List<Employee> emplist=dao.getEmpls();
		return emplist;
	}

}
