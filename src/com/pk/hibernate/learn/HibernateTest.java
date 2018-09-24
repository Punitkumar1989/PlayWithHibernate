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
		String minVal="5";
//		Query<UserDetails> query= session.createQuery("from UserDetails where userId > ?0");// and userName = ?1");
//		query.setParameter(0, Integer.parseInt(minVal));
	//	query.setParameter(1, "User 10");
		
		Query<UserDetails> query= session.createQuery("from UserDetails where userId > :userId and userName = :userName");
		query.setParameter("userId", Integer.parseInt(minVal));
		query.setParameter("userName", "User 10");
		
		List<UserDetails> users = query.getResultList();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u : users){
			System.out.println("UserName is - "+u.getUserName());
		}
	}
}

