package net.brianlucius.student_roster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.student_roster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();
}
