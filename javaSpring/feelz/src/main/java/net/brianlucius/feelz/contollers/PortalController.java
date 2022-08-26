package net.brianlucius.feelz.contollers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.brianlucius.feelz.models.User;
import net.brianlucius.feelz.services.FeelzService;
import net.brianlucius.feelz.services.UserService;

@Controller
public class PortalController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeelzService feelzService;
	
	// ----- Portal Page Renders -----
	@GetMapping("/analytics_portal/dashboard")
    public String auth(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
		model.addAttribute("totalSubmissions", feelzService.getTotalSubmissions());
        return "dashboard.jsp";
    }
	
	@GetMapping("/analytics_portal/usermanagement")
    public String userManagement(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
		model.addAttribute("usersList", userService.allUsers());
        return "userManagement.jsp";
    }
	
	//----- Edit User -----	
	@GetMapping("/analytics_portal/usermanagement/edit/{id}")
    public String editUser(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
		User editUser = userService.getUserById(id);
		editUser.setConfirm(editUser.getPassword());
		model.addAttribute("user", editUser);
        return "editUser.jsp";
    }
	
	@PutMapping("/analytics_portal/usermanagement/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
    	if(result.hasErrors()) {
    		model.addAttribute("user", user);
    		return "editUser.jsp";
    	}
    	
    	userService.updateUser(user, result);
    	if(result.hasErrors()) {
    		model.addAttribute("user", user);
    		return "editUser.jsp";
    	}
        return "redirect:/analytics_portal/usermanagement";
    }
	
	// ----- Create New User -----
	@GetMapping("/analytics_portal/usermanagement/add")
    public String addUser(@ModelAttribute("user") User user, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
        return "addUser.jsp";
    }
	
	@PostMapping("/analytics_portal/usermanagement/add")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
    	if(result.hasErrors()) {
    		return "addUser.jsp";
    	}
    	userService.register(user, result);
    	if(result.hasErrors()) {
    		model.addAttribute("user", user);
    		return "addUser.jsp";
    	}
        return "redirect:/analytics_portal/usermanagement";
    }
	
	// ----- Delete User -----
	@DeleteMapping("/analytics_portal/usermanagement/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/analytics_portal";
		}
	    userService.deleteById(id);
        return "redirect:/analytics_portal/usermanagement";
    }

}
