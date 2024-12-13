package com.tka.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Laptop;
import com.tka.entity.Student;

public class MainClass {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Laptop.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
//		Laptop l1 = new Laptop("HP");
//		Laptop l2 = new Laptop("Asus");
//		Laptop l3 = new Laptop("dell");
//		Laptop l4 = new Laptop("Lennovo");
		
//		session.persist(l1);
//		session.persist(l2);
//		session.persist(l3);
//		session.persist(l4);
		
//		Student stud = new Student("Maroti", "840885008");
//		stud.setLaptop(l4);
//		Student stu = new Student("anil", "78955");
//		Laptop l6= session.get(Laptop.class, 4);
//		stu.setLaptop(l6);
//		session.persist(stu);
		
		Student stud= session.get(Student.class, 2);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(stud);
		
	}

}
