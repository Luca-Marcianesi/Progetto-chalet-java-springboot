package Spiaggia;
import java.util.Vector;
import Liste.ListaOggettiPrenotabili;
import Interfacce.OggettoPrenotabile;

/*
 * @author DiegoMignani
 * Classe che gestisce gli ombrelloni della spiaggia
 */

public class ListaOmbrelloni extends ListaOggettiPrenotabili<OggettoPrenotabile>{
	/*
	 * Rappresenta il numero di colonne di ombrelloni nella spiaggia
	 */
	private int colonne;
	/*
	 * Rappresenta il numero totale di ombrelloni nella spiaggia
	 */
	private int max;
	/*
	 * Lista che contiene gli oggetti della classe Ombrellone
	 */
	private Vector<Ombrellone> lista = new Vector<Ombrellone>();
	/*
	 * Lista che tiene conto di tutte le prenotazioni
	 */
	private Vector<PrenotazionePosto>listaPrenotazioni = new Vector<PrenotazionePosto>();
	/*
	 * Costruttore che calcola il numero totale di ombrelloni,
	 * aggiunge oggetti alla lista.
	 */
	public ListaOmbrelloni(int righe, int colonne){
		this.max = colonne * righe;						
		this.colonne = colonne;
		for (int p = 0; p<this.max; p++) {
				Ombrellone o = new Ombrellone();
				lista.add(o);
		}
	}
	/*
	 * Metodo che gestisce le prenotazioni
	 * controllando lo stato di ogni ombrellone
	 * e visualizza l'esito della prenotazione
	 */
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
	/*
	 * Metodo che fa visualizzare a schermo la situzione della spiaggia
	 */
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
	/*
	 * Metodo che calcola quanti ombrelloni disponibili ci sono nella spiaggia
	 */
	public int postiDisponibili() {
		int disponibili = 0;
		for (Ombrellone k : lista) if(k.getStato()) disponibili++;
		return disponibili;
	}
	/**
	 * Metotodo che fa annullare la prenotazione di un ombrellone
	 * controllando lo stato di ognuno
	 * e visualizza a schermo l'esito
	 */
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
	/*
	 * Reimposta lo stato della prenotazione dei singoli ombrelloni
	 */
	public void Reset() {
		for(Ombrellone k : lista) k.setStato(true);
	}
	/*
	 * Metodo che gestisce l'ordini delle prenotazioni
	 */
	public void aggiungiPrenotazione(String nome , int posto) {
		PrenotazionePosto prenotazione = new PrenotazionePosto(nome, posto);
		this.listaPrenozioni.aggiungi(prenotazione);
	}
	/*
	 * Ritorna la lista delle prenotazioni
	 */
	public Vector<Prenotazioni> getListaPrenotazioni(){
		return this.listaPrenotazioni;
	}
}
