package com.criCoinWeb;

public class WalletPojo {
private int id_wallet;
private double total_coin;
private int id_user;
private int id_coin;

public CoinPojo moneda;

public WalletPojo(int id_wallet, double total_coin, int id_user, int id_coin, CoinPojo moneda) {
	super();
	this.id_wallet = id_wallet;
	this.total_coin = total_coin;
	this.id_user = id_user;
	this.id_coin = id_coin;
	this.moneda = moneda;
}

public int getId_wallet() {
	return id_wallet;
}

public void setId_wallet(int id_wallet) {
	this.id_wallet = id_wallet;
}

public int getId_user() {
	return id_user;
}

public void setId_user(int id_user) {
	this.id_user = id_user;
}

public double getTotal_coin() {
	return total_coin;
}

public void setTotal_coin(double total_coin) {
	this.total_coin = total_coin;
}

public int getId_coin() {
	return id_coin;
}

public void setId_coin(int id_coin) {
	this.id_coin = id_coin;
}

public CoinPojo getMoneda() {
	return moneda;
}

public void setMoneda(CoinPojo moneda) {
	this.moneda = moneda;
}

@Override
public String toString() {
	return "WalletPojo [id_wallet=" + id_wallet + ", total_coin=" + total_coin + ", id_user=" + id_user + ", id_coin="
			+ id_coin + ", moneda=" + moneda + "]";
}





}
