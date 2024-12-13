package com.tka.dao1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity1.Song;

public class Insert {
	
	public static void main(String[] args) {
		Configuration confi = new Configuration();
		confi.configure("hibernate.cfg.xml");
		confi.addAnnotatedClass(Song.class);
		
		SessionFactory factory= confi.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Song song = new Song("oooo","arjit");
		
		session.persist(song);
		session.getTransaction().commit();
		session.close();
		
	}

}
