package com.in.salamtrend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in.salamtrend.model.Items;
@Repository
@Transactional

public class ItemsDAOImpl implements ItemsDAO {
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public Integer createOne(Items item) {
		
		return (Integer) sessionfactory.getCurrentSession().save(item);
	}

	@Override
	public Integer createBulk(List<Items> item) {
		
		return (Integer) sessionfactory.getCurrentSession().save(item);
	}

	@Override
	public Items getItemsById(Integer id) {
		
		return sessionfactory.getCurrentSession().get(Items.class, id);
	}

	@Override
	public List<Items> getItemsList() {
		Criteria criteria=sessionfactory.getCurrentSession().createCriteria(Items.class);
		return criteria.list();
	}

	@Override
	public void update(Items items) {
		sessionfactory.getCurrentSession().merge(items);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		Items items=getItemsById(id);
		sessionfactory.getCurrentSession().delete(items);
		
	}

	@Override
	public Items getItemsByName(String name) {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().get(Items.class, name);
	}

}
