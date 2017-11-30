package com.rachit.project.ecommerce.data.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String firstName;
	private String lastName;
	private String Address;
	private Long walletBalance;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> purchasedProducts;
	public Customer(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Product> getPurchasedProducts() {
		return purchasedProducts;
	}
	public void setPurchasedProducts(List<Product> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Long getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(Long walletBalance) {
		this.walletBalance = walletBalance;
	}
	
}
