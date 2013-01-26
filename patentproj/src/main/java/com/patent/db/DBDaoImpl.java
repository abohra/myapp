package com.patent.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class DBDaoImpl implements AbstractDBDao {
	
	private static int counter = 1;

	private SessionFactory sessionFactory;

	public String createTest(DBBean bean) throws Exception {
		String id = generateId();
		bean.setId(id);
		Session sess = null;
		try {
			sess = sessionFactory.openSession();
			sess.beginTransaction();
			sess.saveOrUpdate(bean);

			sess.getTransaction().commit();
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		return bean.getId();
	}
 
	private String generateId() {
		return String.valueOf(counter++);
	}

	public void deleteTest(String id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			int numDeleted = session.createQuery(
					"delete from DBBean test where test.id = ?")
					.setString(0, id)
					.executeUpdate();
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DBBean getTestBean(String id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return (DBBean) session.get(DBBean.class,id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}

