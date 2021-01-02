package ProgettoOOP.chalet.Model.OtherClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Vector;
import java.time.LocalDate;
import java.lang.NullPointerException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import java.lang.ClassCastException;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiConValore;
import ProgettoOOP.chalet.Model.Ristorante.Piatto;

/**
 * @author LucaMarcinesi
 * Classe che si occupa della lettura da Api e della gestione dei risultati
 * 
 *
 */

public class UsaApi {
	/**
	 * Indirizzo dell'api per il meteo
	 */
	private String urlMeteo = "http://api.openweathermap.org/data/2.5/forecast?id=6540261&appid=fab715b1276e37b8c17a87274e509451";  
	
	/**
	 * Indirizzo dell'api per il vino
	 */
	private String urlVini = "https://api.spoonacular.com/food/wine/recommendation?wine=merlot&number=10&apiKey=62f8d2a4877f45d29f4f00d66818c72e";
	
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
	 * Valorizza un oggetto di tipo lista con le previsioni a seconda dei valori sopra impostati(scansioniTotali  e scansioniGiornaliere)
	 *
	 * @return Lista previsioni 
	 */
	public ListaOggettiConValore<Previsioni> valorizzaListaPrevisioni() {
		 
		JSONObject obj = this.leggiApi(this.urlMeteo) ;
		
		ListaOggettiConValore<Previsioni> lista = new ListaOggettiConValore<Previsioni>();
			
		JSONArray list = (JSONArray) obj.get("list");
			
		for(int i = 0; i < scansioniTotali ; i+=scansioniGiornaliere) {
				
		Previsioni previsione = new Previsioni();
				
		JSONObject oggettoLista = (JSONObject) list.get(i);	
		
		try {
			
		previsione.setData((long) oggettoLista.get("dt"));
			
		JSONObject city = (JSONObject) obj.get("city");
			
		previsione.setNome((String) city.get("name"));
				
		JSONObject main = (JSONObject) oggettoLista.get("main");
			
		previsione.setTemperatura((double) main.get("temp")); 
		}
		catch(ClassCastException e) {
			return null;	
		}
			
		JSONArray weather = (JSONArray) oggettoLista.get("weather");
			
		JSONObject obj2 = (JSONObject) weather.get(0) ;
			
		previsione.setCondizioni((String) obj2.get("main"));
			
		lista.aggiungi(previsione);
			}
		return lista;
	}
		
	
	/**
	 * Legge l'api e restituisce il jsonobject corrispondente
	 * @param url dell'api da leggere
	 * @return il jsonObject che contiene le informazioni
	 */
	private JSONObject leggiApi(String url) { 
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
	 * Valorizza l'oggetto previsione per un dato giono prendendo i parametri
	 * data,nome città ,Condizioni Principali(main) e temperatura
	 * @param data Oggetto che contiene la data delle previsioni da ceracare
	 * @return restituisce l'oggetto previsione corrispondente...se non trova il
	 *  giorno nella lista restituisce un oggetto con il parametro "principale" 
	 *  contenente : "Previsioni non disponibili"
	 *  Può generare due eccezzioni ClassCastException se è sbagliato il casting
	 *  dei dati  NullPointerException se l'oggetto data è nullo
	 */
	public Previsioni valorizzaPrevisione(LocalDate data) {
			
		JSONObject obj = this.leggiApi(this.urlMeteo) ;
		Previsioni previsione = new Previsioni();
		
		if(obj == null) {
		previsione.setCondizioni("Previsioni non disponibili");
		return previsione;
		}
		
		JSONArray list = (JSONArray) obj.get("list");
		
		
		
		for(int i = 0; i < scansioniTotali ; i+=scansioniGiornaliere) {	
					
				JSONObject oggettoLista = (JSONObject) list.get(i);	
				try {
					
					long epochDay = (long) oggettoLista.get("dt");
				
					LocalDate controlla = Instant.ofEpochSecond(epochDay).atZone(ZoneId.systemDefault()).toLocalDate();
					
					if(data.getDayOfYear() == controlla.getDayOfYear()) {
				
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
				catch(ClassCastException | NullPointerException e) {
					previsione.setCondizioni("Previsioni non disponibili");
					return previsione;
				}
				}
				previsione.setCondizioni("Previsioni non disponibili");
				return previsione;		
	}
	
	/**
	 * Prende il JSONObject della lettura dell'api con l url dei vini e valorizza 
	 * un vector con i primi 5 vini restituiti dall api prendendone la  Descrizione
	 * @return Vector di oggetti di tipo piatto
	 */
	public Vector <Piatto> valorizzaMenu() {
		JSONObject obj = this.leggiApi(this.urlVini);
		JSONArray list = (JSONArray) obj.get("recommendedWines");
		Vector <Piatto> lista = new Vector <Piatto>();
		for(int i = 1 ; i < 5 ; i++) {
			JSONObject bottiglia = (JSONObject) list.get(i);
			String descrizione = (String)bottiglia.get("title");
			Piatto a = new Piatto(descrizione,0);
			lista.add(a);
		}
		return lista;
		
	}
	
	
	
		
	}


