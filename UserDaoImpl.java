package org.simplilearn.dao;

import org.simplilearn.config.HibConfig;
import org.simplilearn.lms.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx =null;
		try {
			
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public User get(String username, String password) {
		
		try {
			
		
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("select u from org.simplilearn.lms.entities.User u where u.username = ?1 and u.password = ?2");
		query.setParameter(1,username);
		query.setParameter(2,password);
		return (User)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void update(User user) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx =null;
		try {
			
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
