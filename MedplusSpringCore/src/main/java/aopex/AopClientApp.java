package aopex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopClientApp {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
		Operation oper=ctx.getBean("operation",Operation.class);
		oper.message();
		oper.method1();
		oper.method2();
	}
}
