package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		// configuration
//		Configuration config = new Configuration().configure("hibernate.cfg.xml");
//		System.out.println(config);
//		// sessionFactory
//		SessionFactory sf = config.buildSessionFactory();
//		System.out.println(sf);
//		// session
//		Session session = sf.openSession();
//		System.out.println(session);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		System.out.println(sf);

		Session session = sf.openSession();

	}
}
