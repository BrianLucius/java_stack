package net.brianlucius.mvcdemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="donations")
public class Donation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=3, max=255)
    private String donationName;
	@NotNull
	@Min(0)
	private Integer quantity;
	@NotNull
	@Size(min=2, max=50)
	private String donor;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
		
	// constructors
	public Donation() {
	}

	public Donation(String donationName, Integer quantity, String donor) {
		this.donationName = donationName;
		this.quantity = quantity;
		this.donor = donor;
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public String getDonationName() {
		return donationName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getDonor() {
		return donor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
