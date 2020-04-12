package com.in.salamtrend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.in.salamtrend.model.Items;
import com.in.salamtrend.repository.ItemRepository;
@Service
public class ItemServices {
	@Autowired
	private ItemRepository repo;
     
	    public List<Items> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Items items) {
	        repo.save(items);
	    }
	     
	    public Items get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }

	
}
