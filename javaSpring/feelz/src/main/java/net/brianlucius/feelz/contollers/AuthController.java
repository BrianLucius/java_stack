package net.brianlucius.feelz.contollers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.brianlucius.feelz.models.LoginUser;
import net.brianlucius.feelz.models.User;
import net.brianlucius.feelz.services.UserService;


@Controller
public class AuthController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/analytics_portal")
    public String auth(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "auth.jsp";
    }
    
    @PostMapping("/analytics_portal/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "auth.jsp";
        } 
        
        session.setAttribute("user_id", newUser.getId());    
        session.setAttribute("user_first_name", newUser.getFirstName());
        session.setAttribute("user_last_name", newUser.getLastName());
        session.setAttribute("user_email", newUser.getEmail());
        
        return "redirect:/analytics_portal/dashboard";
    }
    
    @PostMapping("/analytics_portal/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "auth.jsp";
        }

        session.setAttribute("user_id", user.getId());
        session.setAttribute("user_first_name", user.getFirstName());
        session.setAttribute("user_last_name", user.getLastName());
        session.setAttribute("user_email", user.getEmail());
        
        return "redirect:/analytics_portal/dashboard";
    }
    
    @GetMapping("/analytics_portal/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/analytics_portal";
    }
}
