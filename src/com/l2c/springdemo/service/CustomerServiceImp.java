package com.l2c.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l2c.springdemo.dao.CustomerDao;
import com.l2c.springdemo.entity.Customer;
@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerDao customerDao;
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		return customerDao.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
		
	}
	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		
		return customerDao.getCustomer(theId);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
		
	}

}
