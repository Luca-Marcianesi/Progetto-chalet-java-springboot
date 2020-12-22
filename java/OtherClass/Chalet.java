
package altreClassi;
import server.Server;
import Spiaggia.ListaOmbrelloni;
import liste.ListaOggettiPrenotabili;
import ristorante.Tavolo;
import altreClassi.Eventi;
import Spiaggia.Attrezzatura;

public class Chalet {
	
	public Server server = new Server ();
	
	public ListaOmbrelloni listaOmbrelloni;
	
	public ListaOggettiPrenotabili <Tavolo> listaTavoli = new ListaOggettiPrenotabili <Tavolo> ();
	
	public ListaOggettiPrenotabili <Eventi> listaEventi = new ListaOggettiPrenotabili <Eventi> ();
	
	public ListaOggettiPrenotabili <Attrezzatura> listaAttrezzatura = new ListaOggettiPrenotabili <Attrezzatura> ();
	
	
	public Chalet (int riga, int colonna) {
		this.listaOmbrelloni = new ListaOmbrelloni(riga, colonna);
	}
	
	
	
	
}
