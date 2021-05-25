package com.criCoinWeb;

import java.sql.Date;
import java.util.*;

public class UserPojo {
	private int id_user;
	private String nick;
	private String first_name;
	private String last_name;
	private Date b_date;
	private String country;
	private String email;
	private String pass;
	private double capital;
	private List<WalletPojo> cartera;
	
	

	public UserPojo(int id_user, String email, String pass) {
		this.id_user = id_user;
		this.email = email;
		this.pass = pass;
	}
	
	public UserPojo(int id_user, String email, String pass, double capital) {
		this.id_user = id_user;
		this.email = email;
		this.pass = pass;
		this.capital = capital;
	}

	public UserPojo(int id_user, String nick, String first_name, String last_name, Date b_date, String country,
			String email, String pass, double capital) {
		this(id_user, email, pass);
		this.nick = nick;
		this.first_name = first_name;
		this.last_name = last_name;
		this.b_date = b_date;
		this.country = country;
		this.cartera = new ArrayList<WalletPojo>();
		this.capital = capital;
	}
	
	public UserPojo() {
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
			this.nick = nick;
	}	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<WalletPojo> getCartera() {
		return cartera;
	}

	public void setCartera(List<WalletPojo> cartera) {
		this.cartera = cartera;
	}

	public double getCapital() {
		
		
		return capital;
	}

	public void setCapital(double capital) {
		
		
		this.capital = capital;
	}
 
	public double getFondos() {
			ConexionAPI conexionApi = new ConexionAPI();
			double cont= 0.0;
			List<ApiPojo> cartera=conexionApi.infoMonedasUserById(this.getId_user());
			for(int i = 0; i<cartera.size(); i++) {
				cont += cartera.get(i).getTotal();
			}
			cont += this.getCapital();
			return(cont);
	}
	
	
	
	
	@Override
	public String toString() {
		return "UserPojo [id_user=" + id_user + ", nick=" + nick + ", first_name=" + first_name + ", last_name="
				+ last_name + ", b_date=" + b_date + ", country=" + country + ", email=" + email + ", pass=" + pass
				+ ", capital=" + capital + ", cartera=" + cartera + "]";
	}

	

	

}
