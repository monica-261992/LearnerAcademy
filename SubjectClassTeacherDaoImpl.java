package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.config.HibConfig;
import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.SubjectClassTeacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SubjectClassTeacherDaoImpl implements SubjectClassTeacherDao{

	@Override
	public void insert(SubjectClassTeacher obj) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SubjectClassTeacher> getAll() {
		try{SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<SubjectClassTeacher> query=session.createQuery("select a from org.simplilearn.lms.entities.SubjectClassTeacher a");
		return query.list();
	} catch (Exception e) {
		return null;
	}
	}

	@Override
	public void update(SubjectClassTeacher obj) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx =null;
		try {
			
			tx = session.beginTransaction();
			
			session.update(obj);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
