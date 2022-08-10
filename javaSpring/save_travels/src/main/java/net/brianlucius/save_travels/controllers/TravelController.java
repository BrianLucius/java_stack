package net.brianlucius.save_travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expensesList = expenseService.allExpenses();
			model.addAttribute("expensesList", expensesList);
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getOneExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String getOne(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getOneExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String edit(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
}
