package com.rachit.project.ecommerce.data.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rachit.project.ecommerce.data.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public List<Customer> findByFirstName(String firstName);
	
	public List<Customer> findByFirstNameAndLastName(String firstName,String lastName);
	
	public List<Customer> findByPurchasedProducts_Name(String name);
}
