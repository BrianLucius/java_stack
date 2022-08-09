package net.brianlucius.booksproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.brianlucius.booksproject.models.Book;
import net.brianlucius.booksproject.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/books/{id}")
	public String showBook(@PathVariable(value="id") Long id, Model model) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping(value={"/","/books"})
	public String showAllBooks(Model model) {
		List<Book> books = bookService.allBooks();

		model.addAttribute("booksList", books);
		return "index.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook() {
		return "new.jsp";
	}
	
	@PostMapping("/books/add")
	public String addBook(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		bookService.createBook(book);
		
		return "redirect:/books";
	}
	
	
	
}
