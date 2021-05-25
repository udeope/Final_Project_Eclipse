package com.criCoinWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;


public class UserDAO {
	private Connection con;
	private int max_records = 1000;
	private HttpSession session;

	public UserDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://db-mysql-final-project-do-user-9229440-0.b.db.ondigitalocean.com:25060/proyecto_final", "luis", "z3rxgvnbrigspt5b");
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
				res = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"), rs.getDouble("capital"));
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
				UserPojo user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"),rs.getDouble("capital"));
				userList.add(user);
			}
			return userList;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<UserPojo> getUsersSorted() {
		try {
			String sql = "select * from user limit ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, max_records);

			ResultSet rs = stmt.executeQuery();

			List<UserPojo> userList = new ArrayList<UserPojo>();

			while (rs.next()) {
				UserPojo user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"),rs.getDouble("capital"));
				userList.add(user);			
			}
			
			userList.sort(Comparator.comparing(UserPojo::getFondos).reversed());			
			return userList;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}		

	
	public int addUser(UserPojo user) {
		try {
			String sql = "insert into user (nick,first_name,last_name,b_date,country,email,pass,capital) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getNick());
			stmt.setString(2, user.getFirst_name());
			stmt.setString(3, user.getLast_name());
			stmt.setDate(4, user.getB_date());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getPass());
			stmt.setDouble(8, 3000.0);
			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	public int addUserRegistro(UserPojo user) {
		try {
			String sql = "insert into user (email,pass) values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPass());

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

			System.out.println(ex.getMessage());
			return -1;
		}
	}

	public boolean comprobarSiExisteEmail(String email) {
		try {
			String sql = "SELECT * FROM user where email = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, email);

			ResultSet res = stmt.executeQuery();
			return res.next();

		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}

	}
	
	public int getUserIdByEmail(String email) {
		try {
			String sql = "select * from user where email = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getInt("id_user"));
				return rs.getInt("id_user");
			}
		} catch (Exception ex) {
			System.out.println(ex);

		}
		return -1;
	}
	
	public String comprobarPassword(int id) {
        try {
            String sql = "select * from user where id_user = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	return rs.getString("pass");
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }
        return "";
    }
	

//--------------------------inicio sesion -----------------------------------------------
	
	public UserPojo getLogin(int id) {
		UserPojo user;
		try {
			String sql = "select name,pass from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setInt(1, id);//revisar//
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"),rs.getDouble("capital"));
				return user;
			} else {
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int updateCapital(int id, double restaCapital) {
		try {
			String sql = "update user set capital=? where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDouble(1, restaCapital);
			stmt.setInt(2, id);

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {

			System.out.println(ex.getMessage());
			return -1;
		}
	}
	public double getRestarCapital(double a, double b ) {
		return a-b;
	}
	
	public double getSumarMonedas(double a, double b ) {
		return a+b;
	}
	
	public double getSaldoCoins(String name_coin,int user_id) {
		try {
			String sql = "select total_coin from wallet,coin where wallet.id_coin=coin.id_coin and coin.name=? and id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name_coin);
			stmt.setInt(2, user_id);
			
			ResultSet res = stmt.executeQuery();
			            	
            	System.out.println(res.getClass());
            	if (res.next()) {
            		System.out.println(res.getDouble("total_coin"));
                	return res.getDouble("total_coin");
                	
                }
            return 0.00f;
		} catch (Exception ex) {

			System.out.println(ex.getMessage());
			return 1.00f;
		}
		
	}
	
}
