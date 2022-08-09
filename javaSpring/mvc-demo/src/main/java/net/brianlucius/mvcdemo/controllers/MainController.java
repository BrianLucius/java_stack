package net.brianlucius.mvcdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.brianlucius.mvcdemo.models.Donation;
import net.brianlucius.mvcdemo.services.DonationService;

@Controller
public class MainController {

	@Autowired
	private DonationService donationService;
	
	@GetMapping("/donations")
	public String dashboard(Model model) {
		// get the list of donations from the service
		List<Donation> donations = donationService.allDonations();
		model.addAttribute("donationList", donations);
		
		// add the list to the jsp (Model model)
		return "dashboard.jsp";
	}
	
	@GetMapping("/donations/{id}")
	public String getOne(@PathVariable("id") Long id,
			Model model) {
		Donation foundDonation = donationService.getOneDonation(id);
		model.addAttribute("oneDonation", foundDonation);
		return "";
	}
}
