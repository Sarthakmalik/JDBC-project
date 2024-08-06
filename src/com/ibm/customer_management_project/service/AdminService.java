package com.ibm.customer_management_project.service;

import com.ibm.customer_management_project.dao.AdminDao;
import com.ibm.customer_management_project.dto.Admin;

public class AdminService {

	AdminDao dao = new AdminDao();

	public Admin getAdminService(Admin admin) {

		if (admin.getName().length() <= 8) {
			return dao.saveAdminDao(admin);
		} else {
			System.out.println("Admin name should not be more than 8 characters ");
			return null;
		}
	}
}
