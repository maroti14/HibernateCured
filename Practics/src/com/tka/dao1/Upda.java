package com.tka.dao1;

import static org.mockito.ArgumentMatchers.same;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity1.Song;

public class Upda {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Song song =session.get(Song.class, 1);
		song.setName("la");
		session.merge(song);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(song);
		
	}

}
