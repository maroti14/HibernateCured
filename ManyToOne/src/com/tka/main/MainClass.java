package com.tka.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Laptop1;
import com.tka.entity.Student1;

public class MainClass {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student1.class);
		config.addAnnotatedClass(Laptop1.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
//		Laptop1 l1 = new  Laptop1("akash");
//		Laptop1 l2 = new Laptop1("ranjit");
//		Laptop1 l3 = new Laptop1("manoj");
//		Laptop1 l4 = new Laptop1("parshya");
//		
//		session.persist(l1);
//		session.persist(l2);
//		session.persist(l3);
//		session.persist(l4);
		
//		Laptop1 l= session.get(Laptop1.class, 1);
		
//		Student1 s = new Student1("sonali");
		
//		s.setLaptop1(l);
//		session.persist(s);
		
		Student1 st= session.get(Student1.class, 1);
		session.remove(st);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
