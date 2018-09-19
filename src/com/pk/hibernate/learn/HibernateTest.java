/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */


package com.pk.hibernate.learn;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.hibernate.learn.entity.UserDetails;

public class HibernateTest {
public static void main(String[] args) {
	UserDetails userDetails = new UserDetails();
	userDetails.setUserId(2);
	userDetails.setUserName("Suresh");
	userDetails.setJoinedDate(new Date());
	userDetails.setAddress("Suresh's Address");
	userDetails.setDescription("Suresh Description");
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
	session.close();
	
	//Fetching data from database through Hibernate
	userDetails = null;
	session = sessionFactory.openSession();
	session.beginTransaction();
	userDetails = (UserDetails)session.get(UserDetails.class, 2);
	System.out.println("User Id - "+userDetails.getUserId());
	System.out.println("User Name is - "+ userDetails.getUserName());
	session.close();
	
	
	
}
}
