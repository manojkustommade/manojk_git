package BankApplication;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class TransactionPSS implements PreparedStatementSetter {
	@Autowired
	Transaction tns;
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setInt(1, tns.getAcno());
		ps.setDate(2, DateParsing.convertToSqlDate(tns.getTransdate()));
		ps.setString(3,tns.getTranstype());
		ps.setString(4, tns.getDesciption());
		ps.setDouble(5, tns.getAmount());
		ps.setDouble(6, tns.getBalance());
	}
       
}
