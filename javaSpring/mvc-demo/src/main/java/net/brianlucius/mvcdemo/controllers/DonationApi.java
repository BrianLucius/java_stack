package net.brianlucius.mvcdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		@RequestMapping("/donations")
		public List<Donation> findAllDonations(){
			return donationService.allDonations();
		}
		
		@PostMapping("/donations")
		public Donation createDonation(
				@RequestParam("donationName") String donationName,
				@RequestParam("quantity") Integer quantity,
				@RequestParam("donor") String donor) {
			Donation newDonation = new Donation(donationName, quantity, donor);
			return donationService.createDonation(newDonation);
		}
}
