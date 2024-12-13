package com.tka.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Address;
import com.tka.entity.User;

public class MainClass {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Address.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Address add = new Address("Pune");
		Address add1 = new Address("Mumbai");
		Address add2 = new Address("Pimpri");
		Address add3 = new Address("Ravet");
		
		List<Address> list = new ArrayList<Address>();
//		list.add(add);
//		list.add(add1);
//		list.add(add2);
//		list.add(add3);
		
		Address add11= session.get(Address.class, 3);
		list.add(add11);
		
		User user = new User("Manoj");
		user.setList(list);
		
//		session.persist(add);
//		session.persist(add1);
//		session.persist(add2);
//		session.persist(add3);
		
		session.persist(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
	

}
