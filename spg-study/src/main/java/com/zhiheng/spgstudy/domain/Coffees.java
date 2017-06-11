package com.zhiheng.spgstudy.domain;

public class Coffees {
	private String cofName;
	private Double price;
	private Integer sales;
	private Integer totals;
	public String getCofName() {
		return cofName;
	}
	public void setCofName(String cofName) {
		this.cofName = cofName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getTotals() {
		return totals;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	
	public Coffees() {
		super();
	}
}
