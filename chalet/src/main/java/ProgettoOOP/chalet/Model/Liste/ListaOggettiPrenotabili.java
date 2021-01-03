package ProgettoOOP.chalet.Model.Liste;

import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;

/**
 * @author Luca Marcianesi
 * Classe che estende la piÃƒÂ¹ generale lista e si occupa delle operazioni
 * utili sulle liste di oggettoPrenotabile
 *
 * @param <T> generico oggetto oggettoPrenotabile
 */
public class ListaOggettiPrenotabili<T extends OggettoPrenotabile>  extends Lista<T>{
	
	/**
	 * Permette di prenotare un certo oggetto a partire dal nome dell'oggetto(richiesta) 
	 * e dal nome di chi fa la prenotazione (nome)
	 * Scorre la lista di oggetti e fa due verifiche: 1) se esiste un oggetto con lo stesso nome della 
	 * richiesta. 2) Verifica se quell'oggetto è disponibile.
	 * Se lo trova ed è disponibile modifica lo stato dell'oggetto e aggiunge la prenotazione all'oggetto
	 * @param richiesta nome dell'oggetto
	 * @param nome nome di chi fa la prenotazione
	 * @return ritorna vero se la prenotazione è andata a buon fine altrimenti torna false
	 */
	public boolean prenota (String richiesta , String nome) {
		for(T elemento : super.lista) {
			
			if(richiesta.equalsIgnoreCase(elemento.getTipo()) && elemento.getStato()) {
				elemento.setStato(false);
				elemento.aggiungiPrenotazione(nome);
				return true;
			}	
	}
	return false;
	}
	
}
