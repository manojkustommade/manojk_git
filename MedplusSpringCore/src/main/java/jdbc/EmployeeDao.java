package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends JdbcDaoSupport {
	@Autowired
	Employee emp;
	@Autowired
	EmployeePSS pss;
	@Autowired
	EmployeePSSU pssu;

	@Autowired
	public EmployeeDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	public void insert() {
		String sql="insert into Employee values(321,'sai','deveops',12000,'2018-12-11')";
		getJdbcTemplate().execute(sql);
	}
	public int addEmployee() {
		String sql="insert into Employee values(?,?,?,?,?)";
		//Object[] args= {emp.getEmpcode(),emp.getEmpname(),emp.getJob(),emp.getSalary(),DateParsing.convertToSqlDate(emp.getDateOfBirth())};
		int rows=getJdbcTemplate().update(sql,pss);
		return rows;
	}
	public int deleteEmployee(int code) {
		String sql="delete from Employee where empcode=?";
		Object[] arg= {code};
		int rows=getJdbcTemplate().update(sql,arg);
		return rows;
	}
	public int updateEmployee(Employee e) {
		String sql="update Employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
		
		int rows=getJdbcTemplate().update(sql,pssu);
		return rows;
		
	}
	public List<Employee> getEmpls(){
		String sql="select * from Employee";
		List<Employee> emplist=getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emplist;
	}
	public Employee getEmp(int code) {
		String sql="select * from Employee where empcode=?";
		Object[] arg= {code};
		emp=getJdbcTemplate().queryForObject(sql, arg, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
}
