package net.brianlucius.mvcdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.brianlucius.mvcdemo.models.Donation;
import net.brianlucius.mvcdemo.services.DonationService;

@RestController
@RequestMapping("/api")
public class DonationApi {

		@Autowired
		private DonationService donationService;
		
		// ------ Get All ------
		@RequestMapping("/donations")
		public List<Donation> findAllDonations(){
			return donationService.allDonations();
		}
		
		// ----- Create -----
		@PostMapping("/donations")
		public Donation createDonation(
				@RequestParam("donationName") String donationName,
				@RequestParam("quantity") Integer quantity,
				@RequestParam("donor") String donor) {
			Donation newDonation = new Donation(donationName, quantity, donor);
			return donationService.createDonation(newDonation);
		}
	
		// ------ Get One -----
		@GetMapping("/donations/{id}")
		public Donation getOneDonation(@PathVariable("id") Long id) {
			return donationService.getOneDonation(id);
			 			
		}
		
		// ----- Edit -----
		@PutMapping("/donations/{id}")
		public Donation editDonation(@PathVariable("id") Long id,
				@RequestParam("donationName") String donationName,
				@RequestParam("quantity") Integer quantity,
				@RequestParam("donor") String donor) {
			
			return donationService.updateDonation(id, donationName, quantity, donor);
		}
		
		// ----- Delete -----
		@DeleteMapping("/donations/{id}")
		public void deleteDonation(@PathVariable("id") Long id) {
			donationService.deleteDonation(id);
		}
}
