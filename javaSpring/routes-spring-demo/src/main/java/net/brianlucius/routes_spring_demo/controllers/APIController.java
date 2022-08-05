package net.brianlucius.routes_spring_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

	// option 1: RequestMapping default: GET
	@RequestMapping("/option1")
	public String option1() {
		return "Option 1 Request Mapping";
	}
	
	// option 2: Full description [equal to option1, more verbose]
	@RequestMapping(value="/option2", method=RequestMethod.GET)
	public String option2() {
		return "Option 2 Request Mapping: GET";
	}
	
	// option 3: GetMapping / PostMapping / PutMapping / DeleteMapping
	@GetMapping("/option3")
	public String option3() {
		return "Option 3 Get Mapping";
	}
	
}
