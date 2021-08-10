package com.bean.onetoone;

public class StockBean {

	int stockId;
	String stockName;
	String stockCode;
	String stockType; 
	
	StockDetailBean stockDetail;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public StockDetailBean getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetailBean stockDetail) {
		this.stockDetail = stockDetail;
	}
	
}
