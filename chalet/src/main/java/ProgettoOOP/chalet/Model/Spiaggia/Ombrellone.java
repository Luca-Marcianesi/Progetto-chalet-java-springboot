package ProgettoOOP.chalet.Model.Spiaggia;

import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
import ProgettoOOP.chalet.Model.OtherClass.Prezzo;
	
	public class Ombrellone implements OggettoPrenotabile{
		
	private String tipo = "ombrellone";
	private int posizione ;	
	private boolean stato = true;
	private static int ultimaPosizione = 1;
	public Prenotazione prenotazione;
	private Prezzo prezzo = new Prezzo(0) ;
	
	public Ombrellone() {
		this.posizione = ultimaPosizione;
		ultimaPosizione++;
	}
	
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome,0);
	}
	
	
	public int getPosizione() {
		return this.posizione;
		}
	
	public boolean getStato() {
		return stato;
		}
	
	public String getTipo() {
		return this.tipo;
		}
	
	public void setStato(boolean libero) {
		this.stato = libero;
		if(stato) this.prenotazione = null;
		}
	
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	
	public String toString() {
		if(this.stato) return("\t["+ this.posizione +"]");
		else return ("\t["+ this.posizione + "X"+"]");
		
	} 
}
