package com.tka.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tka.entity.Laptop;
import com.tka.entity.Student;

public class UpdateE {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Laptop.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		Student stu= session.get(Student.class, 2);
		stu.setName("Jivan");
		session.merge(stu);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(stu);
		
		
	}

}
