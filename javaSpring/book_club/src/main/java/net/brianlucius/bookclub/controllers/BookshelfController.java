package net.brianlucius.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.brianlucius.bookclub.models.Book;
import net.brianlucius.bookclub.models.User;
import net.brianlucius.bookclub.services.BookService;
import net.brianlucius.bookclub.services.UserService;

@Controller
public class BookshelfController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/books")
    public String home(HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	List<Book> booksList = bookService.allBooks();
    	
    	model.addAttribute("booksList", booksList);
    	return "dashboard.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Book book = bookService.findBookById(id);
    	model.addAttribute("book", book);
    	return "showBook.jsp";
    }
    
    @GetMapping("/books/new") 
    public String addBook(Model model, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Book book = new Book();
    	model.addAttribute("book", book);
    	return "addBook.jsp";
    }
    
    @PostMapping("/books/new") 
    public String processBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "addBook.jsp";
    	}
    	User user = userService.getOneById((Long) session.getAttribute("user_id"));
    	book.setPostedBy(user);
    	bookService.createBook(book);
    	return "redirect:/books";
    }
    
    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}  
    	Book editBook = bookService.findBookById(id);
    	if (!session.getAttribute("user_id").equals(editBook.getPostedBy().getId())){
    		return "redirect:/books";
    	}
    	model.addAttribute("book", editBook);
    	return "editBook.jsp";
    }
    
    @PutMapping("/books/edit/{id}")
    public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "editBook.jsp";
    	}
    	User user = userService.getOneById((Long) session.getAttribute("user_id"));
    	book.setPostedBy(user);
    	bookService.createBook(book);
    	return "redirect:/books/"+id;
    }
}
