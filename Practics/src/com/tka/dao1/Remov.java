package com.tka.dao1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity1.Song;

public class Remov {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Song song= session.get(Song.class, 1);
		session.remove(song);
		
		session.getTransaction().commit();
		session.close();
	}

}
