package com.bean.onetoone;

public class StockDetailBean {

	int stockDetailId;
	
	float maxPrice;
	float minPrice;
	float currentPrice;
	
	StockBean stock;

	public int getStockDetailId() {
		return stockDetailId;
	}

	public void setStockDetailId(int stockDetailId) {
		this.stockDetailId = stockDetailId;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public StockBean getStock() {
		return stock;
	}

	public void setStock(StockBean stock) {
		this.stock = stock;
	}
	
}
