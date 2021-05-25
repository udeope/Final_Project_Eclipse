package com.criCoinWeb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConexionAPI {
	public List<ApiPojo> infoMonedasUserById(int id) {
		CoinDAO moneda1 = new CoinDAO();
		ApiPojo coinInfo = new ApiPojo();
		List<ApiPojo> listaDatosMonedas = new ArrayList<ApiPojo>();
		List<WalletPojo> listaUsuarioMonedas = moneda1.getCoinsByIdUser(id);

		for (int i = 0; i < listaUsuarioMonedas.size(); i++) {
			try {
				String resultado = peticionHttpGet("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids="
						+ listaUsuarioMonedas.get(i).getMoneda().getName()
						+ "&order=market_cap_desc&per_page=100&page=1&sparkline=false");// recorro la lista de las
																						// monedas que tiene el ususario
																						// en la base de datos y cojo de
																						// la posicion i la moneda y en
																						// nombre
				JSONArray json = new JSONArray(resultado);
				System.out.println(json);

				JSONObject object = json.getJSONObject(0);
				coinInfo = new ApiPojo(object.getString("name"), object.getString("symbol"),
						object.getDouble("current_price"), listaUsuarioMonedas.get(i).getTotal_coin());
				listaDatosMonedas.add(coinInfo);

				// object.getInt("current_price")) * peticionDAOCuantasMonedasdeEstasTengo
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		System.out.println(listaDatosMonedas);
		return listaDatosMonedas;
	}

	public ApiPojo bitcoinGetter() {

		ApiPojo bitcoinInfo = new ApiPojo();

		try {
			String resultado = peticionHttpGet("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false");// recorro la listade las monedasque tiene elususario en la base de datos y cojo de la posicion i la moneda y en nombre
			JSONArray json = new JSONArray(resultado);
			System.out.println(json);

			JSONObject object = json.getJSONObject(0);
			bitcoinInfo = new ApiPojo(object.getString("name"), object.getString("symbol"),
					object.getInt("current_price"));

			// object.getInt("current_price")) * peticionDAOCuantasMonedasdeEstasTengo
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return bitcoinInfo;
	}
	
	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexi�n e indicar que ser� de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// B�feres para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilde

		return resultado.toString();
	}
}
