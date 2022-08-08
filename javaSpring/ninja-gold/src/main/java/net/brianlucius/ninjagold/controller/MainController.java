package net.brianlucius.ninjagold.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value={"/"})
	public String main(HttpSession session) {
		ArrayList<String> activities = new ArrayList<String>();
		session.setAttribute("gold", 0);
		session.setAttribute("activities", activities);
		return "index.jsp";
	}
	
	@RequestMapping(value={"/gold","/Gold"})
	public String gold(HttpSession session) {
		ArrayList<String> activities = new ArrayList<String>();
		Integer gold = 0;
		gold = (Integer) session.getAttribute("gold");
		activities = (ArrayList<String>) session.getAttribute("activities");
		return "index.jsp";
	}
	
	@RequestMapping(value="/play", method=RequestMethod.POST)
	public String play(HttpSession session,
			@RequestParam(value="playType") String playType) {
		ArrayList<String> activities = new ArrayList<String>();
		activities = (ArrayList<String>) session.getAttribute("activities");
		String activity = "";
		Integer gold = 0;
		Random turn = new Random();
		Date playDate = new Date();
		
		switch(playType) {
		case "farm":
			gold = turn.nextInt(11)+10;
			activity = "You entered a " + playType + " and earned " + gold + " gold. (" + playDate + ")";
			break;
		case "cave":
			gold = turn.nextInt(6)+5;
			activity = "You entered a " + playType + " and earned " + gold + " gold. (" + playDate + ")";
			break;
		case "house":
			gold = turn.nextInt(4)+2;
			activity = "You entered a " + playType + " and earned " + gold + " gold. (" + playDate + ")";
			break;
		case "spa":
			gold = turn.nextInt(16)-20;
			activity = "You entered a " + playType + " and lost " + Math.abs(gold) + " gold. (" + playDate + ")";
			break;
		case "quest":
			gold = turn.nextInt(101)-50;
			if (gold > -1) {
				activity = "You completed a " + playType + " and earned " + Math.abs(gold) + " gold. (" + playDate + ")";
			} else {
				activity = "You failed a " + playType + " and lost " + Math.abs(gold) + " gold. Ouch! (" + playDate + ")";
			}
			
			break;
		}
		
		activities.add(0, activity);
		session.setAttribute("gold", (Integer)session.getAttribute("gold")+gold);
		session.setAttribute("activities", activities);
		
		return "redirect:/gold";
	}
}
