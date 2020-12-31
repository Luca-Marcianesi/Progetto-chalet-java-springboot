package ProgettoOOP.chalet.Model.Liste;

import java.util.Vector;

/**
 * @author LucaMarcianesi
 *Classe generale che gestisce una lista di generici oggetti
 * @param <T> generico oggetti della lista
 */
public class Lista<T> {
	
	/**
	 * Vector struttura che contiene gli oggetti inseriti
	 */
	protected  Vector <T> lista = new Vector <T>() ;
	
	/**
	 * 
	 * @param oggetto--> oggetto da inserire nel vector
	 */
	public   void aggiungi(T oggetto) {
		this.lista.add(oggetto);
	}
	
	
	/**
	 * Sostituisce l'oggetto in  una posizione con un nuovo elemento
	 * @param posizione  posizione del oggetto da sostituire
	 * @param nuovo_oggetto  
	 */
	public void sostituisci(int posizione, T nuovo_oggetto) {
		this.lista.set(posizione, nuovo_oggetto);
	}

	/**
	 * Elimina l'oggetto della lista in una posizione
	 * @param posizione posizione dell'oggetto da eliminare
	 */
	public void elimina(int posizione) {
		this.lista.remove(posizione);
}
	/**
	 *Trasforma la lista in una stringa
	 */
	public String toString() {
		String ritorno = "";
		for(T Elemento : this.lista) ritorno = (ritorno +Elemento.toString() + "\n");
		return ritorno;
	}
	
	/**
	 * Metodo che ritorna il vector di oggetti
	 * @return vector di generici oggetti T
	 */
	public Vector <T> getLista(){
		return this.lista;
	}
}

