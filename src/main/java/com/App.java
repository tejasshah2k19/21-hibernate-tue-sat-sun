package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.UserBean;

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
		Session session = sf.openSession();

		UserBean user = new UserBean();

		user.setFirstName("ram1");
		user.setEmail("ram1@gmail.com");
		user.setPassword("ram1213");
		user.setCity("ayodhya1");
		Transaction tx = session.beginTransaction();
		session.save(user);// insert into
		tx.commit();
		session.close();

	}
}
