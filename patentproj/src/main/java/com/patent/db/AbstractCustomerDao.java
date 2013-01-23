package com.patent.db;

import com.patent.bean.Customer;

public interface AbstractCustomerDao {
	public String CreateCustomer(Customer newCustomer);
	public int DeleteCustomer(String id) throws Exception;
	public Customer GetCustomer(String id) throws Exception;
	public String EditCustomer(Customer updatedCustomer) throws Exception;	
}
