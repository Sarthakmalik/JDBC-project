package com.ibm.customer_management_project.dto;

import java.util.Objects;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private long phone;
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 */
	public Customer(int id, String name, String email, long phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param product
	 */
	
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& phone == other.phone;
	}
	
	
	
	
	

}
