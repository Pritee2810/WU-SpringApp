package com.westernunion.spring.dao;

import java.util.ArrayList;

import com.westernunion.spring.entity.Customer;

public interface CustomerDAO {
	public ArrayList<Customer> getCustomer();

	public void addCustomer(Customer theCustomer);


	public Customer getOneCustomer(int theId);

	ArrayList<Customer> getOneCustomer();

	public void deleteCustomer(int theId);

	
}
