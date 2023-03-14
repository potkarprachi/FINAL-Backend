package com.efarmer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;

@Entity
public class CropStatus
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cropID;
	@ManyToOne
	@JoinColumn(name="fk_farmer_id")
	private Login farmerNo;
//	@Column(name="cropId")
//	int cropId;
	@Column(name="cropName",length=20)
	String cropName;
	@Column(name="cropCategory")
	int cropCategoryID;
	@Column(name="weight")
	float weight;
	@Column(name="status",length=10)
	String status;
	@Column(name="price")
	float price;
	@ManyToOne
	@JoinColumn(name="fk_customer_id")
	private Login customerNo;
	
	

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public int getCropCategoryID() {
		return cropCategoryID;
	}
	public void setCropCategoryID(int cropCategoryID) {
		this.cropCategoryID = cropCategoryID;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getCropID() {
		return cropID;
	}
}

/*
{
    "farmerId":1,
    "cropName":"Rice",
    "cropCategoryID":25,
    "weight":1000,
    "customerid":20,
    "price"300
}
*/
