package net.brianlucius.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Title is required")
	@Size(min=3, max=90, message="Title must be between 3 and 90 characters")
	private String title;
	
	@NotEmpty(message="Author is required")
	@Size(min=3, max=30, message="Author must be between than 3 and 30 characters")
	private String author;
	
	@NotEmpty(message="Message is required")
	@Size(min=3, max=255, message="Title must be between 3 and 255 characters")
	private String comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User postedBy;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Book() {}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getComments() {
		return comments;
	}

	public User getPostedBy() {
		return postedBy;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
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
