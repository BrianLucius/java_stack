package net.brianlucius.save_travels.services;

import java.util.List;
import java.util.Optional;

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
	
	public Expense getOneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
