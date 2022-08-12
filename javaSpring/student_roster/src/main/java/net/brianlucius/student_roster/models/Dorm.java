package net.brianlucius.student_roster.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "dorms")
public class Dorm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Dorm name connot be empty")
	private String dormName;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	@OneToMany(mappedBy = "dorm", fetch = FetchType.LAZY)
	private List<Student> students;

	public Dorm() {
	}

	public Long getId() {
		return id;
	}

	public String getDormName() {
		return dormName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
