package com.in.salamtrend.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.salamtrend.model.Customer;
import com.in.salamtrend.services.CustomerServices;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerServices services;
	@GetMapping("/id")
	public Customer findCustomerById(@PathVariable @Valid Integer id) {
		return services.get(id);
		
	}
	@GetMapping("/mail")
	public Customer findByMail(@PathVariable @Valid String mail) {
		return services.findCustomerByMail(mail);
		
	}
	@PostMapping("/saveBulk")
	public void createBulk(@RequestBody @Valid List<Customer> customer) {
		services.saveBulk(customer);
		
	}


}
