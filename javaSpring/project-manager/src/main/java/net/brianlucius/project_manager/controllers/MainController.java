package net.brianlucius.project_manager.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.brianlucius.project_manager.models.Project;
import net.brianlucius.project_manager.models.Task;
import net.brianlucius.project_manager.models.User;
import net.brianlucius.project_manager.services.ProjectService;
import net.brianlucius.project_manager.services.TaskService;
import net.brianlucius.project_manager.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	            new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	@GetMapping("/dashboard")
	public String mainPage(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		User user = userService.getUserById((Long) session.getAttribute("user_id"));
		
		List<Project> allProjectsList = projectService.allProjects(user);
		List<Project> myProjectsList = projectService.myProjects(user);
		model.addAttribute("allProjectsList", allProjectsList);
		model.addAttribute("myProjectsList", myProjectsList);
		model.addAttribute("loggedInUser", user);
		return "dashboard.jsp";
	}
	
	// ----- New Project -----
	@GetMapping("/projects/new")
	public String renderAdd(HttpSession session, @ModelAttribute("project") Project project) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "newProject.jsp";
	}
	
	@PostMapping("/projects/new")
	public String processAdd(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
    		return "newProject.jsp";
    	}
		User user = userService.getUserById((Long) session.getAttribute("user_id"));
    	project.setTeamLead(user);	
    	project.getTeamMembers().add(user);		
		return "redirect:/dashboard";
	}
	
	// ----- Edit Project -----
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, @ModelAttribute("project") Project project, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	} 
		Project editProject = projectService.findProjectById(id);
		if(!session.getAttribute("user_id").equals(editProject.getTeamLead().getId())) {
			return "redirect:/dashboard";
		}
		model.addAttribute("project", editProject);
		return "editProject.jsp";
	}
	
	@PutMapping("/projects/edit/{id}")
    public String processEditProject(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "editProject.jsp";
    	}
    	User user = userService.getUserById((Long) session.getAttribute("user_id"));
    	project.setTeamLead(user);
    	projectService.updateProject(project);
    	return "redirect:/dashboard";
    }
	
	// ----- Delete Project -----
	@DeleteMapping("/projects/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
		// TODO: Add delete tasks for project before deleting project
		projectService.deleteById(id);
		return "redirect:/dashboard";
	}
	
	// ----- Show Project -----
	@GetMapping("/projects/{id}")
	public String showOne(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Project showProject = projectService.findProjectById(id);
		model.addAttribute("project", showProject);
		return "showProject.jsp";
	}
	
	// ----- Join Project -----
	@PutMapping("/projects/join/{id}")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Project currentProject = projectService.findProjectById(id);
		User user = userService.getUserById((Long) session.getAttribute("user_id"));
		currentProject.getTeamMembers().add(user);
		projectService.updateProject(currentProject);
		return "redirect:/dashboard";
	}
	
	// ----- Leave Project -----
	@PutMapping("/projects/leave/{id}")
	public String leave(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Project currentProject = projectService.findProjectById(id);
		User user = userService.getUserById((Long) session.getAttribute("user_id"));
		currentProject.getTeamMembers().remove(user);
		userService.updateUser(user);
		projectService.updateProject(currentProject);
		return "redirect:/dashboard";
	}
	
	// ----- Project Tasks -----
	@GetMapping("/projects/{id}/tasks")
	public String showTasks(@PathVariable("id") Long id, @ModelAttribute("newTask") Task task, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Project project = projectService.findProjectById(id);
		List<Task> listTasks = taskService.tasksForProject(id);
		model.addAttribute("project", project);
		model.addAttribute("listTasks", listTasks);
		return "showTasks.jsp";
	}
	
	@PostMapping("/projects/{projId}/tasks")
	public String addTask(@PathVariable("projId") Long projId, @Valid @ModelAttribute("newTask") Task task, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Project project = projectService.findProjectById(projId);
			List<Task> listTasks = taskService.tasksForProject(projId);
			model.addAttribute("project", project);
			model.addAttribute("listTasks", listTasks);
			return "showTasks.jsp";
		}
		Project project = projectService.findProjectById(projId);
		// TODO: Add ManyToOne from tasks to users to store user as reference instead of static value
		task.setUserName((String) session.getAttribute("username"));
		task.setProject(project);
		taskService.createTask(task);
		return "redirect:/projects/"+projId+"/tasks";
	}

}
