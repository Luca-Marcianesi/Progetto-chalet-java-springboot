package ProgettoOOP.chalet.Model.OtherClass;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;
import ProgettoOOP.chalet.Model.Interfacce.OggettoConValore;

/**
 * @author LucaMarcianesi
 * @author EdoardoTarulli
 * Classe che gestisce le previsioni meteorologiche di un giorno
 *
 */
public class Previsioni implements OggettoConValore{
		
		 /**
		 * String che contiene il nome della città
		 */
		private String nome;
		 
		 /**
		 * Oggetto che contiene la data relativa alle previsioni
		 */
		private LocalDate data;
		 
		 /**
		 * String che contiene le condizioni pricipali che descrivono le previsioni
		 */
		private String principale;
		 
		 /**
		 * double che contiene la temperatura in kelvin
		 */
		protected double temperatura;
		 
		  
		 /**
		 * @return ritorna il nome della cittÃƒÂ 
		 */
		public String getNome() {
			 return this.nome;
		 }
		 
		 /**
		 * @return ritorna la stringa con le condizioni atmosferiche
		 */
		public String getPrincipale() {
			 return this.principale;
		 }
		 
		 /**
		  * Imposta la temperatura
		 * @param temperatura la temperatura da inserire
		 */
		public void setTemperatura (double temperatura) {
			 this.temperatura = temperatura ;
		 }
		 
		 /**
		 * @return float ritorna la temperatura
		 */
		public float getValore() {
				return (float)this.temperatura;
			}
		
		 /**
		 * @return ritorna la data della previsione
		 */
		public LocalDate getData() {
			 return this.data;
		 }
		 
		 /**
		  * Imposta il nome della cittÃƒÂ 
		 * @param nome il nome da inserire
		 */
		public void setNome ( String nome ) {
			 this.nome = nome;
		 } 
		 
		 /**
		  * Imposta la data alla previsione meteo
		  * Converte il long (unix epoch) in una data
		 * @param ora long della data in UnixEpoch
		 */
		public void setData (long ora) {
			this.data = Instant.ofEpochSecond(ora).atZone(ZoneId.systemDefault()).toLocalDate();
		 }
		
		/**
		 * Imposta la condizione meteorologica
		 * Dalla string "traduce" in italiano e lo imposta nella string principale della classe
		 * @param principale la string che contiene le condizioni
		 */
		public void setCondizioni( String principale) { 
			switch(principale) {
			case "Clear" : 
				 this.principale = ("Bel tempo"); 
				 break;
			case "Clouds" : 
				this.principale = ("Ci sono un po' di nuvole");
				 break;
			case "Drizzle" : 
				this.principale = ("Sta piovigginando"); 
				 break;
			case "Rain" : 
			case "Thunderstorm" : 
			case "Snow" : 
				this.principale = ("Brutto tempo!"); 
				 break;
			case "Previsioni non disponibili":
				this.principale = ("Previsioni non disponibili");
				break;
			default : 
				this.principale = ("Condizioni Particolari"); break;
				
			}
			}
			/**
			 * Ritorna un bool che rappresenta le previsioni true(bel tempo le previsioni non sono disp.) false (brutto tempo)
			 * @return true(Non piove o le previsioni non sono disp.) false (brutto tempo)
			 */
			public boolean getCondizioni() {
				switch (this.principale) {
				  case "Bel tempo" : 
						return true;
				  case "Ci sono un po' di nuvole" : 
						return true;
				  case "Sta piovigginando" : 
						return true;
				  case "Previsioni non disponibili":
					  return true;		
				  default :
					  	return false;
							}
			}
			
			/**
			 *Trasforma la previsione in stringa
			 */
			public String toString () {
			 return ( "Nome cittÃƒÂ : " + this.nome + "\ndata: " + this.data + "\ntemperatura: " +  this.temperatura
					 + " Ã‚Â°C\ncondizioni meteo: " + this.principale );	 
		 }
		
	}
