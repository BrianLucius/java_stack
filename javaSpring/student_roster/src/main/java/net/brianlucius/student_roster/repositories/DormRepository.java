package net.brianlucius.student_roster.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.student_roster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {

	List<Dorm> findAll();
	
}
