package net.brianlucius.feelz.contollers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.brianlucius.feelz.services.UserService;

@Controller
public class PortalController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/analytics_portal/dashboard")
    public String auth(HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
        return "dashboard.jsp";
    }
	
	@GetMapping("/analytics_portal/usermanagement")
    public String userManagement(HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
        return "userManagement.jsp";
    }

}
