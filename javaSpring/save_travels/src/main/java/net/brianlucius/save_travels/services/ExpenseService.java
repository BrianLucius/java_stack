package net.brianlucius.save_travels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import net.brianlucius.save_travels.models.Expense;
import net.brianlucius.save_travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
}
