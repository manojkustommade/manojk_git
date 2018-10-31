package BankApplication;

import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApplwithdraw {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
		AccountOperationDaoImpl actDao=ctx.getBean("accountOperationDaoImpl",AccountOperationDaoImpl.class);
		Transaction tns=ctx.getBean("transaction",Transaction.class);
		
		System.out.println("Enter account number");
		int acno=s.nextInt();
		System.out.println("Enter the amount");
		double amount=s.nextDouble();
		tns.setAcno(acno);
		tns.setTransdate(new Date());
		tns.setTranstype("Withdraw");
		tns.setDesciption("debited");
		tns.setAmount(amount);
		int row=actDao.CheckAccount(acno);
		if(row>0)
		   actDao.withdraw(acno, amount);
		else
			System.out.println(acno+" Account number not exist");
	}

}
