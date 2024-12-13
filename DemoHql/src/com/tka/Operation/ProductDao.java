package com.tka.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Product;

public class ProductDao {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Product.class);
		
		
		SessionFactory factory = config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Product p1 = new Product("HP");
		
		session.persist(p1);
		session.getTransaction().commit();
		session.close();
		System.out.println(p1);
		
	}

}
