package com.efarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmer.dao.DistrictDao;
import com.efarmer.model.District;
import com.efarmer.model.Login;
@Service
public class DistrictServiceImpl implements DistrictService
{
	
	@Autowired
	private DistrictDao districtDao;
	
	@Override
	public void insertDistrict(District district)
	{
		districtDao.save(district);
	}

	@Override
	public List<District> getDistricts()
	{
		return districtDao.findAll();		
	}

	@Override
	public List<Login> getUsers(int id) {
		// TODO Auto-generated method stub
		return districtDao.getAllCrops(id);
	}

}
