package net.brianlucius.logregdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.brianlucius.logregdemo.models.LoginUser;
import net.brianlucius.logregdemo.models.User;
import net.brianlucius.logregdemo.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
    private UserRepo userRepo;
    
    public User register(User newUser, BindingResult result) {
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	if (optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "This email is already in use.");
    	}
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "matches", "Your passwords do not match");
    	}
    	if (result.hasErrors()) {
    		return null;
    	}
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "Email is not registered.");
    		return null;
    	}
    	User user = potentialUser.get();
    	
    	if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid password");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        return user;
    }
    
    public User oneUser(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	}
    	return null;
    	}

}

