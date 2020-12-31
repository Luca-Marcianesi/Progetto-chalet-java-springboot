

package ristorante;
import interfacce.OggettoPrenotabile;
import altreClassi.Prenotazione;

/**
 * @author  Edoardo Tarulli
 *
 */


public class Tavolo implements OggettoPrenotabile {
	
	/**
	 * int numeroposti = numero dei posti per ogni tavolo.
	 * prenotazione = oggetto della classe Prenotazione per specificare il nome della prenotazione.
	 * string tipo = specifica cosa io voglio prenotare cioè il tavolo
	 * boolean stato = serve per specificare lo stato appunto della disponibilità del tavolo.
	 */
		private int numeroposti;
		private boolean stato;
		private Prenotazione prenotazione;
		private String tipo = "tavolo";
		
		
		/**
		 * @param costruttore = prende come argomento il numero delle persone al tavolo.
		 * 
		 */
		public Tavolo ( int numeropersone ) { 
			
			this.numeroposti = numeropersone;
			this.stato = true;
		}
		
		/**
		 * @param numeroposti = Metodo set per andare a settare il numero dei posti.
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
		 * Metodo tostring per stampare le informazioni relative alla classe.
		 */
		public String toString () {
			
			return ("Posti:" + this.numeroposti);
		}
		

		/**
		 *  Metodo aggiungi prenotazione che prende String nome come argomento
		 *  per creare una nuova prenotazione.
		 */
		public void aggiungiPrenotazione(String nome) {
			
			this.prenotazione = new Prenotazione (nome);
		}
		

		/**
		 * Metodo getStato che restituisce lo stato della disponibilità del tavolo.
		 */
		public boolean getStato () {
			return this.stato;
			
		}
		
		/** Metodo controllaPosti che prende come parametro il numero delle persone e fa un controllo:
		 * se il numero dei posti è maggiore del numero delle persone allora restituisce vero, 
		 * altrimenti restituisce false.
		 */
		public boolean controlloPosti(int numeroPersone) {
			if(this.numeroposti>= numeroPersone) return true;
			else return false;
		}
		
		

		/**
		 * Metodo setStato per settare lo stato dei tavoli ( disponibile o no )
		 */
		public void setStato(boolean stato) {
			this.stato = stato;
			
		}
		
		
		/**
		 * Metodo getTipo che restituisce il tipo di "evento" da prenotare, nel nostro caso il tavolo.
		 */
		public String getTipo() {
			return this.tipo;
		}
		
		
		
		/**
		 * Metodo getPrenotazione che restituisce la prenotazione.
		 * @return
		 */
		public Prenotazione getPrenotazione () {
			return this.prenotazione;
		}
		
}

