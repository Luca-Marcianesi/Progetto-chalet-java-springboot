package ProgettoOOP.chalet.Model.Ristorante;

import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;
import ProgettoOOP.chalet.Model.Prenotazioni.Prenotazione;

/**
 * @author  Edoardo Tarulli
 *
 */

public class Tavolo implements OggettoPrenotabile {
	
	/**
	 * int numeroposti = numero dei posti per ogni tavolo.
	 * prenotazione = oggetto della classe Prenotazione per specificare il nome della prenotazione.
	 * string tipo = specifica cosa io voglio prenotare cioè il tavolo
	 * boolean stato = serve per specificare lo stato appunto della disponibilit del tavolo.
	 */
		private int numeroposti;
		private boolean stato;
		private Prenotazione prenotazione;
		private String tipo = "tavolo";
		
		/**
		 * Costruttore che prende in ingresso il numero delle persone e setta lo stato a true ovvero libero.
		 */
		public Tavolo ( int numeropersone ) { 
			
			this.numeroposti = numeropersone;
			this.stato = true;
		}
		
		/**
		 *  Metodo set per impostare il numero dei posti 
		 */
		public void setPosti (int numeroposti) { 
			this.numeroposti = numeroposti;
		}
		
		/**
		 * Metodo getPosti che restituisce il numero dei posti.
		 * @return numeroposti.
		 * 
		 */
		public int getPosti () {
			return this.numeroposti;
		}
		
		/**
		 * Metodo che stampa il numero dei posti trasformato in una stringa.
		 */
		public String toString () {
			
			return ("Posti:" + this.numeroposti);
		}
		
		/**
		 *  Metodo per creare una nuova prenotazione.
		 */
		public void aggiungiPrenotazione(String nome) {
			
			this.prenotazione = new Prenotazione (nome,1);
		}
		
		/**
		 * Metodo che restituisce lo stato, cioè libero o occupato, del tavolo.
		 */
		public boolean getStato () {
			return this.stato;
			
		}
		
		/**
		 *  Metodo che prende in ingresso il numero delle persone e effettua un controllo:
		 *  vede se il tavolo ha un numero di posti soddisfacente al numero delle persone.
		 */
		public boolean controlloPosti(int numeroPersone) {
			if(this.numeroposti>= numeroPersone) return true;
			else return false;
		}

		/**
		 * Metodo per impostare lo stato del tavolo, cioè libero o occupato.
		 */
		
		public void setStato(boolean stato) {
			this.stato = stato;	
		}
		
		/**
		 * Metodo che restituisce il tipo dell'oggetto prenotato, in questo caso il tavolo.
		 */
		
		public String getTipo() {
			return this.tipo;
		}
		
		/**
		 * Metodo che restituisce la prenotazione, che è stata effettuata in precedenza.
		 */
		
		public Prenotazione getPrenotazione () {
			return this.prenotazione;
		}
		
}