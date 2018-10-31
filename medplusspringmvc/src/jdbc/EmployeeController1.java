package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController1 {

	@Autowired
	Employee employee;
	@Autowired
	EmployeeDao dao;
	//@Autowired
	//EmployeeValidations validations;
	
	String msg=null;
	
	@RequestMapping("/home")
	public String showHomePage() {
		return "Home";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	 public  ModelAndView showEmplForm() {
		 ModelAndView mav=new ModelAndView();
		 mav.addObject(employee);
		 mav.setViewName("AddEmployee");
		 return mav;
	 }
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public  ModelAndView addEmpl(@ModelAttribute("employee") Employee emp) {
		 ModelAndView mav=new ModelAndView();
		 int rows=dao.addEmployee(emp); 
		 if(rows>0) {
			 msg=rows+"record(s) inserted ";
			 mav.addObject("msg",msg);
			 mav.setViewName("AddSuccess");
			 
		 }
		 
		 return mav;
	 }
	 @RequestMapping(value="/viewempls")
	 public ModelAndView EmployeeList() {
		 ModelAndView mav=new ModelAndView();
		 List<Employee> emplist=dao.getEmpls();
		 mav.addObject("list",emplist);
		 mav.setViewName("ViewEmpls");
		 return mav;
	 }
	 @RequestMapping(value="/update")
	 public ModelAndView EmplList() {
		 ModelAndView mav=new ModelAndView();
		 List<Employee> emplist=dao.getEmpls();
		 mav.addObject("list",emplist);
		 mav.setViewName("updateAdmin");
		 return mav;
	 }
	// String message="Record updated successfully";
	 @RequestMapping(value="/updateemployee")
	 public ModelAndView getEmpls(@RequestParam("code") int code) {
		 ModelAndView mav=new ModelAndView();
		 Employee emp=dao.getEmp(code);
		 mav.addObject("employee",emp);
		 mav.setViewName("UpdateEmployee");
		 return mav;
	 }
	 @RequestMapping(value="/updateempls")
	 public ModelAndView UpdateEmployee(@ModelAttribute("employee") Employee empl) {
		 ModelAndView mav=new ModelAndView();
		 int rows=dao.updateEmployee(empl);
		 //mav.addObject("msg",message);
		 if(rows>0) {
			 
		   mav.setViewName("redirect:update");
		 }
		   else {
			 mav.setViewName("Success");
		 }
		 return mav;
	 }
	 @RequestMapping(value="/deleteemployee")
	 public ModelAndView deleteEmployee(@RequestParam("code") int code) {
		 ModelAndView mav=new ModelAndView();
		 int rows=dao.deleteEmployee(code);
		 if(rows>0) {
			 mav.setViewName("redirect:update");
		 }
		 else {
			 mav.setViewName("Success");
		 }
		 return mav;
	 }
}
