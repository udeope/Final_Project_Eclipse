package com.criCoinWeb;



public class CoinTest {

	public static void main(String[] args) {
		CoinDAO modelo = new CoinDAO();
		WalletDAO  modelo2 = new WalletDAO();
		UserDAO tio = new UserDAO();
		System.out.println(modelo.getCoin(10));
		System.out.println(modelo2.getWallet(5));
		System.out.println(modelo2.getWallet(6));
		System.out.println(modelo2.getWalletUser(1));
		System.out.println(tio.getUser(10));
		
		
	}

}
