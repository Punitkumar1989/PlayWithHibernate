/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn;


import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.hibernate.learn.entity.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

//		Query<UserDetails> query= session.createQuery("from UserDetails where userId > ?0");// and userName = ?1");
//		query.setParameter(0, Integer.parseInt(minVal));
	//	query.setParameter(1, "User 10");
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);
		Root<UserDetails> rootObject = criteria.from(UserDetails.class);
		Predicate likeRestrictions = builder.notLike(rootObject.get("userName"),"User%");
		criteria.select(rootObject).where(likeRestrictions);
		
		TypedQuery<UserDetails> query = session.createQuery(criteria);
		
		List<UserDetails> users = query.getResultList();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u : users){
			System.out.println("UserName is - "+u.getUserName());
		}
	}
}

