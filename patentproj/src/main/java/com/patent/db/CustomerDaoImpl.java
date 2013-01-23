package com.patent.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.patent.bean.Customer;

public class CustomerDaoImpl implements AbstractCustomerDao{

	private SessionFactory sessionFactory;
	
	public String CreateCustomer(Customer newCustomer) {
		Session sess = null;
		try {
			sess = sessionFactory.openSession();
			sess.beginTransaction();
			sess.saveOrUpdate(newCustomer);

			sess.getTransaction().commit();
		} finally {
			if (sess != null) {
				sess.close();
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
		// TODO Auto-generated method stub
		return null;
	}

}
