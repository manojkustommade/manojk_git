package BankApplication;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParsing {
	public static Date convertToSqlDate(java.util.Date date) {
		Date sqldate=new Date(date.getTime());
		return sqldate;
	}
	public  static java.util.Date convertToUtilDate(String date){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dt=null;
		try {
			dt=sdf.parse(date);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
}
