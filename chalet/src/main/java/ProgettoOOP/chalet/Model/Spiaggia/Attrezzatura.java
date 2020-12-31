package ProgettoOOP.chalet.Model.Spiaggia;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import ProgettoOOP.chalet.Model.OtherClass.Prezzo;
import ProgettoOOP.chalet.Model.Interfacce.*;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
import ProgettoOOP.chalet.Model.OtherClass.Previsioni;
import ProgettoOOP.chalet.Model.OtherClass.UsaApi;


//@author DiegoMignani

public class Attrezzatura implements OggettoPrenotabile , OggettoConValore{
	
	private String tipo;
	private Prezzo prezzo = new Prezzo(0);
	private boolean stato = true;
	private Prenotazione prenotazione;
	
	public Attrezzatura(String tipo, float prezzo) {
		this.tipo = tipo;
		this.prezzo.setPrezzo(prezzo);;
		
	}
	
	public  void aggiungiPrenotazione(String nome) {
		this.prenotazione = new Prenotazione(nome,0);
	}
	
	public boolean getStato() {
		if(this.previsioni() &&  this.stato) return true;
		else return false;
		}
	
	public void setStato(boolean stato) {
		this.stato = stato;
		}
	
	public String getTipo() {return this.tipo;}
	
	
	public String toString() {
		return(this.tipo + " " + this.prezzo + " Stato: " + this.statoString());
	}
	
	private String statoString() {
		if(this.stato) return ("libero");
		else return ("prenotato");
	}
	
	private boolean previsioni() {
		UsaApi api = new UsaApi();
		Previsioni previsione = new Previsioni();
		LocalDate oggi = Instant.ofEpochSecond(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
		previsione = api.valorizzaPrevisione(oggi);
		return previsione.getCondizioni();
		}
	
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	
	public Prenotazione getPremotazione() {
		return this.prenotazione;
	}
	
	
	
	
}
