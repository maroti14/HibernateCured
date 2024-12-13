package com.tka.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.antity.Laptop11;
import com.tka.antity.Student11;



public class MainClass {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student11.class);
		config.addAnnotatedClass(Laptop11.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
//		Laptop11 lap = new Laptop11("HCL");
//		Laptop11 lap1 = new Laptop11("dell");
//		Laptop11 lap2 = new Laptop11("HP");
		
		
		
		
		List<Laptop11> list = new ArrayList<Laptop11>();
//		Laptop11 la= session.get(Laptop11.class, 3);
//		Laptop11 laa= session.get(Laptop11.class, 1);
//		list.add(la);
//		list.add(laa);
		
		
//		list.add(lap);
//		list.add(lap1);
		
//		Student11 st = new Student11("MAnoj");
//		st.setLap_List(list);
		
//		session.persist(lap);
//		session.persist(lap1);
//		session.persist(lap2);
		
//		session.persist(st);
		
		Student11 s= session.get(Student11.class, 1);
		List<Laptop11> lapLi= s.getLap_List();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(s);
		
		for (Laptop11 laptop11 : lapLi) {
			System.out.println(laptop11);
		}
		
		
	}

}
