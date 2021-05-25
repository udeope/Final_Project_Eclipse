package com.criCoinWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {

	private Connection con;
    private int max_records = 1000;
 
    public WalletDAO() {
        try {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db-mysql-final-project-do-user-9229440-0.b.db.ondigitalocean.com:25060/proyecto_final", "luis", "z3rxgvnbrigspt5b");   
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public WalletPojo getWallet(int id) {
    	WalletPojo res = null;
    	CoinDAO moneda = new CoinDAO();
        try {
            String sql = "select * from wallet where id_wallet=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setInt(1, id);
             
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	res = new WalletPojo(rs.getInt("id_wallet"),rs.getDouble("total_coin"),rs.getInt("id_user"),rs.getInt("id_coin"), moneda.getCoin(rs.getInt("id_coin")));               
            }
            
             
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
        return res;
    }
    
    
    public List<WalletPojo> getWalletUser(int id) {
    	List<WalletPojo> res = new ArrayList<WalletPojo>();
        try {
            String sql = "select * from wallet where id_user=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
             
            ResultSet rs = stmt.executeQuery();
             
            while (rs.next()) {
            	WalletPojo temp=getWallet(rs.getInt("id_wallet"));

                res.add(temp);
            }
            
        } catch (Exception ex) {
            System.out.println(ex);   
        }
        return res;
    }

    public int addWallet(WalletPojo wallet) {
        try {
            String sql = "insert into wallet (id_user,id_coin,total_coin) values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setInt(1, wallet.getId_user());
            stmt.setInt(2, wallet.getId_coin());
            stmt.setDouble(3, wallet.getTotal_coin());
                      
            int res = stmt.executeUpdate();
            return res;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }
    
    public int deleteWallet(int id) {
        try {
            String sql = "delete from wallet where id_wallet=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setInt(1, id);
 
            int res = stmt.executeUpdate();
            return res;
 
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }
    
    public int updateWallet(WalletPojo wallet, int id) {
        try {
            String sql = "update wallet set id_user=?, id_coin=? where id_wallet=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setInt(1, wallet.getId_user());
            stmt.setInt(2, wallet.getId_coin());
 
            int res = stmt.executeUpdate();
            return res;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
	
    } 
   
    public int updateWallet(double total_coin,int coin, int id) {
        try {
            String sql = "update wallet set total_coin=? where id_coin=? and id_user=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setDouble(1, total_coin);
            stmt.setInt(2, coin);
            stmt.setInt(3, id);
 
            int res = stmt.executeUpdate();
            return res;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
	
    } 
    
    public int getIdWallet(String name, int id_user) {
    	try {
            String sql = "select id_wallet from wallet,coin where wallet.id_coin=coin.id_coin and name=? and id_user=?";
            PreparedStatement stmt = con.prepareStatement(sql);
 
            stmt.setString(1, name);
            stmt.setInt(2, id_user);
            
 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	return rs.getInt("id_wallet");       
            }
            
            return 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }
    

}
