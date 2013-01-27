package com.patent.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.patent.bean.ConverterUtility;
import com.patent.bean.CustomerBean;
import com.patent.db.CustomerDaoBean;
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
	@Path("/create")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String createCustomer(CustomerBean customer){
		CustomerDaoBean newCustomerDBBean = ConverterUtility.getCustomerDaoBeanFromCustomerBean(customer);
		String customerId = null;
		try {
			customerId = customerDao.CreateCustomer(newCustomerDBBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerId;
	}

	@POST
	@Path("/update")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String editCustomer(CustomerBean customer){
		CustomerDaoBean updatedCustomerDBBean = ConverterUtility.getCustomerDaoBeanFromCustomerBean(customer);
		String customerId = null;
		try {
			customerId = customerDao.UpdateCustomer(updatedCustomerDBBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerId;
	}

	@GET
	@Path("/fetch/{id}")
	public CustomerBean getCustomer(@PathParam("id")String id) {
		CustomerDaoBean customerDBDetailsBean = null;
		CustomerBean customerDetailsBean = null;
		try {
			customerDBDetailsBean = customerDao.GetCustomer(id);
			customerDetailsBean = ConverterUtility.getCustomerBeanFromCustomerDaoBean(customerDBDetailsBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDetailsBean;
	}

	@GET
	@Path("/delete/{id}")
	public void deleteCustomer(@PathParam("id")String id) {
		try {
			customerDao.DeleteCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
