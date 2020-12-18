package prova.ombrelloni.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import Liste.Lista;
import OtherClass.Previsioni;
import Server.Account;

public class UsaApi {
	
	private String url;   
	public Lista <Previsioni> lista = new Lista <Previsioni>();
	private int giorniDaVedere = 5;
	private int scansioniGiornaliere = 8;

	
	
	public void letturaOnline() {
		 url = "http://api.openweathermap.org/data/2.5/forecast?id=6540261&appid=fab715b1276e37b8c17a87274e509451";
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			String data = "";
			String line = "";
			 try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			  
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
			   }
			 } finally {
			   in.close();
			 }
			 
			
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			Previsioni previsione = new Previsioni();
			
			JSONArray list = (JSONArray) obj.get("list");
			
			
			
			
			for(int i = 0; i < giorniDaVedere ; i+=scansioniGiornaliere) {
				
			JSONObject oggettoLista = (JSONObject) list.get(i);	
			
			previsione.setData((long) oggettoLista.get("dt"));
			
			JSONObject city = (JSONObject) obj.get("city");
			
			previsione.setNome((String) city.get("name"));
				
			JSONObject main = (JSONObject) oggettoLista.get("main");
			
			previsione.setTemperatura((double) main.get("temp")); 
			
			JSONArray weather = (JSONArray) oggettoLista.get("weather");
			
			JSONObject obj2 = (JSONObject) weather.get(0) ;
			
			previsione.setCondizioni((String) obj2.get("main"));
			
			this.lista.aggiungi(previsione);
			}
			
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
		
	}

