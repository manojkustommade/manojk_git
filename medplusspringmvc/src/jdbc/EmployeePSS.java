package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class EmployeePSS implements PreparedStatementSetter{
    @Autowired
	Employee emp;
    public EmployeePSS() {
    	super();
    }
    public EmployeePSS(Employee emp) {
    	this.emp=emp;
    }
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1, emp.getEmpcode());
		pst.setString(2, emp.getEmpname());
		pst.setString(3, emp.getJob());
		pst.setDouble(4, emp.getSalary());
		pst.setDate(5, DateParsing.convertDate(emp.getDateOfBirth()));
	}
}
