package net.brianlucius.feelz.contollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.brianlucius.feelz.repositories.BrowserLocation;
import net.brianlucius.feelz.services.FeelzService;

@RestController
@RequestMapping("/api")
public class FeelzAPI {
	
	@Autowired
	FeelzService feelzService;
	
	@GetMapping("/trending")
	public List<Map<String, Integer>> trending() {
		return(feelzService.trendingEmotions());
	}
	
	@GetMapping("/location")
	public List<BrowserLocation> location() {
		return(feelzService.location());
	}

}
