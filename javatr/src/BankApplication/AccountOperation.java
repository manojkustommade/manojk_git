package BankApplication;
import java.util.*;
public class AccountOperation {
	
    static int i=1000;
    ArrayList<Account> items=new ArrayList<Account>();

	public AccountOperation() {
           items.add(new Account(i,"manoj",500));
           items.add(new Account(++i,"YManoj",500));
           items.add(new Account(++i,"vaibhav",500));
	}
	public void creataccount(String name,int amount) {
		
		if(items.add(new Account(++i,name,amount))) {
			System.out.println("Your account successfully created");
			System.out.println("Your account number is "+i);
		}
		
	}
	public void deposite(int AccountNumber,int amount) {
		int dep=0;
		boolean flag=false;
		for(Account acn: items) {
			
			if(acn.getAccountNumber()==AccountNumber) {
				dep=acn.getBalance();
				dep+=amount;
				acn.setBalance(dep);
				flag=true;
			}
			
		}
		if(flag) {
	
		   System.out.println("Your amount was successfully deposited");
		   System.out.println("Your balance was "+dep);
		}   
		else {
			try {
				throw new AccountNotFoundException();
			}
			catch(AccountNotFoundException e) {
				e.printStackTrace();
			}
 		}	
	}
	public void withdraw(int AccountNumber,int amount) {
		boolean flag=false;
	  try {
		for(Account acn: items) {
			  if(acn.getAccountNumber()==AccountNumber) {
				  flag=true;
				  int draw=acn.getBalance();
				   if(amount>draw) {
					  
					    throw new InsufficientException();
					 
					  
			       }
				   else {
				        draw-=amount;
				        acn.setBalance(draw);
				        System.out.println("Your are "+amount+" withdrawn");
				        System.out.println("Your amount was "+draw);
				   } 
			 }
			  
		  }
		if(!flag)
		throw new AccountNotFoundException();
	  }
	   catch(AccountNotFoundException e) {
				e.printStackTrace();
			}
	  catch(InsufficientException e){
		   e.printStackTrace();
	   }
	 }
		
		/*if(flag==false) {
			try {
				throw new AccountNotFoundException();
			}
			catch(AccountNotFoundException e){
				e.printStackTrace();
			}
		}*/
		
		
	
	public void checkbalance(int accountnumber) {
		boolean flag=false;
		for(Account acn: items) {
			if(acn.getAccountNumber()==accountnumber) {
				System.out.println("Your Account Balance is "+acn.getBalance());
				flag=true;
			}
		}
		if(flag==false) {
			try {
				throw new AccountNotFoundException();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void displayAccount() {
		System.out.println("All Account Details");
		System.out.println("AccountNumber      CustomerName      Balance");
		for(Account acn:items) {
		
			System.out.println(acn.getAccountNumber()+"      "+acn.getCustomerName()+"      "+acn.getBalance());
		}
		
	}
}
