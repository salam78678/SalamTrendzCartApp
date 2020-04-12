package com.in.salamtrend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.salamtrend.model.Customer;
import com.in.salamtrend.model.Items;
import com.in.salamtrend.repository.CustomerRepository;
@Service
public class CustomerServices {
	@Autowired
	private CustomerRepository repo;
	public List<Customer> listAll() {
        return repo.findAll();
    }
     
    public void saveOne(Customer customer) {
        repo.save(customer);
    }
    public void saveBulk(List<Customer> customer) {
    	repo.saveAll(customer);
    }
     
    public Customer get(Integer id) {
        return repo.findById(id).get();
    }
    public Customer findCustomerByMail(String mail) {
    	return repo.findCustomerByMail(mail);
    }
    public void insertBulk(Integer id) {
    	repo.createbulkOrderByMail(id);
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }


}
