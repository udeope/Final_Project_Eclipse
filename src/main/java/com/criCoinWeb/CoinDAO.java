package com.criCoinWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CoinDAO {
	private Connection con;
    private int max_records = 1000;
 
    public CoinDAO() {
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-mysql-final-project-do-user-9229440-0.b.db.ondigitalocean.com:25060/proyecto_final", "luis", "z3rxgvnbrigspt5b");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    public CoinPojo getCoin(int id) {
        try {
            String sql = "select * from coin where id_coin=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setInt(1, id);
             
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	CoinPojo coin=new CoinPojo(rs.getInt("id_coin"),rs.getString("name"),rs.getString("siglas"),rs.getDouble("price"));
                return coin;
            }else {
                return null;
            }
             
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
       
    
    public List<WalletPojo> getCoinsByIdUser(int id) {
        try {
            String sql = "select * from user join wallet using(id_user) join coin using(id_coin) where id_user =  ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
             
            ResultSet rs = stmt.executeQuery();
             
            List<WalletPojo> coinList=new ArrayList<WalletPojo>();
             
            while (rs.next()) {
            	CoinPojo coin=new CoinPojo(rs.getInt("id_coin"),rs.getString("name"),rs.getString("siglas"),rs.getDouble("price"));   
            	WalletPojo wallet=new WalletPojo(rs.getInt("id_wallet"), rs.getDouble("total_coin"), rs.getInt("id_user"), rs.getInt("id_coin"),coin);
                coinList.add(wallet);
            }
            return coinList;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public List<String> calcularBalanceTotal() {
    	List<String> arrayNameMonedas = new ArrayList<>();	
    	CoinDAO moneda1 = new CoinDAO();    	
		for(int i = 0; i<moneda1.getCoinsByIdUser(1).size();i++) {			
			arrayNameMonedas.add(moneda1.getCoinsByIdUser(1).get(i).getMoneda().getName());
		}		
		return arrayNameMonedas;
    }


    public int addCoin(CoinPojo coin) {
        try {
            String sql = "insert into coin (name,siglas,price) values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setString(1, coin.getName());
            stmt.setString(2, coin.getSiglas());
            stmt.setDouble(3, coin.getPrice());
            
            int res = stmt.executeUpdate();
            return res;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }
    
    public int deleteCoin(int id) {
        try {
            String sql = "delete from coin where id_coin=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setInt(1, id);
 
            int res = stmt.executeUpdate();
            return res;
 
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }
    
    public int updateCoin(CoinPojo coin, int id) {
        try {
            String sql = "update coin set name=?, siglas=?, price=? where id_coin=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setString(1, coin.getName());
            stmt.setString(2, coin.getSiglas());
            stmt.setDouble(3, coin.getPrice());
            stmt.setInt(4, id);
 
            int res = stmt.executeUpdate();
            return res;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }
    public int getIdCoin(String name) {
    	try {
            String sql = "select id_coin from coin where name=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setString(1, name);
             
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	return rs.getInt("id_coin");       
            }
            
            return 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }    
}
