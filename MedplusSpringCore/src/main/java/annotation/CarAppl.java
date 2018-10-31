package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarAppl {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotation.xml");
		Car car=ctx.getBean("car",Car.class);
	    car.moving("MRF");
	}

}
