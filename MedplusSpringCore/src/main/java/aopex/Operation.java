package aopex;

import org.springframework.stereotype.Component;

@Component
public class Operation {
	public void message() {
		System.out.println("message method invoked");
	}
	public int method1() {
		System.out.println("method1 invoked");
		return 1;
	}
	public int method2() {
		System.out.println("method2 invoked");
		return 2;
	}
}
