package com.in.salamtrend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.salamtrend.exception.MyResourceNotFoundException;
import com.in.salamtrend.model.Customer;
import com.in.salamtrend.service.CustomerService;
//@Api(value = "Swagger2DemoRestController", description = "REST APIs related to  Entity!!!!")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/{findAll}")
	public ResponseEntity<List<Customer>> getAllEmployees() {
		List<Customer> list = service.getCustomerList();

		return  ResponseEntity.ok().body(list);
	}

	@GetMapping("/{custId}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable("id") Integer id) throws MyResourceNotFoundException {
		Customer customer = service.getCustomerById(id);

		return ResponseEntity.ok().body(customer);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveOne( @Valid @RequestBody(required = false) Customer customer) throws MyResourceNotFoundException {
		 service.createOne(customer);
		return ResponseEntity.ok().body(customer);
	}
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@PostMapping("/savebulk")
	public ResponseEntity<List<Customer>> savebulk( @Valid @RequestBody(required = false) List<Customer> customer) throws MyResourceNotFoundException {
		 service.createBulk(customer);
		return ResponseEntity.ok().body(customer);
	}

	@DeleteMapping("/{deleteCustById}")
	public HttpStatus deleteCustomerById(@PathVariable("id") Integer id) throws MyResourceNotFoundException {
		service.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
