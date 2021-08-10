package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.onetoone.StockBean;
import com.bean.onetoone.StockDetailBean;

public class OneToOneStockStockDetail {
	public static void main(String[] args) {
//		new OneToOneStockStockDetail().addStock();
		new OneToOneStockStockDetail().printStockData();
		
	}

	void addStock() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		StockBean stock = new StockBean();
		stock.setStockName("TataCService");
		stock.setStockType("LargeCap");
		stock.setStockCode("TCS");

		StockDetailBean stockDetail = new StockDetailBean();
		stockDetail.setCurrentPrice(3070);
		stockDetail.setMaxPrice(3350);
		stockDetail.setMinPrice(2370);

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		session.persist(stock); // stock --> stockDetail
		tx.commit();

		session.close();

	}

	void printStockData() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		StockBean stock = session.get(StockBean.class, 4);
		
		System.out.println(stock.getStockName());//
		if(stock.getStockDetail() != null) {
			System.out.println(stock.getStockDetail().getCurrentPrice());
		}

		
		
		session.close();

	}
}
