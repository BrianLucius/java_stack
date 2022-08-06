package net.brianlucius.fruity_loops.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.brianlucius.fruity_loops.Item;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(Model model) {
		
		ArrayList<Item> fruits = new ArrayList<Item>();
		fruits.add(new Item("Kiwi", 1.5));
		fruits.add(new Item("Mango", 2.0));
		fruits.add(new Item("Goji Berries", 4.0));
		fruits.add(new Item("Guava", .75));
		fruits.add(new Item("Lychee Berry", 1.25));
		fruits.add(new Item("Blueberry", 2.75));
		
		model.addAttribute("fruitsList", fruits);
		
		return "index.jsp";
	}
}
