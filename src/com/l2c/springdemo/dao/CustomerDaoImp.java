package com.l2c.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.l2c.springdemo.entity.Customer;
@Repository
public class CustomerDaoImp implements CustomerDao {
	//need to inject the session factory
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by firstname",Customer.class);
		
		List<Customer> listcustomers=theQuery.getResultList();
		
		return listcustomers;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
		
	}



	@Override
	public Customer getCustomer(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer =currentSession.get(Customer.class,theId);
		return theCustomer;
	}



	@Override
	public void deleteCustomer(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class, theId);
		currentSession.delete(theCustomer);
	}

}
