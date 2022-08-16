package net.brianlucius.project_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.project_manager.models.Project;
import net.brianlucius.project_manager.models.User;
import net.brianlucius.project_manager.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> allProject() {
		return projectRepository.findAll();
	}
	
	public Project findProjectById(Long id) {
		Optional<Project> project = projectRepository.findById(id);
		if (!project.isPresent()) {
			return null;
		}
		return project.get();
	}
	
    public List<Project> allProjects(User user) {
    	return projectRepository.findByTeamMembersNotContaining(user);
    }
    
    public List<Project> myProjects(User user) {
    	return projectRepository.findByTeamMembers(user);
    }
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteById(Long id) {
		projectRepository.deleteById(id);
	}

}
