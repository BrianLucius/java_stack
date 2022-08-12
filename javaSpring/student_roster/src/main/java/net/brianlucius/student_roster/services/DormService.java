package net.brianlucius.student_roster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.student_roster.models.Dorm;
import net.brianlucius.student_roster.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	private DormRepository dormRepository;
	
	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}
	
	public Dorm saveDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	public Dorm getDormById(Long id) {
		Optional<Dorm> dormList =  dormRepository.findById(id);
		if(dormList.isPresent()) {
			return  dormList.get();
		}
		return null;
	}
}
