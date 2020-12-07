//@author DiegoMignani

import java.util.Vector;

public class ListaOmbrelloni {
	private int max;
	private int righe;
	private int colonne;
	private Vector<Ombrellone> lista = new Vector<Ombrellone>();
	
	public ListaOmbrelloni(int righe, int colonne){
		this.max = colonne * righe;						
		this.righe = righe;
		this.colonne = colonne;
		for (int p = 0; p<this.max; p++) {Ombrellone o = new Ombrellone();lista.add(o);}
	}
	
	public int postiDisponibili() {
		int disponibili = 0;
		for (Ombrellone k : lista) if(k.getLibero()) disponibili++;
		return disponibili;
	}
	
	public boolean inserisciPrenotazione(int posto) {		
		if (lista.get(posto).getLibero()) {
				lista.get(posto).setLibero(false);
				System.out.println( "\nOmbrellone " + posto + " prenotato!\n");
				return true;
		}
		else {
			System.out.println("Prenotazione non effettuata!\nLa posizione da lei selezionata non esiste o è già occupata!");
			System.out.println("Attualmente ci sono " + postiDisponibili() + " ombrelloni liberi");
			return false;
		}
	}
	
	public boolean eliminaPrenotazione(int posto) {
		if (!lista.get(posto).getLibero()) {
			lista.get(posto).setLibero(true);
			System.out.println( "\nLa prenotazione dell'ombrellone " + posto + " è stata rimossa!\n");
			return true;
		}	
		else {
			System.out.println( "\nRimozione non effettuata!\nLa posizione da lei selezionata non esiste o è già libera!");
			return false;
		}
	}
	
	public void Reset() {for(Ombrellone k : lista) k.setLibero(true);}
	
	public void Visualizza(){
		System.out.println();
		System.out.println(postiDisponibili() + " Ombrelloni liberi\n");
		System.out.println();
		int i = 0;
		for(int r=0; r<this.righe; r++) {
			for(int c=0; c<this.colonne; c++,i++) {
				if (lista.get(i).getLibero()) System.out.print("\t["+ i +"]");
				else System.out.print("\t[X]");
			}
			System.out.println("\n");
		}
	}
}
