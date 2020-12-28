package OtherClass;

import Server.*;
import Spiaggia.ListaOmbrelloni;
import Liste.ListaOggettiPrenotabili;
import Ristorante.Tavolo;
import Spiaggia.Attrezzatura;

public class Chalet {
	
	private Account proprietario = new Account("admin","admin");
	
	public Server server = new Server ();
	
	public ListaOmbrelloni  listaOmbrelloni;
	
	public ListaOggettiPrenotabili <Tavolo> listaTavoli = new ListaOggettiPrenotabili <Tavolo> ();
	
	public ListaOggettiPrenotabili <Eventi> listaEventi = new ListaOggettiPrenotabili <Eventi> ();
	
	public ListaOggettiPrenotabili <Attrezzatura> listaAttrezzatura = new ListaOggettiPrenotabili <Attrezzatura> ();
	
	
	public void creaSpiaggia (int riga, int colonna) {
		this.listaOmbrelloni = new ListaOmbrelloni(riga, colonna);
	}
	
	public Chalet() {
		this.server.aggiungiAccount(proprietario);
	}
	
	public boolean proprietario(String user) {
		if( user == this.proprietario.getUsername()) return true;
		else return false;
		
	}
	
}
