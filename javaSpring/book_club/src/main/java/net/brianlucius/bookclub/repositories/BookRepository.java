package net.brianlucius.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.brianlucius.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
	Optional<Book> findById(Long id);
}
