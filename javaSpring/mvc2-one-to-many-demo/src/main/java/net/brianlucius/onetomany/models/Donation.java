package net.brianlucius.onetomany.models;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="donations")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String donationName;
	
	@NotNull
	private String quantity;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User donor;
	
	public Donation() {
	}
	
	
	public Long getId() {
		return id;
	}


	public String getDonationName() {
		return donationName;
	}



	public String getQuantity() {
		return quantity;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public User getDonor() {
		return donor;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}



	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public void setDonor(User donor) {
		this.donor = donor;
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
