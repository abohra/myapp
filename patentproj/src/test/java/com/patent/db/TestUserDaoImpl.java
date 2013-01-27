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
public class TestUserDaoImpl {
	AbstractXmlApplicationContext context;
	static protected AbstractUserDao userDao;

	@BeforeMethod
	public void setup() throws Exception {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	@AfterMethod
	public void destroy() {
		context.destroy();
	}

	public static AbstractUserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public  void setDao(@Qualifier("userDao") AbstractUserDao userDao) {
		TestUserDaoImpl.userDao = userDao;
	}


	@BeforeClass
	public void setupClass() throws Exception {

	} 

	@Test
	public void testUserCreateAndGet() throws Exception {
		User user = new User("Ankur","Bohra","abc@xyz.com","1234567890","Pune","Operator");
		String id1 = userDao.createUser(user);
		Assert.assertNotNull(userDao.getUser(id1));
		
	}

	@Test
	public void testUserDelete() throws Exception {
		User user = new User("Ankur","Bohra","abc@xyz.com","1234567890","Pune","Operator");
		String id1 = userDao.createUser(user);
		System.out.println("User Object *********************:"+userDao.getUser(id1));
		Assert.assertNotNull(userDao.getUser(id1));
		userDao.deleteUser(id1);
		Assert.assertNull(userDao.getUser(id1));
	}

}
