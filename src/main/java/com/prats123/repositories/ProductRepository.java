package com.prats123.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.prats123.entities.ProductEntity;

@Repository
public class ProductRepository {
	
	private SessionFactory sessionFactory;
	
	public void save(ProductEntity product){
		System.out.println("a");
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}

	public void update(ProductEntity product){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.merge(product);
		session.getTransaction();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
