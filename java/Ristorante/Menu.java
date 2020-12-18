package Ristorante;

import java.util.TreeSet;

public class Menu {
	private TreeSet<Piatto> menu = new TreeSet<Piatto>();
	private float coperto = 3 ;
	
	public void add_menu(TreeSet<Piatto> elenco_piatti , int codice ) {
		for(Piatto piatto : elenco_piatti) if(piatto.getCodice() == codice ) this.menu.add(piatto);	
		}	
	
	public void elimina_menù( String descrizione ) {
		for(Piatto piatto : this.menu) if(piatto.getDescrizione() == descrizione ) this.menu.remove(piatto);	
		}
	
	public void visualizza(){
		System.out.println("Men�: \n" );
		for(Piatto piatto : this.menu) System.out.println(piatto + "\n");
		System.out.println("\nCoperto: " +  coperto  + " �" + "\n");
	}
	
	public void setCoperto(float c) {
		this.coperto = c ;
		}


}
