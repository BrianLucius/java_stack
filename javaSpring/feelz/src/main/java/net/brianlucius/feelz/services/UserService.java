package net.brianlucius.feelz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.brianlucius.feelz.models.LoginUser;
import net.brianlucius.feelz.models.User;
import net.brianlucius.feelz.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email is already in use!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
        	return null;
        } 
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
//			result.rejectValue("email", "Matches", "There was an error logging you in. Check your username and password.");
			result.rejectValue("loginError", "Matches", "There was an error logging you in. Check your username and password.");
			return null;
		} 
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
//		    result.rejectValue("password", "Matches", "There was an error logging you in. Check your username and password.");
		    result.rejectValue("loginError", "Matches", "There was an error logging you in. Check your username and password.");
		}

		if(result.hasErrors()) {
    		return null;
    	}
		return user;
	}
	
	public User updateUser(User user, BindingResult result) {
    	User editUser = getUserById(user.getId());
    	
    	if(!editUser.getEmail().equals(user.getEmail())) {
    		Optional<User> potentialUser = userRepository.findByEmail(user.getEmail());
    		if(potentialUser.isPresent()) {
    			result.rejectValue("email", "Matches", "The email is already in use!");
    		}
    	}
    	
    	if(!editUser.getPassword().equals(user.getPassword()) || !user.getPassword().equals(user.getConfirm())) {
    		if(!user.getPassword().equals(user.getConfirm())) {
    		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    		} else {
	    		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	    		user.setPassword(hashed);
    		}
    	}
    	if (result.hasErrors()) {
    		return user;
    	}   	
		return userRepository.save(user);

	}
	
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return null;
		}
		return user.get();
	}
	
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
