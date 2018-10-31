package security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {
    
	@RequestMapping("/userlogin")
	public String userValidation() {
		return "User Successfully loged in";
	}
	
	@RequestMapping("/adminlogin")
	public String adminValidation() {
		return "Admin successfully loged in";
	}
}
