package BankApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApplTransaction {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
		AccountOperationDaoImpl actDao=ctx.getBean("accountOperationDaoImpl",AccountOperationDaoImpl.class);
		System.out.println("Enter the account number");
		int acno=s.nextInt();
		int rows=actDao.CheckAccount(acno);
		if(rows==1) {
		   List<Transaction> list=actDao.viewstatement(acno);
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
		   
		   for(Transaction tr:list) {
			   String date=dateFormat.format(tr.getTransdate());
			   //Date date=tr.getTransdate();
			  // System.out.println(date);
				System.out.println(tr.getAcno()+" "+date+" "+tr.getTranstype()+" "+tr.getDesciption()+" "+tr.getAmount()+" "+tr.getBalance());
			}
		}
		else {
			System.out.println(acno+" Account number does not exist");
		}
		
	}

}
