package net.brianlucius.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.onetomany.models.Donation;
import net.brianlucius.onetomany.repositories.DonationRepository;

@Service
public class DonationService {
	
	@Autowired
	private DonationRepository donationRepository;
	
	public List<Donation> allDonations() {
		return donationRepository.findAll();
	}
	
	public Donation saveDonation(Donation donation) {
		return donationRepository.save(donation);
	}

}
