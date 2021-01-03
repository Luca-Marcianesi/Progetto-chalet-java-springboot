package ProgettoOOP.chalet.Model.OtherClass;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Vector;
import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
/**
 * @author DiegoMignani
 *Classe che contiene le informazioni di un Evento
 */
public class Evento implements OggettoPrenotabile {
	
	/**
	 *Variabile che contiene la data dell'evento
	 */
	private LocalDate data;
	/**
	 * String che contiene il nome dell'evento
	 */
	private String nome;
	/**
	 * int numero massimo dei partecipanti
	 */
	private int max;
	/**
	 * int numero persone prenotate per l'evento
	 */
	private int prenotati;
	/**
	 * Oggetto che contiene le previsioni meteo per quella giornata
	 */
	private Previsioni previsione;
	/**
	 * Oggetto che contiene il prezzo dell' evento
	 */
	private Prezzo prezzo;
	
	/**
	 * Vector che contiene  le prenotazioni per l'evento 
	 */
	private Vector <Prenotazione> listaPrenotazioni= new Vector <Prenotazione>();
			
	/**
	 * Costruttore della classe evento
	 * @param max numero massimo di persone ammesse
	 * @param nome nome dell'evento
	 * @param anno anno dell'evento
	 * @param mese  mese in cui si svolge l'evento
	 * @param giorno giorno in cui si svolge l'evento
	 * @param prezzo prezzo dell'evento
	 */
	public Evento (String nome , int max  ,int anno, int mese, int giorno,float prezzo) {
		try {
		data =  LocalDate.of(anno,mese,giorno);
		}
		catch(DateTimeException e) {
		}
		this.max = max;
		this.nome = nome;
		this.setPrevisioni();
		this.prezzo = new Prezzo(prezzo);
		
	}
	
	/**
	 * @return ritorna la data dell'evento
	 */
	public LocalDate getData() {
		return this.data;
	}
	
	/**
	 * @return ritorna il numero intero di posti disponibili
	 */
	public int getDisponibili() {
		return this.max - this.prenotati;
	}
		
	/**
	 * @param nome attribuisce il nome dell'evento
	 */
	public void setTipo(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return ritorna la stringa con il nome dell'evento
	 */
	public String getTipo() {
		 return this.nome; 
	}
	
	/**
	 * Effettua un primo controllo sulle condizioni meteo e un secondo sulla 
	 * disponibilita' di posti per l'evento
	 *@return ritorna true ovvero evento disponibile se le condizioni meteo lo permettono e
	 *è disponibile un posto disponibile altrimenti ritorna false
	 */
	public boolean getStato() {
		if(this.previsione.getCondizioni()) {
		if(max-prenotati>0)return true;
		else return false;
		}else return false;
	}
	
	/**
	 *Incrementa il numero di prenotati di 1
	 */
	public void setStato(boolean stato) {
		if(!stato) this.prenotati++;
	}
	
	/**
	 * Fissa il numero massimo di persone per l'evento
	 * @param max numero massimo di persone
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	/**
	 * @return ritorna il numero massimo di persone per l'evento
	 */
	public int getMax() {
		return this.max;
	}
	
	/**
	 * @return ritorna il vector che contiene le prenotazioni per l'evento
	 */
	public Vector <Prenotazione> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
	
	/**
	 *Aggiunge una prenotazione prendendo come parametro il nome
	 */
	public void aggiungiPrenotazione(String nome) {
		Prenotazione prenotazione = new Prenotazione(nome, this.listaPrenotazioni.size()+1);
		this.listaPrenotazioni.add(prenotazione);
	}
	
	/**
	 *Trasforma l'evento in string
	 */
	public String toString () {
		return("\nDescrizione dell'evento: \t" + nome +
							"\nOrario dell'evento: \t\t" + this.data +
							"\nPosti liberi: \t\t\t" + (this.max-this.prenotati) + '\n' );
		
	}
	
	/**
	 * @return ritorna l'oggetto che contiene le previsioni meteo per l'evento
	 */
	public Previsioni getPrevisione() {
		return this.previsione;
		
	}
	
	/**
	 * Restituisce il prezzo dell'evento
	 * @return float il prezzo del evento
	 */
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	
	/**
	 * Chiama l'api e valorizza l'oggetto previsioni
	 */
	private void setPrevisioni() {
		UsaApi api = new UsaApi();
		try {
		this.previsione = api.valorizzaPrevisione(this.data);
		}
		catch(NullPointerException e) {
			this.previsione.setCondizioni("Previsioni non disponibili");
		}
		}
	
}

