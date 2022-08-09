package net.brianlucius.booksproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.brianlucius.booksproject.models.Book;
import net.brianlucius.booksproject.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/books/{id}")
	public String showBook(@PathVariable(value="id") Long id, Model model) {
		Book book = bookService.findBook(id);

//		model.addAttribute("title", book.getTitle());
//		model.addAttribute("description", book.getDescription());
//		model.addAttribute("language", book.getLanguage());
//		model.addAttribute("numberOfPages", book.getNumberOfPages());
		
		model.addAttribute("book", book);
		return "show.jsp";
	}
}
