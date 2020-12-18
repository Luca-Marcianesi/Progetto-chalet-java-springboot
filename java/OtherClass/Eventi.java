//@author DiegoMignani

package OtherClass;
import java.time.LocalDate;
import java.util.Vector;

import Interfacce.OggettoPrenotabile;
import prova.ombrelloni.Model.*;
public class Eventi implements OggettoPrenotabile {
	
	private LocalDate data;
	private String tipo;
	private int max;
	private int prenotati;
	private Previsioni previsione;
	
	public Vector <Prenotazione> listaPrenotazioni= new Vector <Prenotazione>();
		
	
	public Eventi (int max ,String nome , int mese, int giorno) {
		this.max = max;
		this.tipo = nome;
		data =  LocalDate.of(2020,mese,giorno);
		this.setPrevisioni();
		System.out.print("ppppppppppppp");
		
	}
	
	private void setPrevisioni() {
		UsaApi a = new UsaApi();
		a.letturaOnline();
		for(Previsioni prev : a.lista.lista) {
			if(this.data.equals(prev.getData())) {
				this.previsione = prev;
		}
			else this.previsione.setCondizioni("Previsioni non disponibili");
	}
	}

	public LocalDate getData() {
		return this.data;
	}
	
	public int getDisponibili() {
		return this.max - this.prenotati;
	}
		
	public void setTipo(String nome) {
		this.tipo = nome;
	}
	
	public String getTipo() {
		 return this.tipo;
	}
	
	public boolean getStato() {
		if(this.previsione.getCondizioni()) {
		if(max-prenotati>0)return true;
		else return false;
		}
		else return false;
	}
	
	public void setStato(boolean stato) {
		if(!stato) this.prenotati++;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public int getMax() {
		return this.max;
	}
	
	public Vector <Prenotazione> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
	
	public int numeroPrenotazioni() {
		return this.listaPrenotazioni.size();
	}
	
	public void aggiungiPrenotazione(String nome) {
		Prenotazione prenotazione = new Prenotazione(nome);
		this.listaPrenotazioni.add(prenotazione);
	}
	
	public String toString () {
		return("\nDescrizione dell'evento: \t" + tipo +
							"\nOrario dell'evento: \t\t" + this.data +
							"\nPosti liberi: \t\t\t" + (this.max-this.prenotati) + '\n' );
		
	}
	
	
}
