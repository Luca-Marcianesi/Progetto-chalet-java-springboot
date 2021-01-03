package ProgettoOOP.chalet.Model.Spiaggia;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import ProgettoOOP.chalet.Model.OtherClass.Prezzo;
import ProgettoOOP.chalet.Model.Interfacce.*;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
import ProgettoOOP.chalet.Model.OtherClass.Previsioni;
import ProgettoOOP.chalet.Model.OtherClass.UsaApi;

/*
 * @author DiegoMignani
 * Classe che rappresenta le varie 
 * attrezzature da prenotare.
 * Implementa l'interfaccia OggettoPrenotabile
 */
	public class Attrezzatura implements OggettoPrenotabile , OggettoConValore{
	/*
	 * Descrizione della tipologia di attrezzatura
	 */
	private String tipo;
	/*
	 * Prezzo del singolo elemento
	 */
	private Prezzo prezzo = new Prezzo(0);
	/*
	 * Descrizione dello stato della prenotazione:
	 * - Se true oggetto è libero
	 * - Se false oggetto è occupato
	 */
	private boolean stato = true;
	/*
	 * Oggetto che rappresenta la prenotazione e
	 * che tiene conto del numero di Attrezzi prenotati
	 */
	private Prenotazione prenotazione;
	/*
	 * Costruttore che assegna all'oggetto di tipo Attrezzatura 
	 * i propri parametri
	 * @param tipo rappresenta la tipologia dell'attrezzatura
	 * @param prezzo del singolo elemento
	 */
	public Attrezzatura(String tipo, float prezzo) {
		this.tipo = tipo;
		this.prezzo.setPrezzo(prezzo);;
		
	}
	/*
	 * Crea un oggetto prenotazione con il nome dell'attrezzatura desiderata
	 * @param nome della persona che ha prenotato
	 */
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome,0);
	}
	/*
	 * @return restituisce lo stato della prenotazione dell'oggetto
	 */
	public boolean getStato() {
		if(this.previsioni() &&  this.stato) return true;
		else return false;
		}
	/*
	 * Imposta il nuovo stato dell'oggetto
	 * @param stato dell'attrezzatura se è libera o no
	 */
	public void setStato(boolean stato) {
		this.stato = stato;
		}
	/*
	 * @return restituisce la tipologia dell'oggetto
	 */
	public String getTipo() {return this.tipo;}
	/*
	 * @return restituisce la visualizzazione grafica dei parametri più importanti dell'oggetto
	 */
	public String toString() {
		return(this.tipo + " " + this.prezzo + " Stato: " + this.statoString());
	}
	
	/*
	 * @return restituisce il prezzo dell'oggetto
	 */
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	
	/*
	 * @return restituisce l'oggetto prenotazione associato all'attrezzatura prenotata
	*/
	public Prenotazione getPrenotazione() {
		return this.prenotazione;
	}
	/*
	 * @return restituisce la stringa dell'esito della prenotazione
	 */
	private String statoString() {
		if(this.stato) return ("libero");
		else return ("prenotato");
	}
	/*
	 * @return restituisce true se le condizioni metereologiche di oggi permettono una 
	 * prenotazione. Altrimenti restituisce false.
	*/
	private boolean previsioni() {
		UsaApi api = new UsaApi();
		Previsioni previsione = new Previsioni();
		LocalDate oggi = Instant.ofEpochSecond(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
		previsione = api.valorizzaPrevisione(oggi);
		return previsione.getCondizioni();
		}
}
