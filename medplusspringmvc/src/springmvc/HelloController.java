package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String welcome() {
		return "Welcome";
	}
	@RequestMapping("/LoginPage")
	public String showLoginPage() {
		return "Login";
	}
	@RequestMapping("/loginidate")
	public String validate(@RequestParam("username") String user,@RequestParam("password") String pwd) {
		if(user.equals("admin") && pwd.equals("admin"))
			return "Welcome";
		else
			return "Failed";
		}
}