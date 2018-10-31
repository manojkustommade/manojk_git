package BankApplication;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AccountoperationDao {
	boolean createAccount();
	//int createAddress();
	void deposite(int acno,double amount);
	void withdraw(int acno,double amount);
	List<Transaction> viewstatement(int acno);
	Integer getMaxAcno();
	int CheckAccount(int acno);
}
