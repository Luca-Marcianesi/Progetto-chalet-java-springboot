package Spiaggia;
import Interfacce.OggettoPrenotabile;
import OtherClass.Prenotazione;

/*
 * @author DiegoMignani
 * Classe che rappresenta le varie 
 * attrezzature da prenotare.
 * Implementa l'interfaccia OggettoPrenotabile
 */
public class Attrezzatura implements OggettoPrenotabile{
	/*
	 * Descrizione della tipologia di attrezzatura
	 */
	private String tipo;
	/*
	 * Prezzo del singolo elemento
	 */
	private float prezzo;
	/*
	 * Descrizione dello stato della prenotazione:
	 * - Se true oggetto è libero
	 * - Se false oggetto è occupato
	 */
	private boolean stato = true;
	/*
	 * Oggetto che rappresenta la prenotazione e
	 *  che tiene conto del numero di Attrezzi prenotati
	 */
	private Prenotazione prenotazione;
	/*
	 * Costruttore che assegna all'oggetto di tipo Attrezzatura 
	 * i propri parametri
	 */
	public Attrezzatura(String tipo, float prezzo) {
		this.tipo = tipo;
		this.prezzo = prezzo;
	}
	/*
	 * Crea un oggetto prenotazione con il nome dell'attrezzatura desiderata
	 */
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome);
	}
	/*
	 * @return restituisce lo stato della prenotazione dell'oggetto
	 */
	public boolean getStato() {
		return this.stato;
	}
	/*
	 * Imposta il nuovo stato dell'oggetto
	 */
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	/*
	 * @return restituisce la tipologia dell'oggetto
	 */
	public String getTipo() {
		return this.tipo;
	}
	/*
	 * @return restituisce il prezzo dell'oggetto
	 */
	public float getPrezzo() {
		return this.prezzo;
	}
	/*
	 * @return restituisce la visualizzazione grafica dei parametri più importanti dell'oggetto
	 */
	public String toString() {
		return(this.tipo + " " + this.prezzo + " Stato: " + this.statoString());
	}
	/*
	 * @return restituisce la rappresentazione grafica dell'esito della prenotazione
	 */
	private String statoString() {
		if(this.stato) return ("libero");
		else return ("prenotato");
	}
	
	
	
	
}
