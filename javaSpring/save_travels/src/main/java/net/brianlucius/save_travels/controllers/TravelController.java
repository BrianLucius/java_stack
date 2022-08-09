package net.brianlucius.save_travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.brianlucius.save_travels.models.Expense;
import net.brianlucius.save_travels.services.ExpenseService;

@Controller
public class TravelController {
	
	@Autowired
	ExpenseService expenseService; 
	
	@GetMapping(value={"/","/expenses"})
	public String showAllExpenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expensesList = expenseService.allExpenses();
		model.addAttribute("expensesList", expensesList);
		return "/index.jsp";
	}

	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
}
