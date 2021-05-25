package com.criCoinWeb;

public class ApiPojo {
	private String name;
	private String symbol;
	private double current_price;
	private double quantity;
	
	public double getTotal() {
		return quantity*current_price;
	}
	
	
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public ApiPojo(String name, String symbol, double current_price) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.current_price = current_price;
	}
	public ApiPojo(String name, String symbol, double current_price,double quantity) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.current_price = current_price;
		this.quantity=quantity;
	}
	public ApiPojo() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	@Override
	public String toString() {
		return "ApiPojo [name=" + name + ", symbol=" + symbol + ", current_price=" + current_price +", quantity="+quantity+ "]";
	}
	
	
}
