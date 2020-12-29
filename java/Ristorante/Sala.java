package Ristorante;
import Liste.ListaOggettiPrenotabili;
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



/*private int numTavoli = 0;
	private static int prenotati = 0;
	
	
	public int liberi() {return (numTavoli - prenotati);}
	public int getMassimo() { return numTavoli; }
	
	public int getPrenotati() { return prenotati; }
	*/

