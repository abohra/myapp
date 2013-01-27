package com.patent.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Component 
public class TestCustomerDaoImpl {
	AbstractXmlApplicationContext context;
	static protected AbstractCustomerDao customerDao;

	@BeforeMethod
	public void setup() throws Exception {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	@AfterMethod
	public void destroy() {
		context.destroy();
	}

	public static AbstractCustomerDao getDao() {
		return customerDao;
	}

	@Autowired
	public  void setDao(@Qualifier("customerDao") AbstractCustomerDao dao) {
		TestCustomerDaoImpl.customerDao= dao;
	}


	@BeforeClass
	public void setupClass() throws Exception {

	} 
	@Test
	public void customerDBcreateAndGetCustomer() throws Exception {
		Assert.assertNotNull(customerDao);
		CustomerDaoBean beanCustomer1 = new CustomerDaoBean("test","test@test.com","999999","hyd");
		System.out.println(beanCustomer1.getCustomerName());
		String id1 = customerDao.CreateCustomer(beanCustomer1);
		Assert.assertNotNull(id1);
	}

//	@Test
//	public void testDBDelete() throws Exception {
//		DBBean bean = new DBBean("hello","amit");
//		String id = dao.createTest(bean);
//		Assert.assertNotNull(dao.getTestBean(id));
//		dao.deleteTest(id);
//		Assert.assertNull(dao.getTestBean(id));
//	}
}
