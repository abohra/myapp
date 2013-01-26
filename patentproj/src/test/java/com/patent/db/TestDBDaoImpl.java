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
public class TestDBDaoImpl { 

	AbstractXmlApplicationContext context;
	static protected AbstractDBDao dao;

	@BeforeMethod
	public void setup() throws Exception {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	@AfterMethod
	public void destroy() {
		context.destroy();
	}

	public static AbstractDBDao getDao() {
		return dao;
	}

	@Autowired
	public  void setDao(@Qualifier("testDbDao") AbstractDBDao dao) {
		TestDBDaoImpl.dao = dao;
	}


	@BeforeClass
	public void setupClass() throws Exception {

	} 

	@Test
	public void testDBcreateAndGet() throws Exception {
		DBBean bean = new DBBean("1","hello",10);
		String id = dao.createTest(bean);
		Assert.assertNotNull(dao.getTestBean("1"));
		Assert.assertEquals(id, "1", "invalid id");
	}

	@Test
	public void testDBDelete() throws Exception {
		DBBean bean = new DBBean("1","hello",10);
		String id = dao.createTest(bean);
		Assert.assertNotNull(dao.getTestBean(id));
		dao.deleteTest(id);
		Assert.assertNull(dao.getTestBean("1"));
	}

}
