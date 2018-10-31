package springmvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidations implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Employee.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		Employee emp=(Employee) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "empname", "empname.err");
		if(emp.getEmpcode()<=0)
			err.rejectValue("empcode","empcode.err");
		if(emp.getSalary()<=0)
			err.rejectValue("salary", "salary.err");
		
	}

}
