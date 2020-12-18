//@author  LucaMarcianesi

package Informazioni;
import Interfacce.OggettoConValore;

public class Valutazione  implements OggettoConValore  {
	
	private String valutazione;
	private float stelle;
	
	public Valutazione(String descrizione , float stelle){
		this.valutazione = descrizione;
		this.stelle = stelle;
	}
	
	public void setValutazione(String descrizione , float stelle) {
		this.valutazione = descrizione;
		this.stelle = stelle;
	}
	
	public String getDescrizione() {return this.valutazione;}
	
	public float getValore() {
		return this.stelle;
	}
	
	public String toString() {
		return ( this.stelle  + " stelle" + "\n" + this.valutazione);
		
	}
	
	
	
	
	
	

}
