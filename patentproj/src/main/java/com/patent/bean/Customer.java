package com.patent.bean;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@XmlRootElement (name = "customer")
@Entity
@Table(name = "customer")
public class Customer {
	private String customerId;
	private String firstname;
	private String lastname;
	private String emailaddress;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String pincode;
	private String mobilenumber;

	public Customer(){

	}

	public Customer(String firstname, String lastname, String emailaddress,
			String addressline1, String addressline2, String city,
			String state, String pincode, String mobilenumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobilenumber = mobilenumber;
	}

	public Customer(String jsonString){
		Customer existingCustomer = CreateObjFromJSON(jsonString);
		this.customerId = existingCustomer.customerId;
		this.firstname = existingCustomer.firstname;
		this.lastname = existingCustomer.lastname;
		this.emailaddress = existingCustomer.emailaddress;
		this.addressline1 = existingCustomer.addressline1;
		this.addressline2 = existingCustomer.addressline2;
		this.city = existingCustomer.city;
		this.state = existingCustomer.state;
		this.pincode = existingCustomer.pincode;
		this.mobilenumber = existingCustomer.mobilenumber;
	}

	@Id
	@Column
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column
	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	@Column
	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	@Column
	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
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
	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String toJSONString(){
		ObjectMapper mapper = new ObjectMapper();
		String objInJsonFormat = new String();

		try {
			objInJsonFormat = mapper.writeValueAsString(this);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objInJsonFormat;
	}
	
	public Customer CreateObjFromJSON(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Customer user = null;
		try {
			user = mapper.readValue(jsonString, Customer.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
