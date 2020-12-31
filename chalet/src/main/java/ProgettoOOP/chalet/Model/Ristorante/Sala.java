package ProgettoOOP.chalet.Model.Ristorante;

import ProgettoOOP.chalet.Model.Liste.ListaOggettiPrenotabili;
//@author DiegoMignani

public class Sala extends ListaOggettiPrenotabili<Tavolo>{
	

	public boolean prenota(String richiesta,String nome,int numPers){
		for(Tavolo tavolo : super.lista) {
			
			if(richiesta.equalsIgnoreCase(tavolo.getTipo()) && tavolo.getStato()&&tavolo.controlloPosti(numPers)) {
				tavolo.setStato(false);
				tavolo.aggiungiPrenotazione(nome);
				return true;
			}	
	}
	return false;
	}
	
	}




