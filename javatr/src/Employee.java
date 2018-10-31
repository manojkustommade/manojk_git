
public class Employee {
     public String name;
     int code;
     double salary;
	 
     public Employee(String name, int code, double salary) {
		super();
		this.name = name;
		this.code = code;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
    
     
     
}
