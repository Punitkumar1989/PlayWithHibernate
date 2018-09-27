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
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<UserDetails> query = session.createQuery("from UserDetails user where user.userId=1");
		query.setCacheable(true);
		List<UserDetails> user = query.list();
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query<UserDetails> query2 = session2.createQuery("from UserDetails user where user.userId=1");
		query2.setCacheable(true);
		user = query2.list();;
		session2.getTransaction().commit();
		session2.close();
	
	}
}

