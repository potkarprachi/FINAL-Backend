package com.efarmer.cntr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.efarmer.model.Transaction;
import com.efarmer.service.CropStatusService;
import com.efarmer.service.TransactionService;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
public class TransactionController 
{
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CropStatusService cropStatusService;
	
	@PostMapping(value = {"/addTransaction"})
	public String addTranaction(@RequestBody Transaction t)
	{
		cropStatusService.updateCustomer(t.getCropID(), t.getCustomerNo());
		transactionService.insert(t);
		return "success";
	}
	
	@GetMapping(value = {"/getAllTransactions1"})
	public List<Transaction> getAllTrans()
	{
		System.out.println("Inside Get All");
		List<Transaction> list=new ArrayList<Transaction>();
		list= transactionService.fetchAll();
		for(Transaction t : list)
		{
			System.out.println(t.getCustomerNo());
			System.out.println(t.getDate());
		}
		return list;
	}
	
	@GetMapping(value = {"/getAllTransactionFarmer/{id}"})
	public List<Transaction> getAllId(@PathVariable("id") int id)
	{
		return transactionService.fetchForFarmer(id);
	}
	
	@GetMapping(value = {"/getAllTransactionCust/{id}"})
	public List<Transaction> getAllIdCust(@PathVariable("id") int id)
	{
		return transactionService.fetchForCustomer(id);
	}
}
