package com.efarmer.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.efarmer.model.CropStatus;
import com.efarmer.model.District;
import com.efarmer.model.Login;
import com.efarmer.service.DistrictService;

@RestController
@CrossOrigin(value= {"http://localhost:3000"})
public class DistrictController 
{
	@Autowired
	private DistrictService districtService;
	
	@PostMapping(value= {"/addDistrict"})
	public void insertDistrict(@RequestBody District district)
	{
		districtService.insertDistrict(district);
	}
	
	@GetMapping(value = {"/getDistrict"})
	public List<District> getDistrictdata()
	{
		System.out.println("Inside District");
		return districtService.getDistricts();
	}
	
	@GetMapping(value = {"/getDistrict/{id}"})
	public List<Login> getDistrictUsers(@PathVariable("id") int id)
	{
		return districtService.getUsers(id);
	}
}
