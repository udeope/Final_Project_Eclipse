package com.criCoinWeb;

public class CoinPojo {
private int id_coin;
private String name;
private String siglas;
private double price;

public CoinPojo(int id_coin, String name, String siglas, double price) {
	super();
	this.id_coin = id_coin;
	this.name = name;
	this.siglas = siglas;
	this.price = price;
}

public int getId_coin() {
	return id_coin;
}

public void setId_coin(int id_coin) {
	this.id_coin = id_coin;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSiglas() {
	return siglas;
}

public void setSiglas(String siglas) {
	this.siglas = siglas;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

@Override
public String toString() {
	return "CoinPojo [id_coin=" + id_coin + ", name=" + name + ", siglas=" + siglas + ", price=" + price + "]";
}



}
