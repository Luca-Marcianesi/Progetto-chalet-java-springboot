package ProgettoOOP.chalet.Model.Prenotazioni;

public class PrenotazionePosto extends Prenotazione{
	/**
	 * Posto prenotato
	 */
	private int posto;
	
	/**
	 * Costruttore che crea l'oggetto come nella 
	 * Classe Prenotazione ma aggiunge il posto prenotato
	 * @param nome
	 * @param numeroPrenotazione
	 * @param posto
	 */
	public PrenotazionePosto(String nome,int numeroPrenotazione,int posto){
		super(nome,numeroPrenotazione);
		this.posto = posto;
		
		
	}
	
	/**
	 * @return Restituisce il posto che è stato prenotato
	 */
	public int getPosto() {
		return this.posto;
	}

}

