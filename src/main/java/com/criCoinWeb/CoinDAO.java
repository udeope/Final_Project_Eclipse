package com.criCoinWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





public class CoinDAO {
	private Connection con;
    private int max_records = 1000;
 
    public CoinDAO() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_final", "root", "");
 
            System.out.println("ok");
            
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
    
    public List<CoinPojo> getCoins() {
        try {
            String sql = "select * from coin limit ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, max_records);
             
            ResultSet rs = stmt.executeQuery();
             
            List<CoinPojo> coinList=new ArrayList<CoinPojo>();
             
            while (rs.next()) {
            	CoinPojo coin=new CoinPojo(rs.getInt("id_coin"),rs.getString("name"),rs.getString("siglas"),rs.getDouble("price"));

                coinList.add(coin);
            }
            return coinList;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
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
    
    
    
}
