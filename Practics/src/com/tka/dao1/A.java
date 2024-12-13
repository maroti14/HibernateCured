package com.tka.dao1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity1.Song;

public class A {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Song s = new Song("tum hi ho", "arjit");
		Song s1 = new Song("Blue Wise", "yoyo");
		Song s2 = new Song("sat samndar", "lata mangesh");
		
		
		session.persist(s);
		session.persist(s1);
		session.persist(s2);
		session.getTransaction().commit();
		session.close();
		System.out.println(s);
		
	}

}
