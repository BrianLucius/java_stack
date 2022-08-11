package net.brianlucius.onetomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.brianlucius.onetomany.models.Donation;
import net.brianlucius.onetomany.models.User;
import net.brianlucius.onetomany.services.DonationService;
import net.brianlucius.onetomany.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DonationService donationService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("donationList", donationService.allDonations());
		model.addAttribute("userList", userService.allUsers());
		return "dashboard.jsp";
	}
	
	// ----- Create User -----
	// Render the form
	@GetMapping("/users/{id}")
	public String renderUserDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.oneUser(id));
		return "userDetails.jsp";
	}
	
	// ----- Create User -----
	// Render the form
	@GetMapping("/add/users")
	public String renderUserForm(@ModelAttribute("user") User user) {
		return "createUser.jsp";
	}
	
	//process
	@PostMapping("/add/users")
	public String processUserForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "createUser.jsp";
		} 
		userService.saveUser(user);
		return "redirect:/";
	}
	
	// ----- Create Donation -----
	// Render the form
	@GetMapping("/add/donations")
	public String renderDonationForm(@ModelAttribute("donation") Donation donation, Model model) {
		List<User> userList = userService.allUsers();
		model.addAttribute("userList", userList);
		return "createDonation.jsp";
	}
	
	//process
	@PostMapping("/add/donations")
	public String processDonationForm(@Valid @ModelAttribute("donation") Donation donation, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<User> userList = userService.allUsers();
			model.addAttribute("userList", userList);
			return "createDonation.jsp";
		} else {
			donationService.saveDonation(donation);
			return "redirect:/";
		}
	}
	
	// ----- Edit find one and save ----
	@GetMapping("/edit/donations/{id}")
	public String renderEditDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationService.getOneDonation(id));
		return "editDonation.jsp";
	}
	
	@PutMapping("/edit/donations/{id}")
	public String updateDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if (result.hasErrors()) {
			return "editDonation.jsp";
		}
		donationService.saveDonation(donation);
		return "redirect:/";
	}
	
}
