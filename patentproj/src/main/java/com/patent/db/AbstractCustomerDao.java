package com.patent.db;

import java.util.List;

public interface AbstractCustomerDao {
	public String CreateCustomer(CustomerDaoBean newCustomer) throws Exception;
	public String DeleteCustomer(String id) throws Exception;
	public CustomerDaoBean GetCustomer(String id) throws Exception;
	public String UpdateCustomer(CustomerDaoBean updatedCustomer) throws Exception;
	public List<CustomerDaoBean> ListOfCustomer() throws Exception;
}
