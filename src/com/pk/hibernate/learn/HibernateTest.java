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
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("My Updated User");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
}
