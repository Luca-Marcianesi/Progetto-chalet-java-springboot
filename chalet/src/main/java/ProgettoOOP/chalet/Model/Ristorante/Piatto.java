package ProgettoOOP.chalet.Model.Ristorante;

import ProgettoOOP.chalet.Model.Interfacce.OggettoConValore;
import ProgettoOOP.chalet.Model.OtherClass.Prezzo;

/**
 * @author LucaMarcianesi
 * Classe che rappresenta un piatto
 * 
 */

public class Piatto   implements  OggettoConValore {
	
	/**
	 * Codice che rappresentail piatto
	 */
	private  int codice;
	private static int ultimoCodice = 1000;
	/**
	 * Descrizione del piatto
	 */
	private String descrizione;
	/**
	 * Oggetto che rappresenta il prezzo
	 */
	private Prezzo prezzo;
	
	
	/**
	 * Costruttore della classe che genera l'oggetto partendo dalla descrizione e dal prezzo
	 * @param descrizione string che descrive il piatto
	 * @param prezzo float che rappresenta il prezzo
	 */
	public  Piatto(String descrizione , float prezzo ) {
		this.codice = ultimoCodice;
		ultimoCodice++;
		this.descrizione = descrizione;
		this.prezzo = new Prezzo(prezzo);
	}
	
	/**
	 * Modifica la descrizione del piatto
	 * @param descrizione string  descrizione del piatto
	 */
	public void setDescrizione( String descrizione) 	{
		this.descrizione = descrizione ;
		
		}
	
	/**
	 * Modifica la prezzo del piatto
	 * @param prezzo float modifica il prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo.setPrezzo(prezzo) ;
		}
	
	/**
	 * @return int che rappresenta il codice del piatto
	 */
	public int getCodice() {
		return this.codice;
	}
	
	
	/**
	 *@return float ritorna il prezzo del piatto
	 */
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	
	/**
	 * @return string ritorna la descrizione del piatto
	 */
	public String getDescrizione() {
		return this.descrizione;
	}
	
	/**
	 *Trasforma il piatto in una string
	 */
	public String toString() {
		return (  this.codice + this.descrizione + " " + this.prezzo.getPrezzo() + "euro" );
	}
}

