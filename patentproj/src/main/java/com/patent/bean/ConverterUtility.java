package com.patent.bean;

import com.patent.db.CustomerDaoBean;
import com.patent.db.DBBean;

public class ConverterUtility {

	public static DBBean getDBBeanFromTestBean(TestBean testBean)	{
		DBBean dbBean = new DBBean();
		dbBean.setV1(testBean.getObject1());
		dbBean.setV2(testBean.getObject2());
		return dbBean;
	}

	public static TestBean getTestBeanFromDBBean(DBBean dbBean) {
		TestBean testBean = new TestBean();
		testBean.setObject1(dbBean.getV1());
		testBean.setObject2(dbBean.getV2());
		return testBean;
	}

	public static CustomerDaoBean getCustomerDaoBeanFromCustomerBean(CustomerBean customerBean){
		CustomerDaoBean customerDBBean = new CustomerDaoBean();
		customerDBBean.setAddress(customerBean.getAddress());
		customerDBBean.setContactNumber(customerBean.getContactNumber());
		customerDBBean.setCustomerId(customerBean.getCustomerId());
		customerDBBean.setCustomerName(customerBean.getCustomerName());
		customerDBBean.setEmailAddress(customerBean.getEmailAddress());
		return customerDBBean;
	}
	
	public static CustomerBean getCustomerBeanFromCustomerDaoBean(CustomerDaoBean customerDaoBean){
		CustomerBean customerBean = new CustomerBean();
		customerBean.setAddress(customerDaoBean.getAddress());
		customerBean.setContactNumber(customerDaoBean.getContactNumber());
		customerBean.setCustomerId(customerDaoBean.getCustomerId());
		customerBean.setCustomerName(customerDaoBean.getCustomerName());
		customerBean.setEmailAddress(customerDaoBean.getEmailAddress());
		return customerBean;
	}
}
