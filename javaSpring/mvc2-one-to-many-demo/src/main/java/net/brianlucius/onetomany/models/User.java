package net.brianlucius.onetomany.models;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="donor", fetch = FetchType.LAZY)
	private List<Donation> donation;
	
	public User() {
	}
	
	
	public Long getId() {
		return id;
	}



	public String getUsername() {
		return username;
	}



	public String getEmail() {
		return email;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public List<Donation> getDonation() {
		return donation;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public void setDonation(List<Donation> donation) {
		this.donation = donation;
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
