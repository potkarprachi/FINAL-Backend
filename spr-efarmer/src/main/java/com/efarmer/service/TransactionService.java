package com.efarmer.service;

import java.util.List;

import com.efarmer.model.Transaction;

public interface TransactionService 
{
	void insert(Transaction t);
	List<Transaction> fetchForCustomer(int id);
	List<Transaction> fetchForFarmer(int id);
	List<Transaction> fetchAll();
}
