package annotation;

import org.springframework.stereotype.Component;

@Component
public class Car {
	/*@Autowired
	@Qualifier("ceat")
	Wheels wheels;
    
	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}
	*/
	//it is  executed in spring 4.0
	public void moving(String wheelType) {
		
		Wheels wh= (str)->{
			System.out.println(str+"ceat wheels are rotating..");
		};
		wh.rotate(wheelType);
		wh.material();
		System.out.println("Car is moving...");
	}
}
