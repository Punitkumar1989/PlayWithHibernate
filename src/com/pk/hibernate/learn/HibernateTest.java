/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pk.hibernate.learn.entity.UserDetails;

public class HibernateTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<UserDetails> query= session.createQuery("from UserDetails where userId>1");
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size - "+users.size());
		
	
	}
}

