package com.tka.dao1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity1.Song;

public class U {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Song s= session.get(Song.class, 1);
		s.setName("hang over");
		s.setArtist("Salman");
		
		session.merge(s);
		session.getTransaction().commit();
		session.close();
		
		if(s !=null)
			System.out.println("data update");
		else
			System.out.println("not Update");
	}

}
