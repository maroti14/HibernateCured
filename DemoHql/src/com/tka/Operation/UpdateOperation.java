package com.tka.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tka.entity.Song;

public class UpdateOperation {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session= factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="update Song set name=:myname ,artist=:mysinger where id=:myid";
		
		//hibernate 6
		
		MutationQuery mQuery = session.createMutationQuery(hqlQuery);
		mQuery.setParameter("myname", "tum hi");
		mQuery.setParameter("mysinger", "lata");
		
		mQuery.setParameter("myid", 2);
		int status= mQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		if(status>0) {
			System.out.println("Data Is Update");
		}else {
			System.out.println("Data Not Update");
		}
	}

}
