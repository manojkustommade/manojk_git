package BankApplication;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class BankApplDeposite {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
		AccountOperationDaoImpl actDao=ctx.getBean("accountOperationDaoImpl",AccountOperationDaoImpl.class);
		Transaction tns=ctx.getBean("transaction",Transaction.class);
		System.out.println("Enter Account number");
		int acno=s.nextInt();
		System.out.println("Enter the amount");
		double amount=s.nextDouble();
		tns.setAcno(acno);
		tns.setTransdate(new Date());
		tns.setTranstype("deposite");
		tns.setDesciption("credited");
		tns.setAmount(amount);
	    int rows=actDao.CheckAccount(acno);
	    if(rows==1)
		   actDao.deposite(acno, amount);
	    else
	    	System.out.println(acno+"Account number not exist");
	}

}
