package com.patent.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.patent.bean.Customer;

public class CustomerDaoImpl implements AbstractCustomerDao{

	private SessionFactory sessionFactory;
	
	public String CreateCustomer(Customer newCustomer) throws Exception {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(newCustomer);
		}finally{
			if(session != null){
				session.close();
			}
		}
		return newCustomer.getCustomerId();
	}

	public int DeleteCustomer(String id) throws Exception {
		Session session = null;
		int numRowsDeleted=0;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			numRowsDeleted = session.createQuery(
					"delete from Customer customerBean where customerBean.customerId = ?")
					.setString(0, id)
					.executeUpdate();
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return numRowsDeleted;
	}

	public Customer GetCustomer(String id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return (Customer) session.get(Customer.class,id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public String EditCustomer(Customer updatedCustomer) throws Exception {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.saveOrUpdate(updatedCustomer);
		}finally{
			if(session != null){
				session.close();
			}
		}
		return updatedCustomer.getCustomerId();
	}

	public List<Customer> ListOfCustomer() throws Exception {
		Session session = null;
		List<Customer> listOfCustomer = null;
		try{
			session = sessionFactory.openSession();
			listOfCustomer = (List<Customer>)session.createQuery("FROM Customer").list();
		} finally{
			if(session != null){
				session.close();
			}
		}
		return listOfCustomer;
	}
}
