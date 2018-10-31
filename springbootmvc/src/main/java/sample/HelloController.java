package sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	ModelAndView mav;
	String message;
	
	/*@RequestMapping("/welcome")
	public ModelAndView welcome() {
		
		mav=new ModelAndView();
		message="Welocome to spring boot mvc";
		mav.addObject("msg",message);
		mav.setViewName("welcome");
		return mav;
	}*/
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	 public  ModelAndView showEmplForm() {
		  mav=new ModelAndView();
		// mav.addObject(employee);
		 mav.setViewName("Login");
		 return mav;
	 }
	
	 @RequestMapping(value="/login",method=RequestMethod.POST)
	 public ModelAndView Login(@RequestParam("name")String name,@RequestParam("password") String pwd) {
		mav=new ModelAndView();
		
		if(name.equals("manoj") && pwd.equals("123")) {
			mav.addObject("name",name);
			mav.addObject("pwd",pwd);
			mav.setViewName("success");
		}
		else {
			mav.setViewName("failed");
		}
		return mav;
	}
	
}
