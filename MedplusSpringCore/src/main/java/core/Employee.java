package core;

public class Employee {
	    private int code;
	    private String name;
	    private Address addr;
	    private Employee() {
	    	  
	    }
		/*public Employee(int code, String name) {
			super();
			this.code = code;
			this.name = name;
		}*/
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getAddress() {
			return addr;
		}
		public void setAddress(Address address) {
			this.addr = address;
		}
		
}
