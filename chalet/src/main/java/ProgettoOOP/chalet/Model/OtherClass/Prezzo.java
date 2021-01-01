package ProgettoOOP.chalet.Model.OtherClass;

/**
 * @author Edoardo Tarulli
 *
 */

public class Prezzo {
	
	/**
	 * @param prezzo --> variabile "prezzo" di tipo float.
	 */
	private float prezzo;
	
	/** Costruttore della classe Prezzo che prende in ingresso, come parametro, il prezzo.
	 */
	public Prezzo(float prezzo) {
		
		this.prezzo = prezzo;
	}
	
	/**
	 * Metodo utile per andare a specificare il valore del prezzo.
	 */
	public void setPrezzo ( float prezzo ) {  
		this.prezzo = prezzo;
	}
	
	/**
	 * Metodo get che restituisce il valore del prezzo.
	 */
	public float getPrezzo () {
		
		return this.prezzo;
	}
	
	/**
	 * Metodo che restituisce il valore del prezzo trasformato in stringa.
	 */
	public String toString () {
		
		return ("Prezzo :" + prezzo );
	}
}
