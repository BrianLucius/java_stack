package net.brianlucius.dojos_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.brianlucius.dojos_ninjas.models.Dojo;
import net.brianlucius.dojos_ninjas.models.Ninja;
import net.brianlucius.dojos_ninjas.services.DojoService;
import net.brianlucius.dojos_ninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@RequestMapping(value={"/","/dojos","/dojos/new"})
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "index.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojoList = dojoService.allDojos();
			model.addAttribute("dojoList", dojoList);
			return "index.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojoList = dojoService.getOne(id);
		model.addAttribute("dojoList", dojoList);
		return "showdojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojoList = dojoService.allDojos();
			model.addAttribute("dojoList", dojoList);
			return "newninja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/dojos";
	}


}
