package com.criCoinController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.criCoinWeb.*;

/**
 * Servlet implementation class CriCoinController
 */
@WebServlet("/controller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO modeloUser;
	private WalletDAO modeloWallet;
	private CoinDAO modeloCoin;
	private HttpSession session;
	private ConexionAPI conexionApi;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		modeloUser = new UserDAO();
		modeloWallet = new WalletDAO();
		modeloCoin = new CoinDAO();		
		conexionApi = new ConexionAPI();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		session = request.getSession(true);

		if (accion.equals("nuevo")) {
			String pass = request.getParameter("pass");
			String pass1 = request.getParameter("pass1");
			String email = (request.getParameter("email"));
	
			if (pass.equals("") || pass == null || pass1.equals("") || pass1 == null || email.equals("") || email == null) {
				request.setAttribute("mensaje", "Debes rellenar todos los campos");
				request.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);

			} else if (!pass.equals(pass1)) {
				request.setAttribute("mensaje", "La contrase�a no coincide");
				request.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);

			} else {
				UserPojo usuario = new UserPojo(0, email, pass);
				modeloUser.addUser(usuario);
				request.setAttribute("email", email);
				request.setAttribute("pass", pass);
				usuario.setCapital(3000.00);
				session.setAttribute("user", usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
				dispatcher.forward(request, response);
			}
		} else if (accion.equals("insertar")) {
			String nick = request.getParameter("nick");
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			Date b_date = Date.valueOf(request.getParameter("b_date"));
			String country = request.getParameter("country");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			double capital = Double.parseDouble(request.getParameter("capital"));
			
			UserPojo usuario = new UserPojo(0, nick, first_name, last_name, b_date, country, email, pass, capital);//creo un objeto nuevo que carece de cartera
			modeloUser.updateUser(usuario, modeloUser.getUserIdByEmail(email));
			
			session = request.getSession(true);
			session.setAttribute("user", modeloUser.getUser(modeloUser.getUserIdByEmail(email)));//mio prueba 3 recuperos el usuario por el email
			session = request.getSession(true);
			session.setAttribute("user", modeloUser.getUser(modeloUser.getUserIdByEmail(email)));						
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
			dispatcher.forward(request, response);

		} else if (accion.equals("insertarEmail")) {
			String email = request.getParameter("email");
			if (!modeloUser.comprobarSiExisteEmail(email)) {
				if (email != null) {					
					request.setAttribute("email", email);
					RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("mensaje", "Este correo ya est� en uso");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} else if (accion.equals("login")) {
            String emailLogin = request.getParameter("emailLogin");
            String  password= request.getParameter("password");

            if(modeloUser.comprobarSiExisteEmail(emailLogin) && modeloUser.comprobarPassword(modeloUser.getUserIdByEmail(emailLogin)).equals(password)) {
                session = request.getSession(true);
                session.setAttribute("user", modeloUser.getUser(modeloUser.getUserIdByEmail(emailLogin)));

                RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
                dispatcher.forward(request, response);
            }else {
                request.setAttribute("mensajeLogin", "Usuario o contraseña invalidos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }		
		} else if(accion.equals("cerrarSesion")) {
			session.invalidate();//manera correcta de cerrar la session destruyendola-Mio
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            
			
		
		} else if(accion.equals("recuperarDatosCartera")){
			session = request.getSession(true);
			UserPojo user = (UserPojo) session.getAttribute("user"); // Conversi�n implicita porque el objeto de sesi�n que se nos pasa es abstracto y aqu� lo definimos como UserPojo.
			request.setAttribute("datosRecuperados", "ok");
			
			request.setAttribute("user", user);
			
			ConexionAPI conexionApi = new ConexionAPI();	
			session.setAttribute("wallet", conexionApi.infoMonedasUserById(user.getId_user()));
			System.out.println(user.getId_user());
			session.setAttribute("precioBit", conexionApi.bitcoinGetter());
				System.out.println(session.getAttribute("wallet"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("generalPanel.jsp");
            dispatcher.forward(request, response);			
		}
		else if(accion.equals("recuperarDatosCarteraMercado")){
			session = request.getSession(true);
			UserPojo user = (UserPojo) session.getAttribute("user"); // Conversión implicita porque el objeto de sesión que se nos pasa es abstracto y aquí lo definimos como UserPojo.
			request.setAttribute("datosRecuperados", "ok");
			
			request.setAttribute("user", user);
			
			ConexionAPI conexionApi = new ConexionAPI();	
			session.setAttribute("wallet", conexionApi.infoMonedasUserById(user.getId_user()));//aplico el usuario con la cartera a la sesion
			session.setAttribute("precioBit", conexionApi.bitcoinGetter());//aplico a la sesion el valor del precio del bitcoin
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
            dispatcher.forward(request, response);			
		}
		else if(accion.equals("comprar")) {
			String monedaNom = request.getParameter("selCoin");//recupero el nombre de la moneda que compro
			double apuesta = Double.parseDouble(request.getParameter("apuesta")); // recupero la cantidad de dolares que he gastado
			double conversion =Double.parseDouble(request.getParameter("conversion"));//recupero la cantidad de coins que compro
			UserPojo user = (UserPojo) session.getAttribute("user");//recupero los atributos del usuario
			double restaCapital = modeloUser.getRestarCapital(user.getCapital(), apuesta);//calculo la resta del capital total - el que uso para la compra
			double conversionDB = modeloUser.getSumarMonedas(modeloUser.getSaldoCoins(monedaNom,user.getId_user()), conversion);
			modeloUser.updateCapital(user.getId_user(),restaCapital);// actualizo el capital de la base de datos
			int id_wallet = modeloWallet.getIdWallet(monedaNom, user.getId_user());//recupero la id del wallet en base al nombre de la moneda y la id del usuario
			if (id_wallet==0) {//condicion para actualizar o crear nuevo
				WalletPojo walletpojo = new WalletPojo(0,conversion,user.getId_user(),modeloCoin.getIdCoin(monedaNom),null);//creo el nuevo wallet pojo con los valores
				System.out.println("conversion:" + conversion);
				modeloWallet.addWallet(walletpojo); //creo el nuevo wallet en la base de datos
			}else if(id_wallet>0) {
				modeloWallet.updateWallet(conversionDB, modeloCoin.getIdCoin(monedaNom), user.getId_user());//actualizo el wallet de la base de datos
			}
			session = request.getSession(true);
			session.setAttribute("user", modeloUser.getUser(modeloUser.getUserIdByEmail(user.getEmail())));//aplico a la sesion el usuario para actualizar los valores que he cambiado en la misma
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
            dispatcher.forward(request, response);		
		}else if(accion.equals("vender")) {
			String monedaNom = request.getParameter("buyCoin");//recupero el nombre de la moneda que vendo
			double conversion = Double.parseDouble(request.getParameter("conversionVenta")); // recupero la cantidad de dolares que he ganado
			double apuesta =Double.parseDouble(request.getParameter("apuestaVenta"));//recupero la cantidad de coins que he vendido
			UserPojo user = (UserPojo) session.getAttribute("user");//recupero los atributos del usuario
			double sumaCapital = modeloUser.getSumarMonedas(user.getCapital(), conversion);//calculo la suma del capital total + el que gano por la venta
			double restaCoins = modeloUser.getRestarCapital(modeloUser.getSaldoCoins(monedaNom,user.getId_user()), apuesta);//resto las monedas que he vendido de las que tengo en el wallet
			modeloUser.updateCapital(user.getId_user(),sumaCapital);// actualizo el capital de la base de datos
			int id_wallet = modeloWallet.getIdWallet(monedaNom, user.getId_user());//recupero la id del wallet en base al nombre de la moneda y la id del usuario
			
			modeloWallet.updateWallet(restaCoins, modeloCoin.getIdCoin(monedaNom), user.getId_user());//actualizo el wallet de la base de datos
			
			session = request.getSession(true);
			session.setAttribute("user", modeloUser.getUser(modeloUser.getUserIdByEmail(user.getEmail())));//aplico a la sesion el usuario para actualizar los valores que he cambiado en la misma
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
            dispatcher.forward(request, response);		
		}else if(accion.equals("ranking")) {
			request.setAttribute("users", modeloUser.getUsersSorted());
			RequestDispatcher dispatcher = request.getRequestDispatcher("ranking.jsp");
            dispatcher.forward(request, response);	
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
