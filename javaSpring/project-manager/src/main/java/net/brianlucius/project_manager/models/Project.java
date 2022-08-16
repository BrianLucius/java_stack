package net.brianlucius.project_manager.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// add columns here
	// @NotEmpty(message="Title is required")
	// @Size(min=3, max=90, message="Title must be between 3 and 90 characters")
	// private String title;
	
	@NotEmpty(message="Project name is required")
	@Size(min=3, max=90, message="Project name must be between 3 and 90 characters")
	private String projectName;
	
	@NotEmpty(message="Description is required")
	@Size(min=3, max=255, message="Description must be between 3 and 255 characters")
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message="Due date must be in the future")
	@NotNull(message="Due date is required")
	private Date dueDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamLeadUserId")
	private User teamLead;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "projects_users",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> teamMembers;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	public Project() {
		teamMembers = new ArrayList<User>();
	}

	public Long getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getDescription() {
		return description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public User getTeamLead() {
		return teamLead;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public List<User> getTeamMembers() {
		return teamMembers;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setTeamLead(User teamLead) {
		this.teamLead = teamLead;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
