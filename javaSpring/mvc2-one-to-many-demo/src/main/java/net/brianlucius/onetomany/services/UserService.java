package net.brianlucius.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.onetomany.models.User;
import net.brianlucius.onetomany.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> allUsers()
	{
		return userRepository.findAll();
	};
	
	public User oneUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
