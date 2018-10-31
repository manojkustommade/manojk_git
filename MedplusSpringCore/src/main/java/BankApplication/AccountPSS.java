package BankApplication;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import jdbc.DateParsing;

@Component
public class AccountPSS implements PreparedStatementSetter{
    @Autowired
	Account act;
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1,act.getAcno());
		pst.setString(2, act.getCustomername());
		pst.setDouble(3, act.getBalance());
		pst.setDate(4,DateParsing.convertToSqlDate(act.getDatecreation()));
	}

}
