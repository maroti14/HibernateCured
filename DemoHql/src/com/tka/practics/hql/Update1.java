package com.tka.practics.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tka.entity.Song;

public class Update1 {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="update Song set name=:name where id=:id";
		
		MutationQuery mQuery= session.createMutationQuery(hqlQuery);
		mQuery.setParameter("id", 2);
		mQuery.setParameter("name", "kesariya");
		int up= mQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
		if(up>0) {
			System.out.println("update");
		}else {
			System.out.println("Not Update");
		}
	}

}
