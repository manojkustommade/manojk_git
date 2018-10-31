package BankApplication;

public class Account {
	
	private int accountNumber;
	private String customerName;
	private int balance=0;
	
	public Account(int accountNumber, String customerName, int balance) {
	
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
