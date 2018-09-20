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
	addr.setCity("user home City");
	addr.setState("user home state");
	addr.setStreet("user home street");
	addr.setPinCode("user home Pin");
	
	Address addr2 = new Address();
	addr2.setCity("user office City");
	addr2.setState("user office state");
	addr2.setStreet("user office street");
	addr2.setPinCode("user office Pin");
	
	userDetails.getListOfAddress().add(addr);
	userDetails.getListOfAddress().add(addr2);
	
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
