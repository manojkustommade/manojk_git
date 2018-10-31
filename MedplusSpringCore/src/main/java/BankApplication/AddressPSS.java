package BankApplication;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class AddressPSS implements PreparedStatementSetter{
	@Autowired
	Address adr;
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1,adr.getAcno() );
		pst.setString(2, adr.getStreet());
		pst.setString(3, adr.getCity());
		
	}

}
