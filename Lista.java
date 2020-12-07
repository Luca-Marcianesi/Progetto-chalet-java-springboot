//@author  LucaMarcianesi

package Principale;
import java.util.Vector;

public   class Lista <T extends OggettoConValore> {
	
	
	public  Vector <T> lista = new Vector <T>() ;
	
	public   void aggiungi(T oggetto) {
		this.lista.add(oggetto);
	}
	
	public String toString() {
		String ritorno = "";
		for(T Elemento : this.lista) ritorno = (ritorno +Elemento.toString() + "\n");
		return ritorno;
	}
	
	public void modifica(int a, T nuovo_oggetto) {
		this.lista.set(a, nuovo_oggetto);
	}

	public void elimina(int posizione) {
		this.lista.remove(posizione);
	}
	
	public String getMedia() {
		return (this.media() + "");
	}
	
	protected float somma() {
		float totale = 0;
		for(T oggetto : this.lista) totale += oggetto.getValore();
		return totale;
	}
	
	public void aggiungiOrdinataXvalore( T  oggetto) {
		 
		 this.lista.set(this.trovaPosizione(oggetto),oggetto);	 
	 }
	
	private float media() {	
		return this.somma() / this.lista.size();	
	}
	
	private int trovaPosizione( T  oggetto) {
		 int posizione = 0;
		 for(T elemento_lista : this.lista ) {
			 if(elemento_lista.getValore() <= oggetto.getValore()) posizione++;
		 }
		 return posizione;	 
	 }
	 
	

	}
	
	
	


