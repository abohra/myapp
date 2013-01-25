package com.patent.db;

import java.util.List;

import com.patent.bean.Customer;

public interface AbstractCustomerDao {
	public String CreateCustomer(Customer newCustomer) throws Exception;
	public int DeleteCustomer(String id) throws Exception;
	public Customer GetCustomer(String id) throws Exception;
	public String EditCustomer(Customer updatedCustomer) throws Exception;
	public List<Customer> ListOfCustomer() throws Exception;
}
