package net.brianlucius.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import net.brianlucius.mvcdemo.models.Donation;
import net.brianlucius.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {

		private final DonationRepository donationRepository;
//		Option 1
		public DonationService(DonationRepository donationRepository) {
			this.donationRepository = donationRepository;
		}
		
//		Option 2
//		@Autowired
//		private DonationRepository donationRepository;
		
		// find all
		public List<Donation> allDonations(){
			return donationRepository.findAll();
		}
		
		// create
		public Donation createDonation(Donation donation) {
			return donationRepository.save(donation);
		}
		
		public Donation getOneDonation(@PathVariable("id") Long id) {
			Optional<Donation> optionalDonation = donationRepository.findById(id);
			if (optionalDonation.isPresent()) {
				return optionalDonation.get();
		
			} else {
				return null;
			}
		}
		
		// API version
		public Donation updateDonation(Long id, String donationName, Integer quantity, String donor) {
			Donation foundDonation = this.getOneDonation(id);
			foundDonation.setDonationName(donationName);
			foundDonation.setQuantity(quantity);
			foundDonation.setDonor(donor);
			return donationRepository.save(foundDonation);
		}
		
		public void deleteDonation(Long id) {
			donationRepository.deleteById(id);
		}
		
		// update one - front end
		public Donation updateFrontEndDonation(Donation donation) {
			return donationRepository.save(donation);
		}
		
		// testQueries
		public List<Donation> testQuery(){
			return donationRepository.callThisAnything();
		}
}
