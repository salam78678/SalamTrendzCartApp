package com.in.salamtrend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.salamtrend.dao.ItemsDAO;
import com.in.salamtrend.model.Items;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsDAO dao;

	@Transactional
	@Override
	public Integer createOne(Items item) {
		return dao.createOne(item);

	}

	@Override
	public Integer createBulk(List<Items> item) {
		// TODO Auto-generated method stub
		return dao.createBulk(item);
	}

	@Override
	public Items getItemsById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getItemsById(id);
	}

	@Override
	public List<Items> getItemsList() {
		// TODO Auto-generated method stub
		return dao.getItemsList();
	}

	@Override
	public void update(Items items, Integer id) {
		dao.update(items);

	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);

	}

	@Override
	public Items getItemsByName(String name) {
		return dao.getItemsByName(name);
	}

}
