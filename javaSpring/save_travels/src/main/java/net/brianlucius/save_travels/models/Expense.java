package net.brianlucius.save_travels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="expense")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=5, max=200, message="Expense name must be more than 5 characters")
	private String expenseName;
	@NotNull
	@Size(min=3, max=200, message="Vendor name must be more than 3 characters")
	private  String vendor;
	@NotNull
	@DecimalMin(value="0.01", message="Expense must be at least $0.01")
	private Double amount;
	@NotNull
	@Size(min=5, max=200, message="Description must be more than 5 characters")
	private String description;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Expense() {
	}

	public Expense(String expenseName, String vendor, Double amount, String description) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public String getVendor() {
		return vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
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

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
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
