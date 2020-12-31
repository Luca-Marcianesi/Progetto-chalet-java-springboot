package Spiaggia;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import Liste.ListaOggettiPrenotabili;
import Interfacce.OggettoPrenotabile;
import OtherClass.PrenotazionePosto;
import OtherClass.Previsioni;
import prova.ombrelloni.Model.UsaApi;
import java.util.HashSet;

/*
 * @author DiegoMignani
 * Classe che gestisce gli ombrelloni della spiaggia
 */
public class ListaOmbrelloni extends ListaOggettiPrenotabili<OggettoPrenotabile>{
	/*
	 * Rappresenta il numero totale di ombrelloni nella spiaggia
	 */
	private int max;
	
	/*
	 * Lista che contiene gli oggetti della classe Ombrellone
	 */
	private Vector<Ombrellone> lista = new Vector<Ombrellone>();
	
	/*
	 * Oggetto che tiene conto delle previsioni meteorologiche 
	 */
	private Previsioni previsione ;
	
	/*
	 * Lista che tiene conto di tutte le prenotazioni
	 */
	private HashSet <PrenotazionePosto> listaPrenotazioni= new HashSet <PrenotazionePosto>();
	
	/*
	 * Costruttore che calcola il numero totale di ombrelloni
	 * e aggiunge oggetti alla lista.
	 * @param righe di ombrelloni nella spiaggia
	 * @param colonne di ombrelloni nella spiaggia
	 */
	public ListaOmbrelloni(int righe, int colonne){
		this.max = colonne * righe;						
		for (int p = 0; p<this.max; p++) {
				Ombrellone o = new Ombrellone();
				lista.add(o);
			}
		
	}
	
	/*
	 * Metodo che gestisce le prenotazioni controllando lo stato di ogni ombrellone, le previsioni metereologiche
	 * e visualizza l'esito della prenotazione inserendo il posto dell'ombrellone che si vuole prenotare e il nome.
	 * @param posto rappresenta il posto di ogni ombrellone
	 * @param nome rappresenta il nome della prenotazione dell'ombrellone
	 */
	public boolean prenota(int posto , String nome) {
		this.setPrevisioni();
		if(previsione.getCondizioni()) {
		for(Ombrellone ombrellone : lista) {
			if(ombrellone.getPosizione()==posto) {
				if(ombrellone.getStato()) {
						ombrellone.setStato(false);
						this.aggiungiPrenotazione(nome,posto);
						return true;
					}
				return false;
			}	
		}
		}
		return false;
	}
	
	/*
	 * @return restituisce gli ombrelloni disponibili che ci sono nella spiaggia
	 */
	public int postiDisponibili() {
		int disponibili = 0;
		for (Ombrellone ombrellone : lista) if(ombrellone.getStato()) disponibili++;
		return disponibili;
	}
	
	/**
	 * Metotodo che fa annullare la prenotazione di un ombrellone
	 * controllando lo stato di ognuno
	 * e visualizza a schermo l'esito
	 * @param posto rappresenta la posizione dell'ombrellone nella spiaggia
	 * @return restituisce il risultato della prenotazione
	 */
	public boolean annulla(int posto) {		
		for(Ombrellone ombrellone : lista) {
			if(ombrellone.getPosizione()==posto) {
				if(!ombrellone.getStato()) {
					ombrellone.setStato(true);
					return true;
					}			
				return false;
			}	
		}
		return false;
		}
	
	/*
	 * Reimposta lo stato della prenotazione dei singoli ombrelloni
	 */
	public void Reset() {
		for(Ombrellone k : lista) k.setStato(true);
		}
	
	/*
	 * @return ritorna la lista delle prenotazioni
	 */
	public HashSet <PrenotazionePosto> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
	
	/*
	 * Metodo aggiunge la singola prenotazione alla lista delle prenotazioni
	 * @param nome rappresenta il nome della persona che ha prenotato
	 * @param posto rappresenta la posizione dell'ombrellone nella spiaggia
	 */
	private void aggiungiPrenotazione(String nome , int posto) {
		
			PrenotazionePosto prenotazione = new PrenotazionePosto(nome,this.listaPrenotazioni.size()+1, posto);
			this.listaPrenotazioni.add(prenotazione);
		}
		
	/*
	 * Metodo che reimposta le condizioni metereologiche attuali
	 */
	private void setPrevisioni() {
		UsaApi api = new UsaApi();
		LocalDate oggi = Instant.ofEpochSecond(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
		this.previsione = api.valorizzaPrevisione(oggi);
		}
	
	
	
}
