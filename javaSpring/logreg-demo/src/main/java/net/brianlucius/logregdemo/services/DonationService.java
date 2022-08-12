package net.brianlucius.logregdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.logregdemo.models.Donation;
import net.brianlucius.logregdemo.repositories.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	public List<Donation> allDonations() {
		return donationRepository.findAll();
	}
	
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation= donationRepository.findById(id);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		} else {
			return null;
		}
	}
	
	public Donation createDonation(Donation donation) {
		return donationRepository.save(donation);
	}
	
	public Donation updateDonation(Donation donation) {
		return donationRepository.save(donation);
	}
	
	public void deleteDonation(Long id) {
		donationRepository.deleteById(id);
	}
	
}
