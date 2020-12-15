
public class Prezzi {
	
	
	
	public Prezzi ( double prezzo ) {
	}
	
	private double prezzomenu;
	private double prezzostagione;
	private double prezzoasporto;
	private double prezzoevento;
	private double prezzooggetto;
	
	public void setPrezzo ( double prezzomenu ) {
		this.prezzomenu = prezzomenu;
	}
	
		public void setAsporto (double prezzoasporto) {
			this.prezzoasporto = prezzoasporto;
		}
	
		
	public void setStagione ( double prezzostagione ) {
		this.prezzostagione = prezzostagione;
	}
	
	public void setEvento (double prezzoevento ) {
		this.prezzoevento = prezzoevento;	
	}
	
	public void setOggetti ( double prezzooggetto ) {
		this.prezzooggetto = prezzooggetto;
	}
	
	
	public double getPrezzo () {
		return this.prezzomenu;
	}
	
	public double getAsporto () {
		return this.prezzoasporto;
	}
	
	
	public double getEvento () {
		return this.prezzoevento;
	}
	
	
	public double getStagione () {
		return this.prezzostagione;
	}
	
	public double getOggetto () {
		return this.prezzooggetto;
	}
		
	
	public String toString () {
		return ("Prezzo menù:" + prezzomenu + "Prezzo ombrellone stagionale" + prezzostagione +
				"Prezzo pranzo da asporto" + prezzoasporto + "Prezzo prevendita per l'evento" + 
				prezzoevento + "Prezzo dell'oggetto prenotabile" + prezzooggetto);
	}
	
	
	
}
