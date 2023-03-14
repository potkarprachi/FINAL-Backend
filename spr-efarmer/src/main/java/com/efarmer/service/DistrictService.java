package com.efarmer.service;

import java.util.List;

import com.efarmer.model.District;
import com.efarmer.model.Login;

public interface DistrictService 
{
	void insertDistrict(District district);
	List<District> getDistricts();
	List<Login> getUsers(int id);
}
