package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
    	Employee emp = context.getBean("emp",Employee.class);
    	emp.setCode(123);
    	System.out.println(emp.getCode()+" "+emp.getName());
    	//Employee emp2=context.getBean("emp",Employee.class);
    	//Student st=context.getBean("student",Student.class);
    	//System.out.println(st.getRegno()+" "+st.getName()+" "+st.getMarks());
    	System.out.println(emp.getAddress().getStreet()+" "+emp.getAddress().getCity());

    	

    }
}
