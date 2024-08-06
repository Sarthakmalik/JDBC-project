package com.ibm.customer_management_project.service;

import com.ibm.customer_management_project.dao.AdminDao;
import com.ibm.customer_management_project.dto.Customer;

public class CustomerService {

	AdminDao dao = new AdminDao();

	public Customer getCustomerService(Customer customer) {
		if (customer.getName().length() <= 15) {
			return dao.addCustomerByAdminDao(customer);
		} else {
			System.out.println("Customer name should not be more than 15 characters ");
			return null;
		}
	}
}
