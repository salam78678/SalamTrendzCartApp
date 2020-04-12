package com.in.salamtrend.dao;

import java.util.List;

import com.in.salamtrend.model.Customer;
import com.in.salamtrend.model.Items;
public interface CustomerDAO {
	public Integer createOne(Customer customer);
	public Integer createBulk(List<Customer> customer);
	public Customer getCustomerById(Integer id);
	public Items getItemsBymail(String mail);
	public List<Items> getBulkItemsByMail(String mail);
	List<Customer>getCustomerList();
	public void update(Customer customer,Integer id);
	void delete(Integer id);
}
