package jdbc;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmplAppl {
      public static void main(String[] args) {
    	  
    	  ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
    	  EmployeeDao dao=ctx.getBean("employeeDao",EmployeeDao.class);
    	  Employee emp=ctx.getBean("employee",Employee.class);
    	  emp.setEmpcode(213);
    	  emp.setEmpname("manoj");
    	  emp.setJob("developer");
    	  emp.setSalary(25000);
    	  emp.setDateOfBirth(DateParsing.convertToUtilDate("2018-11-10"));
    	 // int r=dao.addEmployee();
    	 // System.out.println("inserted "+r);
    	  //emp.setEmpcode();
    	 /* int rows=dao.deleteEmployee(123);
    	  if(rows>0) {
    		  System.out.println("deleted");
    	  }
    	  else {
    		  System.out.println("not deleted");
    	  }*/
    	  //dao.insert();
    	  System.out.println("List of Employees");
    	  List<Employee> list=dao.getEmpls();
    	  for(Employee empl:list) {
    		  System.out.println(empl.getEmpcode()+" "+empl.getEmpname()+" "+empl.getJob()+" "+empl.getSalary()+" "+empl.getDateOfBirth());
    	  }
    	  
    	  Employee emp1=dao.getEmp(300);
    	  System.out.println("Particular record");
		  System.out.println(emp1.getEmpcode()+" "+emp1.getEmpname()+" "+emp1.getJob()+" "+emp1.getSalary()+" "+emp1.getDateOfBirth());

      }
}
