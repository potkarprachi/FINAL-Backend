package com.efarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmer.dao.CropStatusDao;
import com.efarmer.model.CropStatus;
import com.efarmer.model.Login;

@Service
public class CropStatusServiceImpl implements CropStatusService
{

	@Autowired
	private CropStatusDao cropStatusDao;
	
	@Override
	public void insertCrop(CropStatus crop) 
	{
		crop.setStatus("Pending");
		cropStatusDao.save(crop);
	}

	@Override
	public List<CropStatus> getAllCropsById(int farmerID) 
	{
		// TODO Auto-generated method stub
		return cropStatusDao.getAllCrops(farmerID,"CANCELLED");
	}

	@Override
	public Integer cancelCS(int id,String status) 
	{
		// TODO Auto-generated method stub
		return cropStatusDao.changeStatus(id,status);

	}

	@Override
	public Integer updateStatus(int id, String status) {
		// TODO Auto-generated method stub
		return cropStatusDao.updateStatus(id, status);
	}

	@Override
	public List<CropStatus> getAllCrops(String status) 
	{
		return cropStatusDao.getAllCrop(status);
	}

	@Override
	public List<CropStatus> menuPageCrops(String status) {
		
		return cropStatusDao.allowedToSell(status);
	}

	@Override
	public void updateCustomer(int cropID, Login customer)
	{
		cropStatusDao.updateCustomer(cropID, customer.getID());
		
	}

	@Override
	public CropStatus getSingleCrop(int id)
	{
		return cropStatusDao.findByIdCrop(id);
	}
}
