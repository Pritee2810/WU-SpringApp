package com.westernunion.spring.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.westernunion.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	private SessionFactory sessionFactory;
	private Customer customer;
	
	public CustomerDAOImpl(SessionFactory theSessionFactory) {
		this.sessionFactory=theSessionFactory;
	}
	
	@Override
	@Transactional
	public ArrayList<Customer> getCustomer(){
		/*ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer c1=new Customer(56, "Manasi", "Yadav", "my@gmail.com");
		Customer c2=new Customer(57, "Pratyush", "Singh", "ps@gmail.com");
		Customer c3=new Customer(58, "Pritee", "Ghumare", "pg@gmail.com");			//without database
		
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		return customers;
		
		*/
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Customer", Customer.class);   			//HQL (with database)
		
		ArrayList<Customer> customers=(ArrayList<Customer>) theQuery.getResultList();
		return customers;
		
	}
	
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
		
	}
	
	@Override
	@Transactional
	public ArrayList<Customer> getOneCustomer(){
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		ArrayList<Customer> customers=(ArrayList<Customer>) theQuery.getResultList();
				
		return customers;

	}

	@Override
	@Transactional
	public Customer getOneCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer=currentSession.get(Customer.class, theId);
		
		return customer;
	}
	@Transactional
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Customer where cId=:ID");
		theQuery.setParameter("ID", theId);
		theQuery.executeUpdate();
	}
	
	
}
