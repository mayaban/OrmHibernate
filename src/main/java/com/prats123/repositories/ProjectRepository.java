package com.prats123.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;




import com.prats123.entities.ProjectEntity;

@Repository
public class ProjectRepository {
	
	private SessionFactory sessionFactory;
	
	
	public void save(ProjectEntity project){
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(ProjectEntity project){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.merge(project);
		session.getTransaction().commit();
		session.close();
	}
	
	public ProjectEntity getprojectByName(String name){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from ProjectEntity c where c.name=:name");
		query.setParameter("name", name);
		ProjectEntity pE=(ProjectEntity) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return pE;
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
