package net.brianlucius.logregdemo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.logregdemo.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	//search for the email/account
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
}
