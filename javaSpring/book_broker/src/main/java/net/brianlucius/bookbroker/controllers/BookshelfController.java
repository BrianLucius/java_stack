package net.brianlucius.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import net.brianlucius.bookbroker.models.Book;
import net.brianlucius.bookbroker.models.User;
import net.brianlucius.bookbroker.services.BookService;
import net.brianlucius.bookbroker.services.UserService;

@Controller
public class BookshelfController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	// ----- Main Page -----	
    @GetMapping("/books")
    public String home(HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	List<Book> booksList = bookService.allBooks();
    	
    	model.addAttribute("booksList", booksList);
    	return "dashboard.jsp";
    }
    
    // ----- Book Market Page -----
    @GetMapping("/bookmarket")
    public String market(HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	List<Book> booksList = bookService.availableBooks();
    	model.addAttribute("booksList", booksList);
    	
    	List<Book> borrowedList = userService.getUserById((Long) session.getAttribute("user_id")).getBorrowed();
    	model.addAttribute("borrowedList", borrowedList);
    	
    	return "bookmarket.jsp";
    }
    
    // ----- Show one book -----
    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Book book = bookService.findBookById(id);
    	model.addAttribute("book", book);
    	return "showBook.jsp";
    }
    
    // ----- Add book -----
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
    	User user = userService.getUserById((Long) session.getAttribute("user_id"));
    	book.setPostedBy(user);
    	bookService.createBook(book);
    	return "redirect:/books";
    }
    
    // ----- Edit Book -----
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
    public String processEditBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "editBook.jsp";
    	}
    	Book editBook = bookService.findBookById(id);
//    	User user = userService.getUserById((Long) session.getAttribute("user_id"));
    	book.setPostedBy(editBook.getPostedBy());
    	book.setBorrowedBy(editBook.getBorrowedBy());
    	bookService.createBook(book);
    	return "redirect:/books/"+id;
    }
    
    // ----- Delete Book -----
    @DeleteMapping("/books/edit/{id}")
    public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(!session.getAttribute("user_id").equals(bookService.findBookById(id).getPostedBy().getId())) {
    		return "redirect:/books";	
    	}
    	bookService.deleteBook(id);
    	return "redirect:/books";
    }
    
    // ----- Borrow and Return Book -----
    @PutMapping("/books/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Book borrowedBook = bookService.findBookById(id);
    	borrowedBook.setBorrowedBy(userService.getUserById((Long) session.getAttribute("user_id")));
    	bookService.editBook(borrowedBook);
    	return "redirect:/bookmarket";
    }
    
    @PutMapping("/books/return/{id}")
    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Book borrowedBook = bookService.findBookById(id);
    	borrowedBook.setBorrowedBy(null);
    	bookService.editBook(borrowedBook);
    	return "redirect:/bookmarket";
    }
}
