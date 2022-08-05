package net.brianlucius.displaydate.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);	
		return "time.jsp";
	}
}
