package Liste;
//@author  LucaMarcianesi

import Interfacce.OggettoConValore;

public class ListaOggettiConValore <T extends OggettoConValore> extends Lista<T> {
	

		public String getMedia() {
			return (this.media() + "");
		}
		
		public float somma() {
			float totale = 0;
			for(T oggetto : super.lista) totale += oggetto.getValore();
			return totale;
		}
		
		
		private float media() {	
			return this.somma() / super.lista.size();	
		}
		
	}
	
