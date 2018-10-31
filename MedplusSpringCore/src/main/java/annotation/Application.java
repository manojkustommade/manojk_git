package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
    	
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
    	Student std=ctx.getBean("std",Student.class);
    	System.out.println(std.getRegno()+" "+std.getName()+" "+std.getAverage());
    	System.out.println(std.getMarks().getTotal()+" "+std.getMarks().getGrade());
    }
}
