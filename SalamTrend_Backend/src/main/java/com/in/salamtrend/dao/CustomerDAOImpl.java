package com.in.salamtrend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in.salamtrend.model.Customer;
import com.in.salamtrend.model.Items;
@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionfactory;
	private Session session = sessionfactory.openSession();
	Transaction tx=null;

	@Override
	public Integer createOne(Customer customer) {
		try {
			tx=session.beginTransaction();
			int id=(int) session.save(customer);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
		
		return (Integer) sessionfactory.getCurrentSession().save(customer);
		
	}

	@Override
	public Integer createBulk(List<Customer> customer) {
		
		for (Customer customer2 : customer) {
			sessionfactory.getCurrentSession().save(customer2);
		}
		return 200; 
	}

	@Override
	public Customer getCustomerById(Integer id) {
		
		
		return sessionfactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public List<Customer> getCustomerList() {
		Session session = sessionfactory.openSession();
		List<Customer>customer=(List<Customer>) session.createCriteria(Customer.class).list();
		//Criteria criteria=sessionfactory.getCurrentSession().createCriteria(Customer.class);
		System.out.println("----- List of Customer-----");
		System.out.println(customer);
		// session.flush is used for clear cache in the session
		session.flush();
		// it will close the particular session after completing the process
		session.close();
		return customer;
	}

	@Override
	public void update(Customer customer, Integer id) {
	    sessionfactory.getCurrentSession().merge(customer);

	}

	@Override
	public void delete(Integer id) {
	 Customer customer=getCustomerById(id);
	 sessionfactory.getCurrentSession().delete(customer);

	}

	@Override
	public Items getItemsBymail(String mail) {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().get(Items.class, mail);
	}

	@Override
	public List<Items> getBulkItemsByMail(String mail) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		List<Items> item=(List<Items>) session.createCriteria(Items.class);
		System.out.println("----- List<Items>-----");
		System.out.println(item);
		// session.flush is used for clear cache in the session
		session.flush();
		// it will close the particular session after completing the process
		session.close();
		return item;

	}

}
