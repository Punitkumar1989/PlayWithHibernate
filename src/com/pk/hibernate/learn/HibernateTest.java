/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */


package com.pk.hibernate.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.hibernate.learn.entity.Address;
import com.pk.hibernate.learn.entity.UserDetails;

public class HibernateTest {
public static void main(String[] args) {
	UserDetails userDetails = new UserDetails();
//	userDetails.setUserId(2);
	userDetails.setUserName("Suresh");
	
	Address addr = new Address();
	addr.setCity("user City");
	addr.setState("user state");
	addr.setStreet("user street");
	userDetails.setAddress(addr);
	
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

}
}
