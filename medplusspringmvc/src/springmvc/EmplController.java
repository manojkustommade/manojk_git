package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmplController {
       
    @Autowired
    EmployeeValidations validation;
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public String showLoginPage() {
		return "Empl";
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public String AddEmployee(@ModelAttribute("employee") Employee employee) {
		//System.out.println(employee.getEmpcode()+" "+employee.getEmpname()+" "+employee.getJob()+" "+employee.getSalary()+" "+employee.getDateOfBirth());
	    return "Welcome";	
	}
}
