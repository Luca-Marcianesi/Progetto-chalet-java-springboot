package ProgettoOOP.chalet.Model.Prenotazioni;

/**
 * @author LucaMarcinesi
 * Classe che gestisce una prenotazione
 *
 */
public class Prenotazione {
	
	/**
	 * Numero della prenotazione
	 */
	private int numeroPrenotazione;
	/**
	 * Nome di chi prenota
	 */
	private String nome;
	
	/**
	 * Costruttore della classe
	 * @param nome  Nome di chi prenota
	 * @param numeroPrenotazione Numero della prenotazione
	 */
	public Prenotazione (String nome,int numeroPrenotazione) {
		this.nome = nome;
		this.numeroPrenotazione = numeroPrenotazione++;
			
	}
	
	/**
	 * @return Restituisce il nome di chi ha prenotato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return Ritorna il numero della prenotazione
	 */
	public int getNumeroPrenotazione() {
		return this.numeroPrenotazione;
	}
	
	/**
	 *Trasforma la prenotazione in stringa
	 */
	public String toString() {
		return (" Numero prenotazione " + this.numeroPrenotazione + " Nome " + this.nome);
	}

}