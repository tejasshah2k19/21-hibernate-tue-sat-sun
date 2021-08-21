package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.annotation.onetoone.AddressBean;
import com.bean.annotation.onetoone.EmployeeBean;

public class AnnoOneToOne {

	SessionFactory sf = null;

	public AnnoOneToOne() {
		sf = new Configuration().configure().buildSessionFactory();

	}

	public static void main(String[] args) {
		AnnoOneToOne o = new AnnoOneToOne();
		o.addEmployee();
	}

	void addEmployee() {
		System.out.println("adding employee");
		Session session = sf.openSession();

		EmployeeBean emp = new EmployeeBean();
		emp.setName("ram");

		AddressBean address = new AddressBean();
		address.setCity("ahmedabad");
		address.setPincode(380015);

		emp.setAddress(address);
		address.setEmployee(emp);
		try {

			Transaction tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();

	}
}
