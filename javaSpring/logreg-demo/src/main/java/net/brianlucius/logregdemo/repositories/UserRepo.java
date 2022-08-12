package net.brianlucius.logregdemo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.brianlucius.logregdemo.models.User;

public interface UserRepo extends CrudRepository<User, Long> {

	//search for the email/account
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
}
