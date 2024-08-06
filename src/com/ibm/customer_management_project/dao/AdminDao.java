package com.ibm.customer_management_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibm.customer_management_project.connection.ConnectionProvider;
import com.ibm.customer_management_project.dto.Admin;
import com.ibm.customer_management_project.dto.Customer;

public class AdminDao {
	
	Connection connection=ConnectionProvider.geTheConnection();
	
	private final String insert_admin="insert into admin(id, name, email) values(?,?,?)";
	private final String update_admin="update admin set name=?, email=? where id=?";
	private final String delete_admin="delete from admin where id=?";
	private final String login_admin="select * from admin where name=? or email=?";
	private final String add_customer_by_admin="insert into customer(id, name, email, phone) values(?,?,?,?);";
	private final String delete_customer_by_admin="delete from customer where id=?";
	private final String update_customer_by_admin="update customer set name=? , email=?, phone=? where id=?";
	
	public Admin saveAdminDao(Admin admin)
	{
		try {
			
			PreparedStatement ps=connection.prepareStatement(insert_admin);
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getEmail());
			
			ps.execute();
			return admin;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int upadateAdminByIdDao(int id, String name, String email)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(update_admin);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, id);
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteAdminByIdDao(int id)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(delete_admin);
			ps.setInt(1, id);
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Admin adminLogin(String name, String email)
	{
		Admin admin=null;
		try {
			PreparedStatement ps=connection.prepareStatement(login_admin);
			ps.setString(1, name);
			ps.setString(2, email);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt("id");
				String name1=rs.getString("name");
				String email1=rs.getString("email");
				
				admin=new Admin(id, name1, email1);
			}
			return admin;	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public Customer addCustomerByAdminDao(Customer customer)
	{
		try {
			
			PreparedStatement ps=connection.prepareStatement(add_customer_by_admin);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			
			ps.execute();
			return customer;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteCustomerByAdminDao(int id)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(delete_customer_by_admin);
			ps.setInt(1, id);
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateCustomerByAdminDao(int id, String name, String email, long phone)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(update_customer_by_admin);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, phone);
			ps.setInt(4, id);
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
