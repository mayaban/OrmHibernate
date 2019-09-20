package com.prats123.repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.prats123.entities.EmployeeEntity;


@Repository
public class EmployeeRepository {
	
	private SessionFactory sessionFactory;
	
	public void save(EmployeeEntity employee){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.merge(employee);
		session.getTransaction().commit();;
		session.close();
	}
	
	public void update(EmployeeEntity employee){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.merge(employee);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public EmployeeEntity getEmployeeByEmail(String email){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from EmployeeEntity e where e.email=:email");
		query.setParameter("email", email);
		EmployeeEntity et=(EmployeeEntity) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return et;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
