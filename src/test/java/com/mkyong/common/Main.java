package com.mkyong.common;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.persistence.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		  
		  Person person = new Person();
		  person.setId(1);
		  person.setId("Stefan");
		 
		 /* SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).buildSessionFactory();
		  
		  Session session = factory.openSession();
		  
		  session.beginTransaction();
		 
		  session.save(person);
		  session.getTransaction().commit();*/
		
		 System.out.println("Maven + Hibernate + Postgresql");
	        Session session = HibernateUtil.getSessionFactory().openSession();
            
	        session.beginTransaction();
			 
			  session.save(person);
			  session.getTransaction().commit();
			  
			  Query<Person> query = session.createQuery("from Person");
			  
			  Person p = (Person)query.getSingleResult();
			  
			 System.out.println( p.getId());
			 System.out.println("Ime je: " + p.getName());
	}

}
