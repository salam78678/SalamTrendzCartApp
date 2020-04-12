package com.in.salamtrend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.salamtrend.exception.MyResourceNotFoundException;
import com.in.salamtrend.model.Items;
import com.in.salamtrend.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemsController {
	@Autowired
	private ItemService service;

	@GetMapping("/{all}")
	public ResponseEntity<List<Items>> getAllItems() throws MyResourceNotFoundException {
		List<Items> list = service.getItemsList();

		return new ResponseEntity<List<Items>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{itemId}")
	public ResponseEntity<Items> getItemById(@PathVariable("id") Integer id) throws MyResourceNotFoundException {
		Items entity = service.getItemsById(id);

		return new ResponseEntity<Items>(entity, new HttpHeaders(), HttpStatus.OK);
	}
    
	@PostMapping("/saveItems")
	public Integer saveOne(Items items)
			throws MyResourceNotFoundException {
		return  service.createOne(items);
		
	}
	@PostMapping("/saveBulkItems")
	public Integer saveBulk(List<Items> items)
			throws MyResourceNotFoundException {
		return service.createBulk(items);
		
	}
	

	@DeleteMapping("/{deleteItemById}")
	public HttpStatus deleteItemById(@PathVariable("id") Integer id) throws MyResourceNotFoundException{
		service.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
