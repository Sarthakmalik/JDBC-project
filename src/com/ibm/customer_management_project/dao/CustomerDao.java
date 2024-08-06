package com.ibm.customer_management_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibm.customer_management_project.connection.ConnectionProvider;
import com.ibm.customer_management_project.dto.Customer;
import com.ibm.customer_management_project.dto.Product;

public class CustomerDao {

	Connection connection = ConnectionProvider.geTheConnection();
	private final String customer_login = "select * from customer where name=? or email=?";
	private final String add_product_by_customer = "insert into product(pid, pname, pprice, pavaliable, cid) values(?,?,?,?,?)";
	private final String update_product_by_customer = "update product set pname=?, pprice=?, pavaliable=? where pid=? and cid=?";
	private final String delete_product_by_customer = "delete from product where pid=? and cid=?";
	private final String update_product_price_by_customer = "update product set pprice=? where pid=? and cid=?";
	private final String updateProduct_avaliable_by_customer = "update product set pavaliable=? where pid=? and cid=?";
	private final String display_customer_details = "select * from customer where cid=?";
	private final String display_product_details = "select * from product where cid=?";

	public Customer customerLogin(String name, String email) {
		Customer customer = null;
		try {
			PreparedStatement ps = connection.prepareStatement(customer_login);
			ps.setString(1, name);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String cname = rs.getString("name");
				String cemail = rs.getString("email");
				long phone = rs.getLong("phone");
				customer = new Customer(id, cname, cemail, phone);
			}
			return customer;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product addProductByCustomer(Product product) {
		try {
			PreparedStatement ps = connection.prepareStatement(add_product_by_customer);
			ps.setInt(1, product.getPid());
			ps.setString(2, product.getPname());
			ps.setDouble(3, product.getPprice());
			ps.setString(4, product.getAvaliable());
			ps.setInt(5, product.getCid());
			ps.execute();

			return product;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int updateProductByCustomer(int id, String name, double price, String avaliable, int cid) {
		try {
			PreparedStatement ps = connection.prepareStatement(update_product_by_customer);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setString(3, avaliable);
			ps.setInt(4, id);
			ps.setInt(5, cid);

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteProductByCustomer(int id, int cid) {
		try {
			PreparedStatement ps = connection.prepareStatement(delete_product_by_customer);
			ps.setInt(1, id);
			ps.setInt(2, cid);
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateProductPriceByCustomer(int id, double price, int cid) {
		try {
			PreparedStatement ps = connection.prepareStatement(update_product_price_by_customer);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			ps.setInt(3, cid);

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateProductavaliableByCustomer(int id, String avaliable, int cid) {
		try {
			PreparedStatement ps = connection.prepareStatement(updateProduct_avaliable_by_customer);
			ps.setString(1, avaliable);
			ps.setInt(2, id);
			ps.setInt(3, cid);

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Customer getCustomerDetails(int cid) {
		Customer customer = null;
		try {
			PreparedStatement ps = connection.prepareStatement(display_customer_details);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");

				customer = new Customer(id, name, email, phone);
			}
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> getAllProductDetails(int cid) {
		try {
			PreparedStatement ps = connection.prepareStatement(display_product_details);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while (rs.next()) {
				int id = rs.getInt("pid");
				String name = rs.getString("pname");
				double price = rs.getDouble("pprice");
				String avaliable = rs.getString("pavaliable");

				Product product = new Product(id, name, price, avaliable);
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}