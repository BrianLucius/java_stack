package net.brianlucius.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer visitCounter = (Integer) session.getAttribute("visitCounter");
		if (visitCounter != null) {
			session.setAttribute("visitCounter", visitCounter+=1);
		} else {
			 session.setAttribute("visitCounter", 1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/{counterIncrement}")
	public String index(@PathVariable("counterIncrement") Integer counterIncrement, HttpSession session) {
		Integer visitCounter = (Integer) session.getAttribute("visitCounter");
		if (visitCounter != null) {
			session.setAttribute("visitCounter", visitCounter+=counterIncrement);
		} else {
			 session.setAttribute("visitCounter", counterIncrement);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer visitCounter = (Integer) session.getAttribute("visitCounter");
		
		model.addAttribute("visitCounter", visitCounter != null ? visitCounter : 0);
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCounter(HttpSession session) {
		session.setAttribute("visitCounter", 0);
		return "redirect:/counter";
	}

}
