package com.in.salamtrend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.salamtrend.exception.MyResourceNotFoundException;
import com.in.salamtrend.model.Items;
import com.in.salamtrend.service.CustomerService;
import com.in.salamtrend.service.ItemService;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private ItemService ItemService;
	@Autowired
	private CustomerService CustService;
	@GetMapping("/id")
	public Items createOrder(@PathVariable("itemsId")Integer itemsId)throws MyResourceNotFoundException {
		return ItemService.getItemsById(itemsId);
		
	}
	@GetMapping("/{item}")
	public List<Items> createBulkOrder(@PathVariable("item") Items item){
		return ItemService.getItemsList();
	}
	@GetMapping("/{mail}")
	public Items createOrderByMail(@PathVariable("mail") String mail){
		return  CustService.getItemsBymail(mail);
	}
	@GetMapping("/{mails}")
	public List<Items>createBulkOrderByMail(@PathVariable("mails")String mails){
		return CustService.getBulkItemsByMail(mails);
	}
	

}
