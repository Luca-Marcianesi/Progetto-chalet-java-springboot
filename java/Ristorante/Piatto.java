package Ristorante;
//@author  LucaMarcianesi

import Interfacce.OggettoConValore;
import OtherClass.Prezzo;

public class Piatto   implements  OggettoConValore {
	
	private  int codice;
	private static int ultimoCodice = 1000;
	private String descrizione;
	private Prezzo prezzo;
	
	
	public  Piatto(String descrizione , float prezzo ) {
		this.codice = ultimoCodice;
		ultimoCodice++;
		this.descrizione = descrizione;
		this.prezzo = new Prezzo(prezzo);
	}
	
	public void modifica(String tipo , String descrizione) 	{
		
		this.descrizione = descrizione ;
		
		}
	
	public void modifica(float prezzo) {
		this.prezzo.setPrezzo(prezzo) ;
		}
	
	public int getCodice() {
		return this.codice;
	}
	
	public float getValore() {
		return this.prezzo.getPrezzo();
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public String toString() {
		return (  this.codice + this.descrizione + " " + this.prezzo.getPrezzo() + "€" );
	}
}
