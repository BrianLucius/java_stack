package net.brianlucius.project_manager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.project_manager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findAll();
	List<Task> findByProjectIdOrderByCreatedAtDesc(Long id);
}
