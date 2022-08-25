package net.brianlucius.feelz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.brianlucius.feelz.classes.Location;
import net.brianlucius.feelz.classes.MapsLocation;
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
	
	public List<MapsLocation> location() {
		List<BrowserLocation> locations = feelzRepository.findDistinctByBrowserLocationNotNull();
		List<MapsLocation> locationsList = new ArrayList<MapsLocation>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		for (BrowserLocation location : locations) {		
			try {
				Location loc = mapper.readValue(location.getBrowserLocation(), Location.class);
				locationsList.add(new MapsLocation(loc.getType(), loc.getLatitude(), loc.getLongitude()));
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return locationsList;
	}
	
	public Long getTotalSubmissions() {
		return feelzRepository.count();
	}

}
