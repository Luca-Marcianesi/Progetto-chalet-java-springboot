package Liste;
//@author LucaMarcianesi
import java.util.Vector;

import Interfacce.OggettoPrenotabile;
import OtherClass.Prenotazione;

public class ListaOggettiPrenotabili<T extends OggettoPrenotabile>  extends Lista<T>{
	
	protected Vector <Prenotazione> listaPrenotazioni= new Vector <Prenotazione>();

	public boolean prenota (String richiesta , String nome) {
		for(T elemento : super.lista) {
			
			if(richiesta.equalsIgnoreCase(elemento.getTipo()) && elemento.getStato()) {
				elemento.setStato(false);
				this.aggiungiPrenotazione(nome);
				return true;
			}	
		
	}
	System.out.println("Al momento " + richiesta + "non è disponibile");
	return false;
	}
	
	
	public Vector <Prenotazione> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
	
	public int numeroPrenotazioni() {
		return this.listaPrenotazioni.size();
	}
	
	protected void aggiungiPrenotazione(String nome) {
		Prenotazione prenotazione = new Prenotazione(nome);
		this.listaPrenotazioni.add(prenotazione);
	}
	
}
