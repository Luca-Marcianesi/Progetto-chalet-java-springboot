package Spiaggia;
//@author DiegoMignani

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import Liste.ListaOggettiPrenotabili;
import Interfacce.OggettoPrenotabile;
import OtherClass.PrenotazionePosto;
import OtherClass.Previsioni;
import prova.ombrelloni.Model.UsaApi;
import java.util.HashSet;



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
		for(Ombrellone ombrellone : lista) {
			if(ombrellone.getPosizione()==posto) {
				if(ombrellone.getStato()) {
						ombrellone.setStato(false);
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
		for (Ombrellone ombrellone : lista) if(ombrellone.getStato()) disponibili++;
		return disponibili;
	}
	
	public boolean annulla(int posto) {		
		for(Ombrellone ombrellone : lista) {
			if(ombrellone.getPosizione()==posto) {
				if(!ombrellone.getStato()) {
					ombrellone.setStato(true);
					return true;
					}			
				return false;
			}	
		}
		return false;
		}
	
	public void Reset() {
		for(Ombrellone k : lista) k.setStato(true);
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
