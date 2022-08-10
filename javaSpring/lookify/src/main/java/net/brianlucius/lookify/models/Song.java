package net.brianlucius.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="song")
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=5, max=255, message="Song title must be more than 5 charaters")
	private String title;
	@NotNull
	@Size(min=5, max=255, message="Artist must be more than 5 characters")
	private String artist;
	@NotNull
	@Min(value=1, message="Rating must be between 1 and 10")
	@Max(value=10, message="Rating must be between 1 and 10")
	private int rating;	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Song() {
	}

	public Song(String title, String artist, Integer rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public Integer getRating() {
		return rating;
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

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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
