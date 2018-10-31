package BankApplication;

import java.util.*;

public class AccountApplication {

	public static void main(String[] args){
	         
		     AccountOperation ap=new AccountOperation();
		     Scanner s=new Scanner(System.in);
	         
	         while(true) { 
	        	
	        	System.out.println("Enter c--> createaccount\n d-->deposite\n w-->withdraw\n b-->checkbalance\n l-->display\n x-->exit\n ");
	        	String ch=s.next();
	        	int acno;
	        	int dep,am;
	        	switch(ch) {
	        	
	        	case "c":
	        		System.out.println("Creating an Account");
	        		System.out.println("Enter name");
	        		String name=s.next();
	        		System.out.println("Enter amount");
	        		int amt=s.nextInt();
	        		ap.creataccount(name,amt);
	        	
	        		break;
	        	case "d":
	        		System.out.println("Deposite Amount");
	        		System.out.println("Enter account number");
	        		acno=s.nextInt();
	        		System.out.println("Enter amount");
	        		dep=s.nextInt();
	        		ap.deposite(acno,dep);
	        		
	        		break;
	        	case "w":
	        		System.out.println("Withdraw amount");
	        		System.out.println("Enter account number");
	        	    acno=s.nextInt();
	        		System.out.println("Enter amount");
	        	    am=s.nextInt();
	        		ap.withdraw(acno,am);
	        		
	        		break;
	        	case "b":
	        		System.out.println("Check your Balance");
	        		System.out.println("Enter account number");
	        		acno=s.nextInt();
	        		ap.checkbalance(acno);
	        		
	        		break;
	        	case "l":
	        		      ap.displayAccount();
	                    	break;
	        	case "x":
                    System.exit(0);
                    
	        	}
	        	
	        }
	}
}
