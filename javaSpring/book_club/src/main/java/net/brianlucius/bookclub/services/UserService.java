package net.brianlucius.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.brianlucius.bookclub.models.LoginUser;
import net.brianlucius.bookclub.models.User;
import net.brianlucius.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		// TO-DO: Additional Validations!
		// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email is already in use!");
		}

        // Reject if password doesn't match confirmation
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
        
        // Return null if result has errors
		if (result.hasErrors()) {
        	return null;
        } 
		
        // Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		// TO-DO: Additional Validations!
        // TO-DO - Reject values:
        
    	// Find user in the DB by email
		Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());
        // Reject if NOT present
		if(!potentialUser.isPresent()) {
//			result.rejectValue("email", "Matches", "There was an error logging you in. Check your username and password.");
			result.rejectValue("loginError", "Matches", "There was an error logging you in. Check your username and password.");
			return null;
		} 
        
        // Reject if BCrypt password match fails
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
//		    result.rejectValue("password", "Matches", "There was an error logging you in. Check your username and password.");
		    result.rejectValue("loginError", "Matches", "There was an error logging you in. Check your username and password.");
		}

		if(result.hasErrors()) {
    		return null;
    	}
		// Return null if result has errors
        // Otherwise, return the user object
		return user;
	}
	
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return null;
		}
		return user.get();
	}
	
}
