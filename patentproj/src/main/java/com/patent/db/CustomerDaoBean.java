package com.patent.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table (name = "customer")
public class CustomerDaoBean implements Serializable {
	private String customerId;
	private String customerName;
	private String emailAddress;
	private String contactNumber;
	private String address;
	
	public CustomerDaoBean(){
		
	}
	
	public CustomerDaoBean(String customerName, String emailAddress,
			String contactNumber, String address) {
		super();
		this.customerName = customerName;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	@Id
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Column
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Column
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
