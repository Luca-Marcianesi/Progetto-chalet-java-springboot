package ProgettoOOP.chalet.Model.Spiaggia;

import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
import ProgettoOOP.chalet.Model.OtherClass.Prezzo;

/*
 * @author DiegoMignani
 * Classe che rappresenta l'ombrellone in una spiaggia
 */	
public class Ombrellone implements OggettoPrenotabile{
	/*
	 * Attributo utile per l'interfaccia OggettoPrenotabile
	 */	
	private String tipo = "ombrellone";
	/*
	 * Numero che rappresenta la posizione dell'ombrellone nella spiaggia
	 */
	private int posizione ;	
	/*
	 * Attributo che descrive lo stato della prenotazione:
	 * - Se true l'ombrellone è libero
	 * - Se false l'ombrellone è occupato
	 */
	private boolean stato = true;
	/*
	 * Attributo che tiene conto dell'ultima Posizione dell'ombrellone
	 */
	private static int ultimaPosizione = 1;
	/*
	 * Oggetto che rappresenta la prenotazione del singolo ombrellone
	 */
	public Prenotazione prenotazione;
	/*
	 * Prezzo dell'ombrellone
	*/
	private Prezzo prezzo = new Prezzo(0) ;
	/*
	 * Costruttore che tiene il conto delle posizioni
	 */
	public Ombrellone() {
		this.posizione = ultimaPosizione;
		ultimaPosizione++;
	}
	/*
	 * Metodo utile per l'inserimento di una nuova prenotazione
	 * @param nome rappresenta il nome della persona che ha fatto la prenotazione
	 */
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome,0);
	}
	/*
	 * @return restituisce dell'attributo posizione
	 */
	public int getPosizione() {
		return this.posizione;
		}
	/*
	 * @return restituisce lo stato dell'ombrellone
	 */
	public boolean getStato() {
		return stato;
		}
	/*
	 * @return restituisce il tipo dell'oggetto
	 */
	public String getTipo() {
		return this.tipo;
		}
	/*
	 * Reimposta lo stato dell'ombrellone
	 * @param libero rappresenta il nuovo stato dell'oggetto ombrellone
	 */
	public void setStato(boolean libero) {
		this.stato = libero;
		if(stato) this.prenotazione = null;
		}
	/*
	 * @return restituisce l'oggetto "prezzo" dell'ombrellone
	*/
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	/*
	 * @return restituisce la stringa della situazione dell'ombrellone
	 */
	public String toString() {
		if(this.stato) return("\t["+ this.posizione +"]");
		else return ("\t["+ this.posizione + "X"+"]");
		
	} 
}
