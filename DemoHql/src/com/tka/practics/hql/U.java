package com.tka.practics.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tka.entity.Song;

public class U {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="update Song set name=:name where id=:id";
		MutationQuery hQuery = session.createMutationQuery(hqlQuery);
		hQuery.setParameter("id", 1);
//		hQuery.setParameter("singer", "Arjit_Sing");
		hQuery.setParameter("name", "keshriya");
		
		int a= hQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

}
