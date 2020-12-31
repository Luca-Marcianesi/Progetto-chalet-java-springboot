package ProgettoOOP.chalet.Model.Spiaggia;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import java.util.HashSet;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiPrenotabili;
import ProgettoOOP.chalet.Model.Interfacce.OggettoPrenotabile;
import ProgettoOOP.chalet.Model.Prenotazioni.*;
import ProgettoOOP.chalet.Model.OtherClass.Previsioni;
import ProgettoOOP.chalet.Model.OtherClass.UsaApi;

public class ListaOmbrelloni extends ListaOggettiPrenotabili<OggettoPrenotabile>{
	
	private int max;
	private Vector<Ombrellone> lista = new Vector<Ombrellone>();
	private Previsioni previsione ;
	private HashSet <PrenotazionePosto> listaPrenotazioni= new HashSet <PrenotazionePosto>();
	
	public ListaOmbrelloni(int righe, int colonne){
		this.max = colonne * righe;						
		for (int p = 0; p<this.max; p++) {
				Ombrellone o = new Ombrellone();
				lista.add(o);
			}
		
	}
	
	public boolean prenota(int posto , String nome) {
		this.setPrevisioni();
		if(previsione.getCondizioni()) {
		for(Ombrellone ombr : lista) {
			if(ombr.getPosizione()==posto) {
				if(ombr.getStato()) {
						ombr.setStato(false);
						this.aggiungiPrenotazione(nome,posto);
						return true;
					}
				return false;
			}	
		}
		}
		return false;
	
	}
	
	public int postiDisponibili() {
		int disponibili = 0;
		for (Ombrellone k : lista) if(k.getStato()) disponibili++;
		return disponibili;
	}
	
	public boolean annulla(int posto) {		
		for(Ombrellone ombr : lista) {
			if(ombr.getPosizione()==posto) {
				if(!ombr.getStato()) {
					ombr.setStato(true);
					return true;
					}			
				return false;
			}	
		}
		return false;
		}
	
	public void Reset() {
		for(Ombrellone ombrellone : lista) ombrellone.setStato(true);
		}
	
	public HashSet <PrenotazionePosto> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
	
	private void aggiungiPrenotazione(String nome , int posto) {
		
			PrenotazionePosto prenotazione = new PrenotazionePosto(nome,this.listaPrenotazioni.size()+1, posto);
			this.listaPrenotazioni.add(prenotazione);
		}
		
	
	private void setPrevisioni() {
		UsaApi api = new UsaApi();
		LocalDate oggi = Instant.ofEpochSecond(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
		this.previsione = api.valorizzaPrevisione(oggi);
		}
	
	
	
}
