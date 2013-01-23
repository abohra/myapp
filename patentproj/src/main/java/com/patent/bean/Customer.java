package com.patent.bean;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XmlRootElement (name = "customer")
@Entity
@Table(name = "customer")
public class Customer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pincode;
	private String phoneNumber;
	@Id
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Column
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@Column
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	@Column
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Column
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
