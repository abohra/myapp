package com.patent.bean;

import java.util.List;
import com.patent.db.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customerList")
public class CustomerList {

	public List<CustomerDaoBean> listOfCustomer;

	public CustomerList() {

	}

	public CustomerList(List<CustomerDaoBean> customers) {
		this.listOfCustomer = customers;
	}

	@XmlElement
	public List<CustomerDaoBean> getUsers() {
		return listOfCustomer;
	}

	public void setUsers(List<CustomerDaoBean> customers) {
		this.listOfCustomer = customers;
	}
}
