package com.patent.rest;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.patent.bean.ConverterUtility;
import com.patent.bean.CustomerBean;
import com.patent.bean.CustomerList;
import com.patent.db.AbstractCustomerDao;
import com.patent.db.CustomerDaoBean;

@Component
@Path("/customer")
public class CustomerResource {

	private AbstractCustomerDao customerDao;

	public AbstractCustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	public void setCustomerDao(AbstractCustomerDao customerDao) {
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
	@Path("/update/{id}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String editCustomer(@PathParam("id")String id,CustomerBean customer){
		CustomerDaoBean updatedCustomerDBBean = ConverterUtility.getCustomerDaoBeanFromCustomerBean(customer);
		updatedCustomerDBBean.setCustomerId(id);
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
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
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
	public String deleteCustomer(@PathParam("id")String id) {
		String numRowsDeleted = null;
		try {
			numRowsDeleted= customerDao.DeleteCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numRowsDeleted;
	}
	@GET
    @Path("allCustomers/")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public CustomerList listOfUser() throws Exception {
   	  return new CustomerList(new ArrayList<CustomerDaoBean> (customerDao.ListOfCustomer()));
	/*	List<CustomerDaoBean> cust = new ArrayList<CustomerDaoBean>();
		CustomerDaoBean bean = new CustomerDaoBean("Ankur", "ankur@admin.com", "123", "abc");
		cust.add(bean);
		bean = new CustomerDaoBean("Amit", "amit@admin.com", "567", "xyz");
		cust.add(bean);
		bean = new CustomerDaoBean("Arya", "arya@admin.com", "765", "pop");
		cust.add(bean);
		return new CustomerList(cust);
		*/
		
    }
}
