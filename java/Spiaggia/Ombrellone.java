package Spiaggia;

//@author DiegoMignani

import Interfacce.OggettoPrenotabile;
import OtherClass.Prenotazione;

	
	public class Ombrellone implements OggettoPrenotabile{
		
	private String tipo = "ombrellone";
	private int posizione ;	
	private boolean stato = true;
	private static int ultimaPosizione = 1;
	public Prenotazione prenotazione;
	
	public Ombrellone() {
		this.posizione = ultimaPosizione;
		ultimaPosizione++;
	}
	
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome);
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
	
	public String toString() {
		if(this.stato) return("\t["+ this.posizione +"]");
		else return ("\t["+ this.posizione + "X"+"]");
		
	} 
}