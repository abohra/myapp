package com.patent.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.patent.bean.Customer;
import com.patent.db.CustomerDaoImpl;

@Component
@Path("/customer")
public class CustomerResource {

	private CustomerDaoImpl customerDao;

	public CustomerDaoImpl getCustomerDao() {
		return customerDao;
	}

	@Autowired
	public void setCustomerDao(@Qualifier("customerDao") CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}

	@POST
	@Path("/newCustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createCustomer(String jsonCustomer){
		Customer newCustomer = new Customer(jsonCustomer);
		String customerId = null;
		try {
			customerId = customerDao.CreateCustomer(newCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerId;
	}
	
	@POST
	@Path("/editCustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String editCustomer(String jsonCustomer){
		Customer updatedCustomer = new Customer(jsonCustomer);
		String customerId = null;
		try {
			customerId = customerDao.EditCustomer(updatedCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerId;
	}
	
	@GET
	@Path("/getCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@FormParam("customerId") String customerId) {
		Customer customerDetails = null;
		try {
			customerDetails = customerDao.GetCustomer(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDetails;
	}

	@GET
	@Path("/deleteCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public int deleteCustomer(@FormParam("customerId") String customerId) {
		int numRowsDeleted = 0;
		try {
			numRowsDeleted = customerDao.DeleteCustomer(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numRowsDeleted;
	}
}
