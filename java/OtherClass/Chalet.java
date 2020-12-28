
package altreClassi;



import server.*;

import Spiaggia.ListaOmbrelloni;
import liste.ListaOggettiPrenotabili;
import ristorante.Tavolo;
import Spiaggia.Attrezzatura;

/**
 * @author Edoardo Tarulli
 * @author Luca Marcianesi
 * @author Diego Mignani
 */
public class Chalet {
	
	/**
	 * Creo un nuovo oggetto "propietario" della classe Account , di tipo private, e gli passo come parametri delle 
	 * credenziali generiche "admin" "admin".
	 */
	private Account proprietario = new Account("admin","admin");
	
	/**
	 * Creo un nuovo oggetto "server" di tipo public della classe server.
	 */
	public Server server = new Server ();
	
	/**
	 * Creo un nuovo oggetto "listaOmbrelloni" della classe ListaOmbrelloni non inizializzato.
	 */
	public ListaOmbrelloni  listaOmbrelloni;
	
	/**
	 * @param <Tavolo> Viene creata una nuova ListaOggettiPrenotabili per la gestione dei Tavoli.
	 */
	public ListaOggettiPrenotabili <Tavolo> listaTavoli = new ListaOggettiPrenotabili <Tavolo> ();
	
	/**
	 * @param <Eventi> Viene creata una nuova ListaOggettiPrenotabili per la gestione degli Eventi.
	 */
	public ListaOggettiPrenotabili <Eventi> listaEventi = new ListaOggettiPrenotabili <Eventi> ();
	
	/**
	 * @param <Attrezzatura> Viene creata una nuova ListaOggettiPrenotabili per la gestione dell'Attrezzatura.
	 */
	public ListaOggettiPrenotabili <Attrezzatura> listaAttrezzatura = new ListaOggettiPrenotabili <Attrezzatura> ();
	
	
	/**
	 * Metodo public creaSpiaggia che prende in ingresso i seguenti parametri:
	 * @param riga = si sceglie il numero di righe
	 * @param colonna = si sceglie il numero di colonne
	 * Mettendo insieme righe e colonne scelte questo metodo crea la spiaggia in base alla grandezza di esse.
	 */
	public void creaSpiaggia (int riga, int colonna) {
		this.listaOmbrelloni = new ListaOmbrelloni(riga, colonna);
	}
	
	/**
	 * Il costruttore della classe Chalet prende il metodo aggiungiAccount della classe server e 
	 * prende come parametro il propietario. Serve per creare l'account del propietario che è l'unico
	 * che può effettuare delle modifiche al menù, alla spiaggia etc.
	 */
	public Chalet() {
		this.server.aggiungiAccount(proprietario);
	}
	
	/** Metodo propietario che prende in ingresso una stringa "user". 
	 * @param user. 
	 * @return Se la stringa inserita è uguale all'Username inserito dal propietario quando è stato creato 
	 * l'account e quindi ogni volta che quest'ultimo effettua il login, restituisce true altrimenti 
	 * restituisce false (ciò significa che non è il propietario)
	 */
	public boolean proprietario(String user) {
		if( user == this.proprietario.getUsername()) return true;
		else return false;
		
	}
	
}
