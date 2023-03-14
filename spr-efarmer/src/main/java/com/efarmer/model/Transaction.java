package com.efarmer.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="transactions")
public class Transaction 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int transactionId;
	@Column(name="amount")
	float price;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	Calendar date;
	@Column(name="status",length=10)
	String status;
	@ManyToOne
	@JoinColumn(name="fk_farmer_id")
	private Login farmerNo;
	@ManyToOne
	@JoinColumn(name="fk_customer_id")
	private Login customerNo;
	@Column(name="crop")
	int cropID;
	public CropStatus getCropStatus() {
		return cropStatus;
	}
	public void setCropStatus(CropStatus cropStatus) {
		this.cropStatus = cropStatus;
	}
	@Column(name="weight")
	float weight;
	
	@OneToOne
	@JoinColumn(name="fk_cropid")
	private CropStatus cropStatus;
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCropID() {
		return cropID;
	}
	public void setCropID(int cropID) {
		this.cropID = cropID;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public Login getFarmerNo() {
		return farmerNo;
	}
	public void setFarmerNo(Login farmerNo) {
		this.farmerNo = farmerNo;
	}
	public Login getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Login customerNo) {
		this.customerNo = customerNo;
	}
	
	
}
