package net.brianlucius.mvcdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import net.brianlucius.mvcdemo.models.Donation;
import net.brianlucius.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {

		private final DonationRepository donationRepository;
		
		public DonationService(DonationRepository donationRepository) {
			this.donationRepository = donationRepository;
		}
		
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
}
