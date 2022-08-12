package net.brianlucius.logregdemo.controllers;

import java.util.List;

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

import net.brianlucius.logregdemo.models.Donation;
import net.brianlucius.logregdemo.models.LoginUser;
import net.brianlucius.logregdemo.models.User;
import net.brianlucius.logregdemo.services.DonationService;
import net.brianlucius.logregdemo.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DonationService donationService;
	
	// render login registration form
	@GetMapping("/")
	public String renderLogReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		userService.register(newUser, result);
		
		if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
		
		session.setAttribute("userId", newUser.getId());
		return "home.jsp";
	}
	
	@PostMapping("login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	@GetMapping("/donations")
//	public String allDonations() {
//		return "dashboard.jsp";
//	}
	
	// ----- Dashboard -----
	@GetMapping("/donations")
	public String allDonations(HttpSession session, Model model) {
		if(session.getAttribute("userid") == null) {
			return "redirect:/";
		}
		List<Donation> donationList = donationService.allDonations();
		model.addAttribute("donationList", donationList);
		return "dashboard.jsp";
	}
	
	// ---- Create -----
	@GetMapping("/donations/add")
	public String renderCreateDonation(@ModelAttribute("donation") Donation donation) {
		return "createDonation.jsp";
	}

	@PostMapping("/donations/add")
	public String proccessCreateDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "createDonation.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/donations";
		}
	}
	
	// ----- Edit -----
	@GetMapping("donations/edit/{id}")
	public String renderEditDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationService.oneDonation(id));
		return "editDonation.jsp";
	}
	
	@PutMapping("donations/edit/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "editDonation.jsp";
		}
		donationService.updateDonation(donation);
		return "redirect:/donations";
	}
	
	
	// ----- Delete -----
	@DeleteMapping("/donations/delete/{id}")
	public String deleteDoantion(@PathVariable("id") Long id) {
		donationService.deleteDonation(id);;
		return "redirect:/donations";
	}

	// ----- Find One -----
	@GetMapping("/donations/{id}")
	public String oneDontation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationService.oneDonation(id));
		return "donationDetails.jsp";
	}

}
