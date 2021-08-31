package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.annotation.manytomany.PlayerBean;
import com.bean.annotation.manytomany.SportsBean;
import com.bean.annotation.onetomany.AnswerBean;
import com.bean.annotation.onetomany.QuestionBean;

public class AnnoManyToMany {
	SessionFactory sf = null;

	public AnnoManyToMany() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		AnnoManyToMany am = new AnnoManyToMany();
		am.addPlayers();
	}

	void addPlayers() {
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		SportsBean ckt = new SportsBean();
		ckt.setName("ckt");

		SportsBean fb = new SportsBean();
		fb.setName("f.ball");

		SportsBean wb = new SportsBean();
		wb.setName("w.ball");

		PlayerBean sam = new PlayerBean();
		sam.setName("sam");
		PlayerBean ram = new PlayerBean();
		ram.setName("ram");
		PlayerBean shyam = new PlayerBean();
		shyam.setName("shyam");

		Set<PlayerBean> ckts = new HashSet<PlayerBean>();
		ckts.add(ram);
		ckts.add(shyam);
		
		Set<PlayerBean> fbs = new HashSet<PlayerBean>();
		fbs.add(ram);
		fbs.add(shyam);
		fbs.add(sam);
		
		
		Set<PlayerBean> wbs = new HashSet<PlayerBean>();
		wbs.add(ram);

		ckt.setPlayers(ckts);
		fb.setPlayers(fbs);
		wb.setPlayers(wbs);
		
		try {
			session.persist(ckt);
			session.persist(fb);
			session.persist(wb);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();

	}
}
