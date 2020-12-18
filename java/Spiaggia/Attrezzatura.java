package Spiaggia;
import Interfacce.OggettoPrenotabile;
import OtherClass.Prenotazione;

//@author DiegoMignani

public class Attrezzatura implements OggettoPrenotabile{
	
	private String tipo;
	private float prezzo;
	private boolean stato = true;
	private Prenotazione prenotazione;
	
	public Attrezzatura(String tipo, float prezzo) {
		this.tipo = tipo;
		this.prezzo = prezzo;
		
	}
	
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome);
	}
	
	public boolean getStato() {
		return this.stato;
		}
	
	public void setStato(boolean stato) {
		this.stato = stato;
		}
	
	public String getTipo() {return this.tipo;}
	
	public float getPrezzo() {return prezzo;}
	
	public String toString() {
		return(this.tipo + " " + this.prezzo + " Stato: " + this.statoString());
	}
	
	private String statoString() {
		if(this.stato) return ("libero");
		else return ("prenotato");
	}
	
	
	
	
}