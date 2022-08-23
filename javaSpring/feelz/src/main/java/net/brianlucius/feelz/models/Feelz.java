package net.brianlucius.feelz.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "feelz")
public class Feelz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=64)
	private String uniqueBrowserId;
	
	@Size(max=15)
	private String browserIp;
	
	@Size(max=128)
	private String browserLocation;
	
	@NotNull
	private Integer mood;
	
	@Size(min=3, max=15, message="Your word must be between 3 and 15 characters")
	private String emotion;
	
	@Column(updatable = false)
	private Date createDate;
	private Date updateDate;
	
	public Feelz() {
	}

	public Long getId() {
		return id;
	}

	public String getUniqueBrowserId() {
		return uniqueBrowserId;
	}

	public String getBrowserIp() {
		return browserIp;
	}

	public String getBrowserLocation() {
		return browserLocation;
	}

	public Integer getMood() {
		return mood;
	}

	public String getEmotion() {
		return emotion;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUniqueBrowserId(String uniqueBrowserId) {
		this.uniqueBrowserId = uniqueBrowserId;
	}

	public void setBrowserIp(String browserIp) {
		this.browserIp = browserIp;
	}

	public void setBrowserLocation(String browserLocation) {
		this.browserLocation = browserLocation;
	}

	public void setMood(Integer mood) {
		this.mood = mood;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@PrePersist
	protected void onCreate() {
		this.createDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updateDate = new Date();
	}

}
