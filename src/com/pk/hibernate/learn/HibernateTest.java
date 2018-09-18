package com.pk.hibernate.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.hibernate.learn.entity.UserDetails;

public class HibernateTest {
public static void main(String[] args) {
	UserDetails userDetails = new UserDetails();
	userDetails.setUserId(2);
	userDetails.setUserName("Suresh");
	/*
	 * Create Session Factory Object. 
	 */
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	//Open a session using local session Factory object
	Session session = sessionFactory.openSession();
	//Be Ready For transaction
	session.beginTransaction();
	//Perform Transaction
	session.save(userDetails);
	//Save the Transaction Object
	session.getTransaction().commit();
	
}
}
