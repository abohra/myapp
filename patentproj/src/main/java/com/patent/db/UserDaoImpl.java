package com.patent.db;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoImpl implements AbstractUserDao {
	
private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String createUser(User newUser) throws Exception {
		String userId = generateUserId();
		newUser.setUserId(userId);
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(newUser);
			session.getTransaction().commit();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return newUser.getUserId();
	}

	@Override
	public void deleteUser(String id) throws Exception {
		Session session = null;
		//int numRowsDeleted=0;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.createQuery(
					"delete from User user where user.userId = ?")
					.setString(0, id)
					.executeUpdate();
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public User getUser(String id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return (User) session.get(User.class,id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public String editUser(User updatedUser) throws Exception {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(updatedUser);
			session.getTransaction().commit();
		}
		finally{
			if(!session.equals(null)){
				session.close();
			}
				
		}
		return updatedUser.getUserId();
	}

	@Override
	public List<User> listOfUser() throws Exception {
		Session session = null;
		List<User> listOfUser = null;
		try{
			session = sessionFactory.openSession();
			listOfUser = (List<User>)session.createQuery("FROM User").list();
		} finally{
			if(session != null){
				session.close();
			}
		}
		return listOfUser;
	}

	public String generateUserId()
	{
		return UUID.randomUUID().toString();
	}
}
