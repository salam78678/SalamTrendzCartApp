package com.in.salamtrend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.salamtrend.dao.CustomerDAO;
import com.in.salamtrend.model.Customer;
import com.in.salamtrend.model.Items;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO dao;
	@Transactional
	@Override
	public Integer createOne(Customer customer) {
		System.out.println(" Customer " + customer);
		return dao.createOne(customer);
		
	}

	@Override
	public Integer createBulk(List<Customer> customer) {
		// TODO Auto-generated method stub
		return dao.createBulk(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getCustomerById(id);
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return dao.getCustomerList();
	}

	@Override
	public void update(Customer customer, Integer id) {
		dao.update(customer, id);
		
		
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public Items getItemsBymail(String mail) {
		// TODO Auto-generated method stub
		return dao.getItemsBymail(mail);
	}

	@Override
	public List<Items> getBulkItemsByMail(String mail) {
		// TODO Auto-generated method stub
		return dao.getBulkItemsByMail(mail);
	}

}
