package com;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.onetomany.CertificateBean;
import com.bean.onetomany.StudentBean;

public class StudentCourse {

	public static void main(String[] args) {
		new StudentCourse().addStudent();
		// new StudentCourse().getStudent();
		// new StudentCourse().deleteStudent();
		// new StudentCourse().addCertiForStudent();
//		new StudentCourse().deleteCertificate();
	}

	void getStudent() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		StudentBean sb = session.get(StudentBean.class, 11);// student
		System.out.println(sb.getFirstName());

		for (CertificateBean cb : sb.getCertificates()) {
			System.out.println(cb.getName());
		}
		session.close();
	}

	void addStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		CertificateBean c1 = new CertificateBean();
		c1.setName("php");

		CertificateBean c2 = new CertificateBean();
		c2.setName(".Net");

//		CertificateBean c3 = new CertificateBean();
//		c3.setName("java");

		StudentBean sb1 = new StudentBean();
		sb1.setFirstName("gabbar");

		ArrayList<CertificateBean> certificates = new ArrayList<CertificateBean>();

		certificates.add(c1);// persist
		certificates.add(c2);
		// certificates.add(c3);

		sb1.setCertificates(certificates);

		// session.save(sb1);
		Transaction tx = session.beginTransaction();

		try {
//
			// session.save(c1);
			// session.save(c2);
			// session.save(c3);

			// session.save(sb1);//db student --> id -> certificate

			session.persist(sb1);// student ->
			System.out.println("done");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		session.close();

	}

	void deleteStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		StudentBean studentBean = session.get(StudentBean.class, 13);
		session.delete(studentBean);

		tx.commit(); 
		session.close();

	}

	void addCertiForStudent() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		CertificateBean cb = new CertificateBean();
		cb.setName("RoR");

		StudentBean sb = session.get(StudentBean.class, 14);
		sb.getCertificates().add(cb);

		session.save(sb);

		tx.commit();
		session.close();

	}

	void deleteCertificate() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		CertificateBean cb =  session.get(CertificateBean.class, 13);
		session.delete(cb);

		tx.commit();
		session.close();
	}
}
