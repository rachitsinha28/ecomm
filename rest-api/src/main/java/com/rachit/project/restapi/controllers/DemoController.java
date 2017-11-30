package com.rachit.project.restapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rachit.project.ecommerce.data.entities.Customer;
import com.rachit.project.ecommerce.data.entities.Product;
import com.rachit.project.ecommerce.data.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class DemoController {
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/save")
	public String saveCustomer(){
		Customer c = new Customer();
		c.setFirstName("Test");
		c.setLastName("test LAst");
		c.setAddress("nowhere");
		c.setWalletBalance(Long.valueOf(1000));
		List<Product> products =new ArrayList<>();
		Product p = new Product(null,"book","first book",1,20.0);
		products.add(p);
		c.setPurchasedProducts(products);
		customerRepository.save(c);
		return "done";
	}
	@RequestMapping("/all")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer){
		Customer cust = customerRepository.save(customer);
		return cust;
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public Customer addProduct(@RequestParam Integer id,@RequestBody List<Product> products){
		Customer customer = customerRepository.findOne(id);
		customer.setPurchasedProducts(products);
		customerRepository.save(customer);
		return customerRepository.findOne(id);
	}
	@RequestMapping("/product/{name}")
	public List<Customer> getCustomerByProductName(@PathVariable String name){
		return customerRepository.findByPurchasedProducts_Name(name);
	}
}
