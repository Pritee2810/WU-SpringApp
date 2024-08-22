package com.westernunion.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.westernunion.spring.dao.CustomerDAO;
import com.westernunion.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	public CustomerDAO customerDAO;
	
	public CustomerController(CustomerDAO thecustomer) {
		this.customerDAO = thecustomer;
	}
		@RequestMapping("/list")
		public String getCustomer(Model modelObj) {
			ArrayList<Customer> customers =this.customerDAO.getCustomer();
			System.out.println(customers);
			modelObj.addAttribute("custData", customers);
			return "list-customers";
		}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//creating the model attribute to bind with form data
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		System.out.println("inside showformforadd");
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerDAO.addCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int theId, Model theModel) {
		
		System.out.println("Inside ShowFormForUpdate !!!");
		Customer oneCustomer= customerDAO.getOneCustomer(theId);
		theModel.addAttribute("customer", oneCustomer);
		
		//Customer bindCustomer= new Customer();
		theModel.addAttribute("boundCustomer",oneCustomer );
		
		
		
		return "update-form";
		
	}
	@PostMapping("/updateCustomerDetails")
	public String updateDetails(@ModelAttribute("boundCustomer") Customer theCustomer) {
		customerDAO.addCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerID") int theId) {
		customerDAO.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

}
