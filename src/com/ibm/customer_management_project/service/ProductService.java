package com.ibm.customer_management_project.service;

import com.ibm.customer_management_project.dao.CustomerDao;
import com.ibm.customer_management_project.dto.Product;

public class ProductService {

	CustomerDao cd = new CustomerDao();

	public Product getProductService(Product product) {
		if (product.getPprice() <= 7000) {
			if (product.getAvaliable().equalsIgnoreCase("Yes") || product.getAvaliable().equalsIgnoreCase("Yes")) {
				return cd.addProductByCustomer(product);
			} else {
				System.out.println("Product avaliable should be Yes or No.");
				return null;
			}
		} else {
			System.out.println("Product price should not be more than 7000.");
			return null;
		}
	}
}
