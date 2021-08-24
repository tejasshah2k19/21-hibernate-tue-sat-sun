package com;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.annotation.onetomany.AnswerBean;
import com.bean.annotation.onetomany.QuestionBean;

public class AnnoOneToMany {
	SessionFactory sf = null;

	public AnnoOneToMany() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		AnnoOneToMany am = new AnnoOneToMany();
		am.addQuestion();
	}

	void addQuestion() {

		QuestionBean q = new QuestionBean();
		q.setQuestion("How many types of inheritance in oop?");

		AnswerBean a1 = new AnswerBean();
		a1.setAnswer("1");

		AnswerBean a2 = new AnswerBean();
		a2.setAnswer("2");

		AnswerBean a3 = new AnswerBean();
		a3.setAnswer("5");

		AnswerBean a4 = new AnswerBean();
		a4.setAnswer("7");

		List<AnswerBean> ans = new ArrayList<AnswerBean>();

		ans.add(a1);
		ans.add(a2);
		ans.add(a3);
		ans.add(a4);

		q.setAnswers(ans);

		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.persist(q);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();

	}
}
