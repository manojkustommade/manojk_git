package aopex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackOperation {
	
	@Pointcut("execution(* Operation.*(..))")
	public void manoj() { 
		//System.out.println("manoj pointcut");
		
	}
	@Before("manoj()")
	public void myAdvice(JoinPoint jp) {
		System.out.println("@@  Concern before method  @@");
	}
	@After("manoj()")
	public void advice(JoinPoint jp) {
		System.out.println("@@  Concern after method  @@"+jp.getSignature());
	}
}
