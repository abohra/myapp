package com.myapp.bean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="customer")
public class Customer {
	//member variables
	private String fName;
	private String lName;
	private String custId;
	private String contactNo;
	private String address;
	//getters and setter
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustId() {
		return custId;
	}

}
