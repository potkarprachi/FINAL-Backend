package com.efarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmer.dao.CropStatusDao;
import com.efarmer.dao.TransactionDao;
import com.efarmer.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	TransactionDao transactionDao;
	@Override
	public void insert(Transaction t) 
	{
		t.setStatus("Paid");
		transactionDao.save(t);
	}

	@Override
	public List<Transaction> fetchForCustomer(int id) {
		// TODO Auto-generated method stub
		return transactionDao.allCustomerTans(id);
	}

	@Override
	public List<Transaction> fetchForFarmer(int id) {
		// TODO Auto-generated method stub
		return transactionDao.allFarmerTans(id);
	}

	@Override
	public List<Transaction> fetchAll() {
		// TODO Auto-generated method stub
		return transactionDao.findAll();
	}

}
