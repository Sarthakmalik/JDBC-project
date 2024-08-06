package com.ibm.customer_management_project.controller;

import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListCellRenderer;

import com.ibm.customer_management_project.dao.AdminDao;
import com.ibm.customer_management_project.dao.CustomerDao;
import com.ibm.customer_management_project.dto.Admin;
import com.ibm.customer_management_project.dto.Customer;
import com.ibm.customer_management_project.dto.Product;
import com.ibm.customer_management_project.service.AdminService;
import com.ibm.customer_management_project.service.CustomerService;
import com.ibm.customer_management_project.service.ProductService;

public class AdminController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AdminDao admin_dao = new AdminDao();
		AdminService service = new AdminService();

		CustomerDao customer_dao = new CustomerDao();
		CustomerService customer_service = new CustomerService();

		ProductService product_service = new ProductService();

		System.out.println("Enter the operation you want to perform ");
		while (true) {
			System.out
					.println("1.INSERT_ADMIN\n2.UPDATE_ADMIN\n3.DELETE_ADMIN\n4.LOGIN_ADMIN\n5.LOGIN_CUSTOMER\n6.EXIT");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				
				try {
					System.out.println("Enter the details of admin");
					System.out.println("Enter the Admin Id: ");
					int id = sc.nextInt();
					System.out.println("Enter the Admin Name: ");
					String name = sc.next();
					System.out.println("Enter the Admin Email: ");
					String email = sc.next();

					Admin admin = new Admin(id, name, email);

					Admin admin2 = service.getAdminService(admin);

					if (admin2 != null) {
						System.out.println("Data stored Successfully :)");
					} else {
						System.out.println("Data stored Failed :(");
					}
				} catch (Exception e) {
					System.out.println("Invalid Input try again..");
				}
				break;
			}
			case 2: {
				try {
					System.out.println("Enter the Admin id to update admin");
					int id = sc.nextInt();
					System.out.println("Enter new Admin Name to Update: ");
					String name = sc.next();
					System.out.println("Enter new Admin Email to Update: ");
					String email = sc.next();

					int a = admin_dao.upadateAdminByIdDao(id, name, email);
					if (a != 0) {
						System.out.println("Admin updated successfully... :)");
					} else {
						System.out.println("Admin updating failed... try again... :(");
					}

				} catch (Exception e) {
					System.out.println("Invalid Input try again..");
				}
				break;
			}
			case 3: {

				try {
					System.out.println("Enter the admin id to Delete: ");
					int id = sc.nextInt();
					int a = admin_dao.deleteAdminByIdDao(id);

					if (a != 0) {
						System.out.println("Admin Data deleted Successfully: ");
					} else {
						System.out.println("Given id is not found: ");
					}
				} catch (Exception e) {
					System.out.println("Invalid Input try again..");
				}
				break;
			}
			case 4: {

				try {
					System.out.println("Enter the Admin Name and Email to Login");
					System.out.println("Enter the Admin name :");
					String name = sc.next();
					System.out.println("Enter the Admin email: ");
					String email = sc.next();
					Admin admin = admin_dao.adminLogin(name, email);
					if (admin.getName().equalsIgnoreCase(name) && admin != null) {
						if (admin.getEmail().equalsIgnoreCase(email)) {
							System.out.println(admin.getName() + " Logged in Succesfully:) ");
							System.out.println();

							while (true) {

								System.out.println("1.ADD_CUSTOMER\n2.DELETE_CUSTOMER\n3.UPADATE_CUSTOMER\n4.LOGOUT");
								System.out.println("Enter your Choice: ");
								int option = sc.nextInt();
								switch (option) {
								case 1: {
									try {

										System.out.println("Enter Customer details to Add a Customer: ");
										System.out.println();
										System.out.println("Enter Customer id: ");
										int cid = sc.nextInt();
										System.out.println("Enter Customer Name: ");
										String cname = sc.next();
										System.out.println("Enter Customer Email: ");
										String cemail = sc.next();
										System.out.println("Enter Customer Phone: ");
										long phone = sc.nextLong();
										Customer customer = new Customer(cid, cname, cemail, phone);
										Customer customer2 = customer_service.getCustomerService(customer);
										if (customer2 != null) {
											System.out.println("Customer Added Successfully :)");
										} else {
											System.out.println("Customer Cannot Be Added  :) try again..");
										}
										System.out.println();

									} catch (Exception e) {
										System.out.println("Invalid Input try again...");
									}
									break;
								}
								case 2: {
									try {
										System.out.println("Enter Customer id to delete a customer:");
										int cid = sc.nextInt();
										int a = admin_dao.deleteCustomerByAdminDao(cid);
										if (a != 0) {
											System.out.println("Customer is deleted Successfully..");
										} else {
											System.out.println("Given customer id is not found try again..");
										}

									} catch (Exception e) {
										System.out.println("Enter the valid Input...");
									}
									break;
								}

								case 3: {
									try {
										System.out.println("Enter Customer id to Update Customer Info");
										int cid = sc.nextInt();
										System.out.println("Enter new Customer Name to Update: ");
										String cname = sc.next();
										System.out.println("Enter new Customer Email to Update");
										String cemail = sc.next();
										System.out.println("Enter new Customer Phone Number to Update");
										long clong = sc.nextLong();

										int a = admin_dao.updateCustomerByAdminDao(cid, cname, cemail, clong);
										if (a != 0) {
											System.out.println("Customer Data Update Successfully :)");
										} else {
											System.out.println("Given id is not found. Data Update Failed :( try again...");
										}
									} catch (Exception e) {
										System.out.println("Please Enter valid Data... try again...");
									}
									break;
								}

								case 4: {
									break;
								}
								default: {
									System.out.println("Invalid Input try again...");
								}

								}
								if (option == 4) {
									break;
								}
							}
						} else {
							System.out.println("Invalid email... :(");
						}
					} else {
						System.out.println("Incorrect Name!!!!!.. :(");
					}

				} catch (Exception e) {
					System.out.println("Invalid Input try again..");
				}
				break;
			}
			case 5: {

				try {
					System.out.println("Enter Customer name and email to login :-)");
					System.out.println();
					System.out.println("Enter the Customer name :");
					String name = sc.next();
					System.out.println("Enter the Customer email: ");
					String email = sc.next();
					Customer customer = customer_dao.customerLogin(name, email);
					if (customer.getName().equalsIgnoreCase(name) && customer != null) {
						if (customer.getEmail().equalsIgnoreCase(email)) {
							System.out.println(customer.getName() + " Logged in Succesfully:) ");
							while (true) {
								System.out.println(
										"1.ADD_PRODUCT\n2.UPDATE_PRODUCT\n3.DELETE_PRODUCT\n4.UPDATE_PRODUCT_PRICE\n5.UPDATE_PRODUCT_AVALIABLE\n6.DISPLAY_CUSTOMER_DETAILS\n7.DISPLAY_PRODUCT_DETAILS\n8.LOGOUT");
								System.out.println("Enter your Choice: ");
								int option = sc.nextInt();
								switch (option) {
								case 1: {
									try {

										System.out.println("Enter Product details to add a Product: ");
										System.out.println("Enter Product id: ");
										int pid = sc.nextInt();
										System.out.println("Enter Product Name: ");
										String pname = sc.next();
										System.out.println("Enter Product Price: ");
										double pprice = sc.nextDouble();
										System.out.println("Enter Product Availability: ");
										String avaliable = sc.next();
										Product product = new Product(pid, pname, pprice, avaliable, customer.getId());
										Product product2 = product_service.getProductService(product);
										if (product2 != null) {
											System.out.println("Product Added Successfully :)");
										} else {
											System.out.println("Product Cannot Be Added  :) try again..");
										}
										System.out.println();

									} catch (Exception e) {
										System.out.println("Invalid Input try again...");
									}
									break;
								}
								case 2: {
									try {
										System.out.println("Enter Product id to Update product Info");
										int pid = sc.nextInt();
										System.out.println("Enter new Product Name to Update: ");
										String pname = sc.next();
										System.out.println("Enter new Product Price to Update");
										double pprice = sc.nextDouble();
										System.out.println("Enter new Product availability(yes/no) to Update");
										String avaliable = sc.next();

										int a = customer_dao.updateProductByCustomer(pid, pname, pprice, avaliable,
												customer.getId());
										if (a != 0) {
											System.out.println("Product Data Update Successfully :)");
										} else {
											System.out.println(
													"Given id is not found. Data Updation Failed :( try again...");
										}
									} catch (Exception e) {
										System.out.println("Please Enter valid Data.. try again...");
									}
									break;
								}

								case 3: {
									try {
										System.out.println("Enter Product id to delete a product:");
										int pid = sc.nextInt();
										int a = customer_dao.deleteProductByCustomer(pid, customer.getId());
										if (a != 0) {
											System.out.println("Produt is deleted Successfully..");
										} else {
											System.out.println("Given product id is not found try again..");
										}

									} catch (Exception e) {
										e.printStackTrace();
										System.out.println("Enter the valid Input...");
									}

									break;
								}

								case 4: {
									try {

										System.out.println("Enter Product id to update the Product price: ");
										System.out.println();
										System.out.println("Enter PRoduct Id");
										int pid = sc.nextInt();
										System.out.println("Enter new Product Price to Upadate: ");
										double pprice = sc.nextDouble();
										int a = customer_dao.updateProductPriceByCustomer(pid, pprice,
												customer.getId());
										if (a != 0) {
											System.out.println("Produt price id updated Successfully..");
										} else {
											System.out.println(
													"Given product id is not found \nor \nyou are not allowed to change the price. \nplease try again...");
										}

									} catch (Exception e) {
										e.printStackTrace();
										System.out.println("Enter the valid Input...");
									}

									break;
								}
								case 5: {
									try {

										System.out.println("Enter Product Id to update Product avaliability: ");
										System.out.println("Enter Product id: ");
										int pid = sc.nextInt();
										System.out.println("Enter Product availability (yes/no) to update: ");
										String avaliable = sc.next();
										int a = customer_dao.updateProductavaliableByCustomer(pid, avaliable,
												customer.getId());
										if (a != 0) {
											System.out.println("Produt availability is updated Successfully..");
										} else {
											System.out.println(
													"Given product id is not found \nor \nyou are not allowed to change the product availability. \nplease try again...");
										}

									} catch (Exception e) {
										System.out.println("Enter the valid Input...");
									}

									break;
								}
								case 6: {

									System.out.println("Your id is : " + customer.getId());
									System.out.println("Your name is : " + customer.getName());
									System.out.println("Your email id is : " + customer.getEmail());
									System.out.println("Your phone number is : " + customer.getPhone());

									break;
								}
								case 7: {
									try {
										List<Product> products = customer_dao.getAllProductDetails(customer.getId());
										for (Product product : products) {
											System.out.println(product);
										}

									} catch (Exception e) {
										e.printStackTrace();
										System.out.println("Some Errros in products list.");

									}
									break;
								}
								default: {
									System.out.println("Invalid Input try again...");
								}
								}
								if (option == 8) {
									break;
								}
							}
						} else {
							System.out.println("Invalid email... :(");
						}
					} else {
						System.out.println("Incorrect Name!!!!!.. :(");
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("Invalid Input try again..");
				}
				break;
			}
			case 6: {
				System.out.println("Thank you :)\nBye...");
				System.exit(0);
				break;
			}
			default: {
				System.out.println("!!!OPP's you press an invalid key...try Again...");
			}
			}
		}
	}
}