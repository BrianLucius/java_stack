package net.brianlucius.routes_spring_demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@RequestMapping("/search")
	public String searchKeyword (@RequestParam("keyword") String searcKeyword ) {
		return "You are searching for keyword " + searcKeyword;
	}
	
	@RequestMapping("/pet")
	public String getPet(@RequestParam("name") String petName, @RequestParam("age") Integer petAge) {
		return "Your pet " + petName + " is " + petAge + " years old.";
	}
	
	// Get optional pet
	@RequestMapping("/optionalpet")
	public String getOptionalPet(@RequestParam(value="name", required=false) String petName, @RequestParam(value="age", required=false) Integer petAge) {
		if (petAge == null) 
			return "Age is not available.";
		return "Your pet " + petName + " is " + petAge + " years old.";
	}
	
	// path variables: order matters!  
	@RequestMapping("/path/{name}/{color}")
	public String pathVars(@PathVariable("name") String petName, @PathVariable("color") String petColor) {
		return "Your pet " + petName + " is " + petColor;
	}
	
}
