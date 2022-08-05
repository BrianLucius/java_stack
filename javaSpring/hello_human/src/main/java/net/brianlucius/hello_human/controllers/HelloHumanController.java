package net.brianlucius.hello_human.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String default_route(@RequestParam(value="name", required=false) String name, 
								@RequestParam(value="last_name", required=false) String last_name,
								@RequestParam(value="times", required=false, defaultValue="1") int times) {

		String output="";
		String helloStr="<h1>Hello ";
		helloStr+= (name == null ? "Human" : name);
		if (last_name != null) helloStr+=" "+last_name;
		helloStr+="</h1>";
		
		while (times>0) {
			output+=helloStr;
			times--;
		}
		
		return output;
		
	}
}
