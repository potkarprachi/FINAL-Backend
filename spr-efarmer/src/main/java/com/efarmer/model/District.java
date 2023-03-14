package com.efarmer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Entity
@Table(name = "districTable")
public class District 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="districtId")
	int districtId;
	@Column(name="district",length = 20)
	String district;
	
//	@OneToOne
//	@JoinColumn(name="district")
//	private Login login;
	
	@OneToMany(mappedBy = "districts")
	private List<Login> login;
	
//	public List<Login> getLogin() {
//		return login;
//	}
//	public void setLogin(List<Login> login) {
//		this.login = login;
//	}
	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", district=" + district + "]";
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getDistrictId() {
		return districtId;
	}
	
	
	
}
