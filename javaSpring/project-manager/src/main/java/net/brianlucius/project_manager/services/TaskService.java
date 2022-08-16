package net.brianlucius.project_manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.project_manager.models.Task;
import net.brianlucius.project_manager.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired TaskRepository taskRepository;
	
	public List<Task> allTasks() {
		return taskRepository.findAll();
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public List<Task> tasksForProject(Long id) {
		return taskRepository.findByProjectIdOrderByCreatedAtDesc(id);
	}
}
