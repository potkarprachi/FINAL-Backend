package com.efarmer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.efarmer.model.Transaction;

@Repository
public interface TransactionDao extends CrudRepository<Transaction,Integer>,JpaRepository<Transaction, Integer>
{
	@Query(value="SELECT * FROM transactions WHERE fk_farmer_id=:q ORDER BY date desc",nativeQuery = true)
	List<Transaction> allFarmerTans(@Param(value="q") int id);
	
	@Query(value="SELECT * FROM transactions WHERE fk_customer_id=:q ORDER BY date desc",nativeQuery = true)
	List<Transaction> allCustomerTans(@Param(value="q") int id);
	
	
	
}
