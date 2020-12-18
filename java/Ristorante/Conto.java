package Ristorante;

import Liste.ListaOggettiConValore;

public class Conto {
	
	private float totaleConto;
	private ListaOggettiConValore<Piatto> listaPiatti;
	
	public Conto () {
		this.totaleConto = 0;
	}
	
	public void setTotale ( float totaleconto ) {
		 this.totaleConto = totaleconto;
	}
	
	
	public void aggiungi ( Piatto piatto ) {
		this.listaPiatti.aggiungi(piatto);
		this.totaleConto = this.listaPiatti.somma();
		
	}
	
	public double getTotale () {
		return this.totaleConto;
	}
	
}
