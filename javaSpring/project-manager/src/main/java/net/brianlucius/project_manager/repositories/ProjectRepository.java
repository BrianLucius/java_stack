package net.brianlucius.project_manager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.project_manager.models.Project;
import net.brianlucius.project_manager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findAll();
	Optional<Project> findById(Long id);
	List<Project> findByTeamMembersNotContaining(User user);
	List<Project> findByTeamMembers(User user);
}
