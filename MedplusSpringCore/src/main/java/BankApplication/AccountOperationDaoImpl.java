package BankApplication;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import jdbc.Employee;

@Repository
public class AccountOperationDaoImpl  extends JdbcDaoSupport implements AccountoperationDao{
    @Autowired
	Account acn;
	@Autowired
	AccountPSS pss;
	@Autowired
	AddressPSS apss;
	@Autowired
	TransactionPSS tpss;
	@Autowired
	Transaction tns;
	@Autowired
	Address adr;
	@Autowired
	public AccountOperationDaoImpl(DriverManagerDataSource dataSource) {
	
		setDataSource(dataSource);
	}
	
	@Override
	public boolean createAccount() {
          		
        		//Integer maxnumber=getMaxAcno();
        		
        		
        		String sqlaccount="insert into Account values(?,?,?,?)";
        		int rows=getJdbcTemplate().update(sqlaccount,pss);
        		

        		String sqladdress="insert into Address values(?,?,?)";
        		//adr.setAcno(maxnumber);
        		int rows1=getJdbcTemplate().update(sqladdress,apss);
        		
        	/*	String sqltrans="insert into Transaction values(?,?,?,?,?,?)";
        		tns.setAcno(maxnumber);
        		int rows2=getJdbcTemplate().update(sqltrans,tpss);*/
        		if(rows>0 && rows1>0) {
        			return true;
        		}
     return false;
        
	}

	@Override
	public void deposite(int acno,double amount) {
		
		String sql="update Account set balance=? where acno=?";
		String sql1="select balance from Account where acno=?";
		Object[] arg= {acno};
		acn=getJdbcTemplate().queryForObject(sql1, arg, new BeanPropertyRowMapper<Account>(Account.class));
		double newamount=acn.getBalance();
		newamount+=amount;
		Object[] args= {newamount,acno};
		int rows=getJdbcTemplate().update(sql,args);
		
		if(rows>0) {
			String sqlt="insert into Transaction values(?,?,?,?,?,?)";
			tns.setBalance(newamount);
			int row=getJdbcTemplate().update(sqlt,tpss);
			if(row>0)
				//System.out.println("Trans successful");
			System.out.println("Amount deposited sucessfully");
			System.out.println("Your Amount is "+newamount);
		}
		else {
			System.out.println("Your Amount Not Deposited");
		}
	}

	@Override
	public void withdraw(int acno,double amount) {
		
		String sql1="select balance from Account where acno=?";
		Object[] arg= {acno};
		acn=getJdbcTemplate().queryForObject(sql1, arg, new BeanPropertyRowMapper<Account>(Account.class));
		
		//int rows=0;
		double newamount=acn.getBalance();
		//System.out.println(newamount);

		if(amount < newamount) {
			//System.out.println("withdraw");

			int rows=0;
			newamount-=amount;
			String sql="update Account set balance=? where acno=?";
			Object[] args= {newamount,acno};
			rows=getJdbcTemplate().update(sql,args);
			if(rows>0) {
				String sqlt="insert into Transaction values(?,?,?,?,?,?)";
				tns.setBalance(newamount);
				getJdbcTemplate().update(sqlt,tpss);
				System.out.println(amount+" /-"+"Withdrawn from your account");
				System.out.println("Your current Amount is "+newamount);
				
			}
			else if(rows<0) {
				System.out.println("Not Deposited");
			}
		else if(amount>newamount){
			System.out.println("Insufficient amount");
		}
			
	 }	
		
		
	}
    
	@Override
	public List<Transaction> viewstatement(int acno) {
         	String sql="select * from Transaction where acno=?";
         	Object[] args= {acno};
         	List<Transaction> tlist=getJdbcTemplate().query(sql, args,new BeanPropertyRowMapper<Transaction>(Transaction.class));
         	return tlist;
	} 
	@Override
	public Integer getMaxAcno() {
		String sql="select max(acno) from Account";
		Integer maxacno=getJdbcTemplate().queryForObject(sql, null, Integer.class);
		if(maxacno==null) {
			return 1000;
		}
		else {
			return maxacno;
		}
	}
	
	public int CheckAccount(int acno) {
		String sql="select count(*) from Account where acno=?";
	    int rows=getJdbcTemplate().queryForObject(sql,new Object[] {acno},Integer.class);
		return rows;
	}
}