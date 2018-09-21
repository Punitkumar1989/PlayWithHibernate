/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.hibernate.learn.entity.UserDetails;
import com.pk.hibernate.learn.entity.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		// userDetails.setUserId(2);
		userDetails.setUserName("Suresh");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Suv");

		userDetails.getVehicle().add(vehicle);
		userDetails.getVehicle().add(vehicle1);
		

		/*
		 * Create Session Factory Object.
		 */

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Open a session using local session Factory object
		Session session = sessionFactory.openSession();
		// Be Ready For transaction
		session.beginTransaction();
		// Perform Transaction
		session.persist(userDetails);
	
		// Save the Transaction Object
		session.getTransaction().commit();
		session.close();

	}
}
