package com.l2c.springdemo.service;

import java.util.List;

import com.l2c.springdemo.entity.Customer;

public interface CustomerService {

public List<Customer> getCustomer();

public void saveCustomer(Customer theCustomer);

public Customer getCustomers(int theId);

public void deleteCustomer(int theId);

}
