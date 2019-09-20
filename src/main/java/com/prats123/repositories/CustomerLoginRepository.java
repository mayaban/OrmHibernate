package com.prats123.repositories;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.prats123.entities.CustomerLoginEntity;

@Repository
public class CustomerLoginRepository {
	
	private SessionFactory sessionFactory;
	
	public void save(CustomerLoginEntity customerLogin){
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(customerLogin);
	session.getTransaction().commit();
	session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CustomerLoginEntity getByUsername(String username){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from CustomerLoginEntity c where c.username=:uname");
		query.setParameter("uname", username);
		CustomerLoginEntity loginEntity=(CustomerLoginEntity) query.uniqueResult();
		session.getTransaction();
		session.close();
		return loginEntity;
	}
	
	public void update(CustomerLoginEntity customerLogin) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(customerLogin);
		
		session.getTransaction().commit();
		session.close();
}
}