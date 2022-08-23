package net.brianlucius.feelz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.feelz.models.Feelz;
import net.brianlucius.feelz.repositories.FeelzRepository;

@Service
public class FeelzService {
	
	@Autowired FeelzRepository feelzRepository;
	
	public Feelz createFeelz(Feelz feelz) {
		return feelzRepository.save(feelz);
	}

}
