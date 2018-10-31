package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	Login login;
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public ModelAndView showLoginPage() {
		ModelAndView mav=new ModelAndView();
		mav.addObject(login);
		mav.setViewName("Login");
		return mav;
	}
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("login") Login login) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("log",login);
		mav.setViewName("Welcome");
		return mav;
	}
	
	
}
