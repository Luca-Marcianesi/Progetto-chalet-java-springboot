package Ristorante;
import Liste.ListaOggettiPrenotabili;
 /*
 * @author DiegoMignani
 * Classe che eredita da ListaOggettiPrenotabili.
 * Gestisce l'elenco dei tavoli in una sala del ristorante.
 */
public class Sala extends ListaOggettiPrenotabili<Tavolo>{
	
	/*
	* Metodo che gestisce l'elenco delle prenotazioni dei tavoli dentro al ristorante
	* prendendo in input:
	* @param la stringa della richiesta
	* @param la stringa nome a cui si vuole intestare la prenotazione
	* @param il numero di persone per cui si vuole prenotare
	* @return un booleano se l'operazione è andata a buon fine o no
	*/
	public boolean prenota(String richiesta,String nome,int numPers){
		for(Tavolo tavolo : super.lista) {
			
			if(richiesta.equalsIgnoreCase(tavolo.getTipo()) && tavolo.getStato()&&tavolo.controlloPosti(numPers)) {
				tavolo.setStato(false);
				tavolo.aggiungiPrenotazione(nome);
				return true;
			}	
	}
	return false;
	}
	
	}
