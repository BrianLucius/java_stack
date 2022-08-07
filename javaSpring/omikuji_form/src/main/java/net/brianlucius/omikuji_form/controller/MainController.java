package net.brianlucius.omikuji_form.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping(value={"/","/omikuji"})
	public String main() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(HttpSession session,
			@RequestParam(value="anyNumber") String anyNumber,
			@RequestParam(value="city") String city,
			@RequestParam(value="personName") String personName,
			@RequestParam(value="activity") String activity,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="nice") String nice)
		{
		session.setAttribute("anyNumber", anyNumber);
		session.setAttribute("city", city);
		session.setAttribute("personName", personName);
		session.setAttribute("activity", activity);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("nice", nice);	
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
	

}
