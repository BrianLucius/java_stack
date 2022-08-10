package net.brianlucius.mvcdemo.controllers;

import java.util.List;

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

import net.brianlucius.mvcdemo.models.Donation;
import net.brianlucius.mvcdemo.services.DonationService;

@Controller
public class MainController {

	@Autowired
	private DonationService donationService;
	
	@GetMapping(value={"/","/donations"})
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

	// old way, individual FequestParams:
	// ----- Create -----
	// ----- render ------
//	@GetMapping("/donations/add")
//	public String renderCreateForm() {
//		return "createPage.jsp";
//	}
	// ----- Process -----

//	@PostMapping("/donations")
//	public String processCreate(
//			@RequestParam("donationName") String donationName,
//			@RequestParam("quantity") Integer quantity,
//			@RequestParam("donor") String donor) {
//		Donation newDonation = new Donation (donationName, quantity, donor);
//		donationService.createDonation(newDonation);
//		return "redirect:/donations";
//	}
	
	
	// better way ModelAttributes 
	// ----- render ----
	//option 1
	@GetMapping("/donations/add")
	public String renderCreateForm(Model model) {
		model.addAttribute("donation", new Donation());
		return "createPage.jsp";
	}
	
	// can pre-populate values!  (1:50 in the recordiing)
//	@GetMapping("/donations/add3")
//	public String renderCreateForm3(Model model) {
//		Donation donation = new Donation();
//		model.addAttribute("donor","Alex Miller");
//		return "createPage.jsp";
//	}
	
	//option 2
	@GetMapping("/donations/add2")
	public String renderCreateForm2(@ModelAttribute("donation") Donation dontation) {
		return "createPage.jsp";
	}
	
	// ----- process -----
	@PostMapping("/donations")
	//order of below params matters!
	public String processCreate(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {  
		if (result.hasErrors()) {
			return "createPage.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/donations";
		}		
	}
	
	
	// --- Edit (findOne, create) ----
	// Render the form (use the id from path, to find that donation)
	@GetMapping("/donationss/edit/{id}")
	public String renderEditForm(@PathVariable("id") Long id, Model model) {
		Donation foundDonation = donationService.getOneDonation(id);
		model.addAttribute("donation", foundDonation);	
		return "editPage.jsp";
	}
	// process the form
	// Note: this *could* be a Post mapping and remove the hidden attribute in the form. This would still
	// work. However, it does violate convention having separate post (add records) and put (update records).
	@PutMapping("/donations/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if (result.hasErrors()) {
			return "editPage.jsp";
		} else {
			donationService.updateFrontEndDonation(donation);
			return "redirect:/donations";
		}	
	}
	
	// ----- Delete -----
	// Note: this *could* be a Get mapping and use an href in front end. Again, this violates convention. 
	// Even more so, if any references to /donations/delete/{id} are entered in a browser, the delete would
	// occur without any validation (browser requests are get).
	@DeleteMapping("/donations/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		donationService.deleteDonation(id);
		return "redirect:/donations";
	}
	
	
	// ------- Table and Create on same page -----
	@GetMapping("/unified")
	public String inde(Model model) {
		model.addAttribute("donationList", donationService.allDonations());  //adds the list of donations for dashboard
		model.addAttribute("donation", new Donation());		//creates empty donation object for form rendering
		return "main.jsp";
	}
	
	@PostMapping("/unified")
	//order of below params matters!
	public String processMainPageCreate(@Valid @ModelAttribute("donation") Donation donation, BindingResult result, Model model) {  
		if (result.hasErrors()) {
			model.addAttribute("donationList", donationService.allDonations());
			return "main.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/unified";
		}		
	}
	
	@GetMapping("/testQuery")
	public String testQueryMethod(Model model) {
		List<Donation> donationList = donationService.testQuery();
		model.addAttribute("donationList", donationList);
		return "testQueryPage.jsp";		
	}
	
}
