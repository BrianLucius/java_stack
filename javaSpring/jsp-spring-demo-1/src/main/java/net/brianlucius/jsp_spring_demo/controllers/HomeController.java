package net.brianlucius.jsp_spring_demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String renderHome(Model model) {
		model.addAttribute("first_name", "Alex");
		model.addAttribute("last_name", "Miller");
		
		return "home.jsp";
	}
	
	@RequestMapping("/javademo")
	public String renderDemoPage() {
		return "demo.jsp";
	}
	
	@RequestMapping("/jstl")
	public String jstlDemo(Model model) {
		// send variables to jsp
		String name = "Alex Miller";
		Integer age = 28;
		Boolean isHungry = true;
		
		model.addAttribute("jspName", name);
		model.addAttribute("jspAge", age);
		model.addAttribute("jspIsHungry", isHungry);
		model.addAttribute("alertJs","<script>alert('hi')</script>");
		
		if(isHungry) {
			System.out.println("I am hungry");
		}
		
		ArrayList<String> users = new ArrayList<String>();
		users.add("Alex Miller");
		users.add("Martha Smith");
		users.add("Roger Anderson");
		users.add("Steve Roger");
		users.add("Joe Schmoe");
		
		for(String user : users) {
			System.out.println(user);
		}
		model.addAttribute("jspUsers", users);
		
		return "jstl.jsp";
	}
	
}
