package ProgettoOOP.chalet.Model.OtherClass;

import ProgettoOOP.chalet.Model.Server.*;
import ProgettoOOP.chalet.Model.Spiaggia.ListaOmbrelloni;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiPrenotabili;
import ProgettoOOP.chalet.Model.Ristorante.*;
import ProgettoOOP.chalet.Model.Spiaggia.Attrezzatura;


public class Chalet {
	
	private Account proprietario = new Account("admin","admin");
	
	public Server server = new Server ();
	
	public ListaOmbrelloni  listaOmbrelloni;
	
	public Sala listaTavoli = new Sala ();
	
	public ListaOggettiPrenotabili <Evento> listaEventi = new ListaOggettiPrenotabili <Evento> ();
	
	public ListaOggettiPrenotabili <Attrezzatura> listaAttrezzatura = new ListaOggettiPrenotabili <Attrezzatura> ();
	
	public Menu menuVini = new Menu();
	
	public Informazioni listaInfo = new Informazioni();
	
	
	public void creaSpiaggia (int riga, int colonna) {
		this.listaOmbrelloni = new ListaOmbrelloni(riga, colonna);
	}
	
	public Chalet() {
		this.server.aggiungiAccount(proprietario);
		this.listaTavoli.aggiungi(new Tavolo(4));
		this.listaTavoli.aggiungi(new Tavolo(6));
		this.listaTavoli.aggiungi(new Tavolo(3));
	}
	
	public boolean proprietario(String user) {
		if( user.equalsIgnoreCase(this.proprietario.getUsername())) return true;
		else return false;
		
	}
	
}

