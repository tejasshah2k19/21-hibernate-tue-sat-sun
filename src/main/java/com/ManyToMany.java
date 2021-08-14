package com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.manytomany.EmployeeBean;
import com.bean.manytomany.ProjectBean;

public class ManyToMany {

	public static void main(String[] args) {
		ManyToMany m = new ManyToMany();
		while(true) {
			System.out.println("enter choice");
			int choice = new Scanner(System.in).nextInt();
			
			if(choice==1) {
				m.addData();
			}
		}
		
		//new ManyToMany().getEmployee();
	}

	void getEmployee() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		EmployeeBean emp = session.get(EmployeeBean.class, 1);
		System.out.println(emp.getName());//select emp, project
//		System.out.println(emp.getProjects());
	}

	void addData() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		EmployeeBean ram = new EmployeeBean();
		ram.setName("ram");
		ram.setSalary(25000);

		EmployeeBean shyam = new EmployeeBean();
		shyam.setName("shyam");
		shyam.setSalary(55000);

		ProjectBean practo = new ProjectBean();
		practo.setProjectName("practo");// 1
		practo.setBudget(250000);

		ProjectBean mayoClinic = new ProjectBean();
		mayoClinic.setProjectName("mayo-clinic");// 2
		mayoClinic.setBudget(350000);

		ProjectBean expenseApp = new ProjectBean();
		expenseApp.setProjectName("expense-app");// 3
		expenseApp.setBudget(450000);

		Set<ProjectBean> ramProjects = new HashSet<ProjectBean>();
		ramProjects.add(practo);// 1
		ramProjects.add(expenseApp);// 3

		Set<ProjectBean> shyamProjects = new HashSet<ProjectBean>();
		shyamProjects.add(practo);
		shyamProjects.add(expenseApp);
		shyamProjects.add(mayoClinic);

		ram.setProjects(ramProjects);
		shyam.setProjects(shyamProjects);

		session.persist(ram);// 1
		session.save(shyam);// 2

		tx.commit();

	}
}
