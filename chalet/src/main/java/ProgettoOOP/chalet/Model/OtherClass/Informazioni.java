package ProgettoOOP.chalet.Model.OtherClass;

import java.time.LocalDate;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiConValore;

/**
 * @author LucaMarcianesi
 *Gestisce le informazioni dello chalet
 */
public   class Informazioni {
	
	/**
	 * Lista che contiene le previsioni per fate la media
	 */
	private ListaOggettiConValore<Previsioni> listaPrevisioni = new ListaOggettiConValore<Previsioni>();
	/**
	 * Previsione del giorno
	 */
	private Previsioni previsione = new Previsioni();
	/**
	 * Oggetto per usare l'api 
	 */
	private UsaApi api = new UsaApi();
	/**
	 *  float Media temperatura settimana
	 */
	private  float temperaturaMedia;
	
	/**
	 * Costruttore che imposta le previsioni di oggi , la lista delle previsioni per qualche giorno
	 * e imposta la temperatura media
	 */
	public Informazioni() {
		LocalDate oggi = LocalDate.now();
		this.previsione = api.valorizzaPrevisione(oggi);
		this.listaPrevisioni = api.valorizzaListaPrevisioni();
		this.temperaturaMedia = this.listaPrevisioni.media();
		
	}
	
	/**
	 * @return restituisce la previsione per oggi
	 */
	public Previsioni getPrevisione() {
		return this.previsione;
	}
	
	/**
	 * @return float retituisce la temp media
	 */
	public float getTemperaturaMedia() {
		return this.temperaturaMedia;
	}

}


