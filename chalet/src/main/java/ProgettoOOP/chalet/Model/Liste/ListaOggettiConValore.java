package ProgettoOOP.chalet.Model.Liste;

import ProgettoOOP.chalet.Model.Interfacce.OggettoConValore;

/**
 * @author Luca Marcianesi
 *
 * @param <T> generico oggettoConValore
 */
public class ListaOggettiConValore <T extends OggettoConValore> extends Lista<T> {
		
		/**
		 * Effettua la somma del valore caratteristico di ogni oggetto nella lista
		 * @return la somma in float del valore caratteristico
		 */
		public float somma() {
			float totale = 0;
			for(T oggetto : super.lista) totale += oggetto.getValore();
			return totale;
		}
		
		
		/**
		 * Effettua la media del valore caratteristico di ogni oggetto nella lista
		 *@return la media del valore caratteristico degli oggetti nella lista
		 */
		public float media() {	
			return this.somma() / super.lista.size();	
		}
		
		/**
		 * @return ritorna in string la media
		 */
		public String getMedia() {
			return (this.media() + "");
		}
	}
