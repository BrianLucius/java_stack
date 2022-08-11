package net.brianlucius.onetomany.services;

import java.util.List;
import java.util.Optional;

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

	public Donation getOneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepository.findById(id);
		if(optionalDonation.isPresent()){
			return optionalDonation.get();
		}
		return null;
	}
}
