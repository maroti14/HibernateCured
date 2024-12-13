package com.tka.operation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Song;

public class InsertOperation {
	
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory(); 
		Session session = factory.openSession();
		session.beginTransaction();
		
		Song song = new Song("Hangover", "Salman");
		
		session.persist(song);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
