package com.in.salamtrend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in.salamtrend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	@Query("select name from Customer where mail=?")
	public Customer findCustomerByMail( String mail);
	@Query("insert into Customer values(?,?,?,?)")
	public  String createbulkOrderByMail(Integer orderId);

}
