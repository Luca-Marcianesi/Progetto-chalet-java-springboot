package Liste;
//@author LucaMarcianesi

import Interfacce.OggettoPrenotabile;


public class ListaOggettiPrenotabili<T extends OggettoPrenotabile>  extends Lista<T>{
	

	public boolean prenota (String richiesta , String nome) {
		for(T elemento : super.lista) {
			
			if(richiesta.equalsIgnoreCase(elemento.getTipo()) && elemento.getStato()) {
				elemento.setStato(false);
				elemento.aggiungiPrenotazione(nome);
				return true;
			}	
		
	}
	System.out.println("Al momento " + richiesta + "non è disponibile");
	return false;
	}
	
	
	
	
}
