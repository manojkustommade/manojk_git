package BankApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdbc.DateParsing;

public class BankApplcreate {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
		AccountOperationDaoImpl actDao=ctx.getBean("accountOperationDaoImpl",AccountOperationDaoImpl.class);
		Account act=ctx.getBean("account",Account.class);
		Address adr=ctx.getBean("address",Address.class);
		   // int acno=0;
		    //int acno=1000;
		    //act.setAcno(acno);
		    Integer acno=actDao.getMaxAcno();
		    if(acno==null) {
		    	acno=1000;
		    }
		    else {
		    	acno+=1;
		    }
		    
		    
		    act.setAcno(acno);
			System.out.println("Enter name");
		    act.setCustomername(sc.next());
		    System.out.println("Enter account creation (500/-)Balance");
	     	act.setBalance(sc.nextDouble());
		    act.setDatecreation(new Date());
		    adr.setAcno(acno);
		    System.out.println("Enter the street");
		    adr.setStreet(sc.next());
		    System.out.println("Enter the city");
		    adr.setCity(sc.next());
		    act.setAddress(adr);
		    boolean r=actDao.createAccount();
		   if(r) {
		      System.out.println("inserted aaccount");
		       System.out.println("Your Account is "+acno);
		   }    
		   else 
			   System.out.println("Not Inserted");
		   
		   
		    //System.out.println("inserted address"+r1);
		    
		
	}
}
