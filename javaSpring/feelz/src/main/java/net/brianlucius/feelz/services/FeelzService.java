package net.brianlucius.feelz.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.feelz.models.Feelz;
import net.brianlucius.feelz.repositories.BrowserLocation;
import net.brianlucius.feelz.repositories.FeelzRepository;

@Service
public class FeelzService {
	
	@Autowired FeelzRepository feelzRepository;
	
	public Feelz createFeelz(Feelz feelz) {
		return feelzRepository.save(feelz);
	}
	
	public List<Map<String, Integer>> trendingEmotions() {
		return feelzRepository.trendingEmotions();
	}
	
	public List<BrowserLocation> location() {
		return feelzRepository.findDistinctBy();
	}

}
