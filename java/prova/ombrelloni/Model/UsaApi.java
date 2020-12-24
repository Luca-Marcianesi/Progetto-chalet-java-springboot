package prova.ombrelloni.Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneId;
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
import java.time.LocalDate;

/**
 * @author LucaMarcinesi
 * Classe che si occupa della lettura da Api e della gestione dei risultati
 * 
 *
 */

public class UsaApi {
	/**
	 * Indirizzo dell'api
	 */
	private String url;  
	/**
	 * Oggetto di tipo lista che contiene le previsioni
	 */
	public Lista <Previsioni> lista = new Lista <Previsioni>();
	/**
	 * Giorni con previsioni contenuti nell'api
	 */
	private int giorniDaVedere = 5;
	/**
	 * Previsioni per singolo giono
	 */
	private int scansioniGiornaliere = 8;
	/**
	 * Totale delle previsioni per ora contenute nell api
	 */
	private int scansioniTotali = this.giorniDaVedere * this.scansioniGiornaliere;
	/**
	 * Id della citt' da scansionare
	 */
	private int luogo = 6540261;

	
	
	/**
	 * Valorizza un oggetto di tipo lista con le previsioni a seconda dei valori sopra indicati
	 */
	public void valorizzaListaPrevisioni() {
		 
		JSONObject obj = this.leggiApi(luogo) ;
			
		JSONArray list = (JSONArray) obj.get("list");
			
		for(int i = 0; i < scansioniTotali ; i+=scansioniGiornaliere) {
				
		Previsioni previsione = new Previsioni();
				
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
	}
		
	
	/**
	 * Legge l'api e restituisce il jsonobject corrispondente
	 * @param idCittà id della città di cui leggere l'api
	 * @return il jsonObject che contiene le informazioni
	 */
	private JSONObject leggiApi(int luogo) { 
		
	url = "http://api.openweathermap.org/data/2.5/forecast?id="+luogo+"&appid=fab715b1276e37b8c17a87274e509451";
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
		return obj;
		
	} catch (IOException | ParseException e) {
		e.printStackTrace();
		return null;
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	
	/**
	 * Valorizza l'oggetto previsione per un dato giono
	 * @param giorno Oggetto che contiene la data delle previsioni da ceracare
	 * @return restituisce l'oggetto previsione corrispondente...se non trova il giorno nella lista
	 * restituisce un oggetto con il parametro "principale" contenente : "Previsioni non disponibili"
	 */
	public Previsioni valorizzaPrevisione(LocalDate giorno) {
			
		JSONObject obj = this.leggiApi(this.luogo) ;
		Previsioni previsione = new Previsioni();
		
		if(obj == null) {
		previsione.setCondizioni("Previsioni non disponibili");
		return previsione;
		}
		
		JSONArray list = (JSONArray) obj.get("list");
		
		
		
		for(int i = 0; i < scansioniTotali ; i+=scansioniGiornaliere) {	
					
				JSONObject oggettoLista = (JSONObject) list.get(i);	
				
				long epochDay = (long) oggettoLista.get("dt");
				
				LocalDate controlla = Instant.ofEpochSecond(epochDay).atZone(ZoneId.systemDefault()).toLocalDate();
				
				if(giorno.getDayOfYear() == controlla.getDayOfYear()) {
				
				previsione.setData(epochDay);
				
				JSONObject city = (JSONObject) obj.get("city");
				
				previsione.setNome((String) city.get("name"));
					
				JSONObject main = (JSONObject) oggettoLista.get("main");
				
				
				previsione.setTemperatura((double) main.get("temp")); 
				
				JSONArray weather = (JSONArray) oggettoLista.get("weather");
				
				JSONObject obj2 = (JSONObject) weather.get(0) ;
				
				previsione.setCondizioni((String) obj2.get("main"));
				
				return previsione;
				}
				}
				previsione.setCondizioni("Previsioni non disponibili");
				return previsione;
				
				
				
			
	}
	
	
	
		
	}

