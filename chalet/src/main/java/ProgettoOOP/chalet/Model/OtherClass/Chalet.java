package ProgettoOOP.chalet.Model.OtherClass;

import ProgettoOOP.chalet.Model.Server.*;
import ProgettoOOP.chalet.Model.Spiaggia.ListaOmbrelloni;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiPrenotabili;
import ProgettoOOP.chalet.Model.Ristorante.*;
import ProgettoOOP.chalet.Model.Spiaggia.Attrezzatura;


public class Chalet {
	
	/**
	 * Account del proprietario
	 */
	private Account proprietario = new Account("admin","admin");
	
	/**
	 * Server dello chalet
	 */
	public Server server = new Server ();
	
	/**
	 * Lista degli ombrelloni
	 */
	public ListaOmbrelloni  listaOmbrelloni;
	
	/**
	 * Lista dei tavoli
	 */
	public Sala listaTavoli = new Sala ();
	
	/**
	 * Lista degli eventi
	 */
	public ListaOggettiPrenotabili <Evento> listaEventi = new ListaOggettiPrenotabili <Evento> ();
	
	/**
	 * Lista delle attrezzature
	 */
	public ListaOggettiPrenotabili <Attrezzatura> listaAttrezzatura = new ListaOggettiPrenotabili <Attrezzatura> ();
	
	/**
	 * menu dei vini
	 */
	public Menu menuVini = new Menu();
	
	/**
	 * Lista delle informazioni
	 */
	public Informazioni listaInfo = new Informazioni();
	
	
	/**
	 * Permette di creare la spiaggia se esiste già la resetta
	 * @param riga numero di righe
	 * @param colonna numero di colonne
	 */
	public void creaSpiaggia (int riga, int colonna) {
		if(this.listaOmbrelloni != null) this.listaOmbrelloni.reset();
		this.listaOmbrelloni = new ListaOmbrelloni(riga, colonna);
	}
	
	/**
	 * Costruttore che aggiunge il proprietario ed alcuni oggetti 
	 * allo chalet
	 */
	public Chalet() {
		this.server.aggiungiAccount(proprietario);
		this.listaTavoli.aggiungi(new Tavolo(4));
		this.listaTavoli.aggiungi(new Tavolo(6));
		this.listaTavoli.aggiungi(new Tavolo(3));
	}
	
	/**
	 * Metedo che confronta username con quello del proprietario
	 * @param user username da confrontare
	 * @return ritorna true se l'user è quello del prop altrimenti false
	 */
	public boolean proprietario(String user) {
		if( user.equalsIgnoreCase(this.proprietario.getUsername())) return true;
		else return false;
		
	}
	
}

