package net.brianlucius.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.bookclub.models.Book;
import net.brianlucius.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book findBookById(Long id) {
		Optional<Book> book =  bookRepository.findById(id);
		if (!book.isPresent()) {
			return null;
		}
		return book.get();
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book editBook(Book book) {
		return bookRepository.save(book);
	}

}
