package Ristorante;
/*
 * @author DiegoMignani
 * Classe che si occupa della gestione dei tavoli
 * nella sala del ristorante
 */
public class Sala {
	/*
	 * Numero massimo di posti
	 */
	private int massimo;
	/*
	 * Attributo che tiene conto dei posti prenotati
	 */
	private static int prenotati = 0;
	/*
	 * Costruttore che assegna il
	 * numero massimo dei posti al suo attributo
	 */
	public Sala(int massimo) {
		this.massimo = massimo;
	}
	/*
	 * Metodo che fa visualizzare a schermo la situazione
	 * complessiva della sala
	 */
	public String toString() {
		return ("\nTavoli\n\n" + 
				liberi() + " tavoli liberi!\n");
	}
	/*
	 * Restituisce il numero massimo di posti nella sala 
	 */
	public int getMassimo() {
		return this.massimo; 
	}
	/*
	 * Restituisce il numero dei posti prenotati nella sala
	 */
	public int getPrenotati() { 
		return this.prenotati; 
	}
	/*
	 * Restituisce il numero di posti liberi nella sala
	 */
	public int liberi() {
		return (massimo - prenotati);
	}
	/*
	 * Metodo che gestisce il numero di prenotazione e stampa 
	 * a chermo l'esito della prenotazione
	 */
	public boolean prenota(int num){
		if(liberi()>num) {
			System.out.println(num + " tavoli prenotati!");
			prenotati+=num;
			return true;
		}
		else {
			System.out.println("Prenotazione non effettuata!");
			System.out.println( "I tavoli da lei richiesti sono esauriti, attualmente ci sono " + liberi() +" posti liberi");
			return false;
		}
	}
}
