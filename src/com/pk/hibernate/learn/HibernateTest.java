/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.hibernate.learn.entity.FourWheeler;
import com.pk.hibernate.learn.entity.TwoWheeler;
import com.pk.hibernate.learn.entity.UserDetails;
import com.pk.hibernate.learn.entity.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {

		
		/*
		 * Create Session Factory Object.
		 */

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Open a session using local session Factory object
		Session session = sessionFactory.openSession();
		// Be Ready For transaction
		session.beginTransaction();
		// Perform Transaction
		/*
		 * Insert Transaction using Hibernate
		 * 
		 * for (int i = 1; i <= 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}*/
		
	/*	
	 * 	Fetching the record using Hibernate
	 * 
	 * 	UserDetails user = session.get(UserDetails.class, 6);
		System.out.println("User Id - "+user.getUserId()+"  User name - "+ user.getUserName());*/
		
/*		
 * 		Deleting the record using Hibernate
 * 
 * 		UserDetails user = session.get(UserDetails.class, 6);
		session.delete(user);*/
		
		/*
		 * Updating the record using Hibernate
		 * 
		 * UserDetails user = session.get(UserDetails.class, 4);
		user.setUserName("Updated User");
		session.update(user);*/
		
		// Save the Transaction Object
		session.getTransaction().commit();
		session.close();

	}
}
