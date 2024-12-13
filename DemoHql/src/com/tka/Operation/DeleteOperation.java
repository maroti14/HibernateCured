package com.tka.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tka.entity.Song;

public class DeleteOperation {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		 SessionFactory factory= config.buildSessionFactory();
		 Session session= factory.openSession();
		 session.beginTransaction();
		
		String hqlQuery="delete Song where id =:id";
		
		MutationQuery mQuery= session.createMutationQuery(hqlQuery);
		mQuery.setParameter("id", 3);
		int status= mQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
		if(status>0) {
			System.out.println("delete");
		}else {
			System.out.println("not");
		}
	}

}
