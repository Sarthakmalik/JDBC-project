package com.ibm.customer_management_project.dto;

import java.util.Objects;

public class Admin {
	
	private int id;
	private String name;
	private String email;
	private Customer customer;
	
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param email
	 */
	public Admin(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param customer
	 */
	public Admin(int id, String name, String email, Customer customer) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(customer, email, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", customer=" + customer + "]";
	}
	
	

}
