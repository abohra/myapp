package com.patent.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class DBManager {

	@Autowired
	@Qualifier("testDbDao")
	private AbstractDBDao dao;

	@Autowired
	@Qualifier("customerDao")
	private AbstractCustomerDao customerdao;

	public AbstractDBDao getDao() {
		return dao;
	}

	public void setDao(AbstractDBDao dao) {
		this.dao = dao;
	}

	public String createTest(DBBean bean) throws Exception {
		return dao.createTest(bean);
	}

	public void deleteTest(String id)throws Exception {
		dao.deleteTest(id);
	}

	public AbstractCustomerDao getCustomerDao(){
		return customerdao;
	}

	public void setCustomerDao(AbstractCustomerDao customerDao){
		this.customerdao = customerDao;
	}

	public String createCustomer(CustomerDaoBean newCustomer) throws Exception{
		return customerdao.CreateCustomer(newCustomer);
	}

	public String updateCustomer(CustomerDaoBean updatedCustomer) throws Exception{
		return customerdao.UpdateCustomer(updatedCustomer);
	}

	public int deleteCustomer(String id) throws Exception{
		return customerdao.DeleteCustomer(id);
	}
	public CustomerDaoBean getCustomer(String id) throws Exception{
		return customerdao.GetCustomer(id);
	}

	public List<CustomerDaoBean> listOfCustomer() throws Exception{
		return customerdao.ListOfCustomer();
	}
} 