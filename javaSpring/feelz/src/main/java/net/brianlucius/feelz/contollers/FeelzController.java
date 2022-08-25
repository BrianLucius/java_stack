package net.brianlucius.feelz.contollers;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.brianlucius.feelz.models.Feelz;
import net.brianlucius.feelz.services.FeelzService;

@Controller
public class FeelzController {
	
	@Autowired
	private FeelzService feelzService;
	
	@GetMapping("/")
	public String indexPage(@ModelAttribute("feelz") Feelz feelz, HttpSession session) {
		Long currentEpoch = new Date().getTime();
		if (session.getAttribute("feelzSubmitted") == null) {
			session.setAttribute("feelz", currentEpoch);
			return "feelz.jsp";	
		}
		if(currentEpoch - (Long)session.getAttribute("feelzSubmitted") > 300000) {
			return "feelz.jsp";
		} else {
			return "checkback.jsp";
		}	
	}
	
	@PostMapping("/")
	public String processFeelz(@Valid @ModelAttribute("feelz") Feelz feelz, BindingResult result, Model model, HttpSession session) {
// Commented as people were saying they were unable to submit.
//		if(session.getAttribute("feelz") == null) {
//			return "redirect:/";
//		}
		if(result.hasErrors()) {
			model.addAttribute("feelz", feelz);
    		return "feelz.jsp";
    	}
		feelz.setEmotion(feelz.getEmotion().toLowerCase());
		feelzService.createFeelz(feelz);
		
		Long currentEpoch = new Date().getTime();
		session.setAttribute("feelzSubmitted", currentEpoch);
		
		return "redirect:/thankyou";
	}
	
	@GetMapping("/thankyou")
	public String thankyou(HttpSession session) {
		if(session.getAttribute("feelzSubmitted") == null) {
			return "redirect:/";
		}
		return "thankyou.jsp";		
	}
}
