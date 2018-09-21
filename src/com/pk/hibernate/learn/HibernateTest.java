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
import com.pk.hibernate.learn.entity.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Bike Two Wheeler Handle");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Porche");
		fourWheeler.setSteeringWheel("Porche steering Handle");
		
		/*
		 * Create Session Factory Object.
		 */

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Open a session using local session Factory object
		Session session = sessionFactory.openSession();
		// Be Ready For transaction
		session.beginTransaction();
		// Perform Transaction
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);

		// Save the Transaction Object
		session.getTransaction().commit();
		session.close();

	}
}
