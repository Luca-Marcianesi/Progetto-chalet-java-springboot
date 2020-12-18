package Spiaggia;
//@author DiegoMignani

import java.util.Vector;
import Liste.ListaOggettiPrenotabili;
import Interfacce.OggettoPrenotabile;



public class ListaOmbrelloni extends ListaOggettiPrenotabili<OggettoPrenotabile>{
	
	private int colonne;
	private int max;
	private Vector<Ombrellone> lista = new Vector<Ombrellone>();
	
	public ListaOmbrelloni(int righe, int colonne){
		this.max = colonne * righe;						
		this.colonne = colonne;
		for (int p = 0; p<this.max; p++) {
				Ombrellone o = new Ombrellone();
				lista.add(o);
			}
	}
	
	public boolean prenota(int posto , String nome) {		
		for(Ombrellone ombr : lista) {
			if(ombr.getPosizione()==posto) {
				if(ombr.getStato()) {
						ombr.setStato(false);
						System.out.println("Ombrellone " + posto + " prenotato");
						this.aggiungiPrenotazione(nome,posto);
						return true;
					}
				
				else System.out.println("Ombrellone " + posto + " occupato");
				return false;
			}	
		}
		System.out.println("Ombrellone " + posto + " non trovato");
		return false;
	}
	
	public void Visualizza(){
		System.out.println();
		System.out.println(postiDisponibili() + " Ombrelloni liberi\n");
		System.out.println();
		int i = 1;
		for(Ombrellone ombr :lista) {
			if(ombr.getPosizione()== i*this.colonne) {
				i++;
				System.out.print(ombr.toString()+"\n");
			}
			else System.out.print(ombr.toString() + "\t");
			
		}
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
					System.out.println("Ombrellone " + posto + " liberato");
					return true;
					}
				
				else System.out.println("Ombrellone " + posto + " gi� libero");
				return false;
			}	
		}
		System.out.println("Ombrellone " + posto + " non trovato");
		return false;
		}
	
	public void Reset() {
		for(Ombrellone k : lista) k.setStato(true);
		}
	
	private void aggiungiPrenotazione(String nome , int posto) {
		
	}
	
}
