package com.tka.login;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tka.entity.User;

public class MainDao {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(User.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="from User where username=:user and password=:pass";
		
		Query<User> query= session.createQuery(hqlQuery,User.class);
		query.setParameter("user", "user");
		query.setParameter("pass","user@123");
//		query
		
		User user= query.uniqueResult();
		
		session.getTransaction();
		session.close();
		
		if(user!=null) {
			System.out.println("Login");
		}else {
			System.out.println("Not Login");
		}
		
		
	}

}
