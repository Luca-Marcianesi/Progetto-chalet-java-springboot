package ProgettoOOP.chalet.Model.Ristorante;

import java.util.Vector;
import ProgettoOOP.chalet.Model.OtherClass.UsaApi;

/**
 * @author Luca
 *Classe che gestisce il menÃƒÂ¹
 */
public class Menu {
	/**
	 * Oggetto che contiene l'elenco dei piatti
	 */
	private Vector<Piatto> menu;
	private UsaApi api = new UsaApi();
	
	public Menu() {
	this.menu = api.valorizzaMenu();
		
	}
	/**
	 * Aggiunge un oggetto piatto al menÃƒÂ¹
	 * @param descrizione string descrizione del piatto
	 * @param prezzo float il prezzo del piatto
	 */
	public void add_menu(String descrizione, float prezzo) {
		Piatto piatto = new Piatto(descrizione,prezzo);
		this.menu.add(piatto);	
		}
	
	public void setPrezzo(int codice,float prezzo) {
		for(Piatto piatto : this.menu) if(piatto.getCodice() == codice ) piatto.setPrezzo(prezzo);
	}
	
	/**
	 * Elimina il  piatto con il codice dall'elenco 
	 * @param codice int codice del piatto da eliminare
	 */
	public void eliminaDalMenu( int codice ) {
		for(Piatto piatto : this.menu) if(piatto.getCodice() == codice ) this.menu.remove(piatto);	
		}
	
	public Vector<Piatto> getLista() {
		return this.menu;
	}
	
	/**
	 *Trasforma il menÃƒÂ¹ in striga
	 */
	public String toString() {
		String stringa="";
		for(Piatto piatto : this.menu)  stringa += (piatto +"\n");
		return stringa;			
	}
}


