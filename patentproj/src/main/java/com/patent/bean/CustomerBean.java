package com.patent.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="customer")
public class CustomerBean {
	private String customerId;
	private String customerName;
	private String emailAddress;
	private String contactNumber;
	private String address;
	
	public CustomerBean(){
		
	}
	
	public CustomerBean(String customerId,String customerName,String emailAddress,String contactNumber,String address){
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	@XmlElement
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@XmlElement
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@XmlElement
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@XmlElement
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
