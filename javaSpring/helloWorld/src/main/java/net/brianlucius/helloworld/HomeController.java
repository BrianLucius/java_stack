package net.brianlucius.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping("/new_route")
	public String index2() {
		return "<h1>Hello Spring Boot!</h1>";
	}
}
