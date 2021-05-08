package com.criCoinWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection con;
	private int max_records = 1000;

	public UserDAO() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_final", "root", "");

			System.out.println("ok");

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public UserPojo getUser(int id) {
		
		UserPojo res = null;
		WalletDAO cartera = new WalletDAO();
		
		try {
			String sql = "select * from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				res = new UserPojo(rs.getInt("id_user"), rs.getString("nick"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getDate("b_date"),
						rs.getString("country"), rs.getString("email"), rs.getString("pass"));
				res.setCartera(cartera.getWalletUser(rs.getInt("id_user")));
				
			} 
			

		} catch (Exception ex) {
			System.out.println(ex);
			
		}
		return res;
	}

	public List<UserPojo> getUsers() {
		try {
			String sql = "select * from user limit ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, max_records);

			ResultSet rs = stmt.executeQuery();

			List<UserPojo> userList = new ArrayList<UserPojo>();

			while (rs.next()) {
				UserPojo user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getDate("b_date"),
						rs.getString("country"), rs.getString("email"), rs.getString("pass"));

				userList.add(user);
			}
			return userList;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public int addUser(UserPojo user) {
		try {
			String sql = "insert into user (nick,first_name,last_name,b_date,country,email,pass) values (?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getNick());
			stmt.setString(2, user.getFirst_name());
			stmt.setString(3, user.getLast_name());
			stmt.setDate(4, user.getB_date());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getPass());

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	public int deleteUser(int id) {
		try {
			String sql = "delete from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			int res = stmt.executeUpdate();
			return res;

		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	public int updateUser(UserPojo user, int id) {
		try {
			String sql = "update user set nick=?, first_name=?, last_name=?,b_date=?, country=?,email=?, pass=? where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getNick());
			stmt.setString(2, user.getFirst_name());
			stmt.setString(3, user.getLast_name());
			stmt.setDate(4, user.getB_date());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getPass());
			stmt.setInt(8, id);

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
//--------------------------inicio sesion -----------------------------------------------
	public UserPojo getLogin(int id) {
		try {
			String sql = "select name,pass from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setInt(1, id);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				UserPojo user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getDate("b_date"),
						rs.getString("country"), rs.getString("email"), rs.getString("pass"));
				return user;
			} else {
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
    	 
    }
    

