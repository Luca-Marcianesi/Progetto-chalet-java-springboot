package ProgettoOOP.chalet.Model.Spiaggia;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import java.util.HashSet;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiPrenotabili;
import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
import ProgettoOOP.chalet.Model.OtherClass.Previsioni;
import ProgettoOOP.chalet.Model.OtherClass.UsaApi;

/**
 * @author DiegoMignani
 *Classe che gestisce gli ombrelloni della spiaggia
 */
public class ListaOmbrelloni extends ListaOggettiPrenotabili<OggettoPrenotabile>{
	/*
	 * Rappresenta il numero totale di ombrelloni nella spiaggia
	 */
	private int max;
	/*
	 * Vector che contiene gli oggetti della classe Ombrellone
	 */
	private Vector<Ombrellone> lista = new Vector<Ombrellone>();
	/*
	 * Oggetto di tipo previsioni che tiene conto della situazione metereologiche
	*/
	private Previsioni previsione ;
	/*
	 * HashSet che tiene conto di tutte le prenotazioni di ogni ombrellone
	 */
	private HashSet <PrenotazionePosto> listaPrenotazioni= new HashSet <PrenotazionePosto>();
	/*
	 * numero di colonne di una spiaggia di ombrelloni
	 */
	private int colonne;
	/**
	 * Costruttore che calcola il numero totale di ombrelloni,
	 * aggiunge oggetti al vector.
	 * @param righe righe di ombrelloni nella spiaggia
	 * @param colonne colonne di ombrelloni nella spiaggia
	 */
	public ListaOmbrelloni(int righe, int colonne){
		this.colonne = colonne;
		this.max = colonne * righe;						
		for (int p = 0; p<this.max; p++) {
				Ombrellone o = new Ombrellone();
				lista.add(o);
			}
		
	}
	/**
	 * Metodo che gestisce le prenotazioni
	 * controllando lo stato di ogni ombrellone
	 * e le condizioni meteo
	 * @param posto rappresenta il posto di ogni ombrellone
	 * @param nome rappresenta il nome della prenotazione dell'ombrellone
	 * @return l esito della prenotazione
	 */
	public boolean prenota(int posto , String nome) {
		this.setPrevisioni();
		if(previsione.getCondizioni()) {
		for(Ombrellone ombr : lista) {
			if(ombr.getPosizione()==posto) {
				if(ombr.getStato()) {
						ombr.setStato(false);
						this.aggiungiPrenotazione(nome,posto);
						return true;
					}
				return false;
			}	
		}
		}
		return false;
	
	}
	/**
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
	 * @param posto rappresenta la posizione dell'ombrellone nella spiaggia
	 * @return restituisce il risultato della prenotazione
	 */
	public boolean annulla(int posto) {		
		for(Ombrellone ombr : lista) {
			if(ombr.getPosizione()==posto) {
				if(!ombr.getStato()) {
					ombr.setStato(true);
					return true;
					}			
				return false;
			}	
		}
		return false;
		}
	/**
	 * Elimina il contenuto del Vector lista, listaPrenotazioni e l'attributo
	 *  ultimaPosizione della classe Ombrellone
	 */
	public void reset() {
		Ombrellone.resetUltimaPosizione();
		this.lista.clear();
		this.listaPrenotazioni.clear();
		}
	/**
	 * @return ritorna l'HashSet delle prenotazioni
	 */
	public HashSet <PrenotazionePosto> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
	/*
	 * @return restituisce una stringa che rappresenta la posizione degli ombrelloni in una spiaggia
	 */
	public String toString () {
		String spiaggia = "";
		int i = 0;
		boolean prec = true;
		for(Ombrellone ombr : lista) {
			if (i == colonne) {
				spiaggia += "\n";
				i = 0;
			}
			if (ombr.getPosizione()<=10 && i!=0 && !prec) {
				spiaggia += "\t";
				prec = true;
			}
			spiaggia += ombr.toString();
			if (ombr.getStato()) prec = false;
			i++;
		}
		return spiaggia;
		
	}
	/*
	 * Metodo che gestisce l'ordini delle prenotazioni
	 * @param nome rappresenta il nome della persona che ha prenotato
	 * @param posto rappresenta la posizione dell'ombrellone nella spiaggia
	 */
	private void aggiungiPrenotazione(String nome, int posto) {
			PrenotazionePosto prenotazione = new PrenotazionePosto(nome,this.listaPrenotazioni.size()+1, posto);
			this.listaPrenotazioni.add(prenotazione);
	}
	/*
	 * Metodo che imposta le condizioni meteo al tempo attuale
	*/
	private void setPrevisioni() {
		UsaApi api = new UsaApi();
		LocalDate oggi = Instant.ofEpochSecond(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
		this.previsione = api.valorizzaPrevisione(oggi);
		}

}
