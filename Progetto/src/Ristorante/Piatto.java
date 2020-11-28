package Ristorante;

import java.util.Scanner;

public class Piatto {
	
	private String tipo;
	private String descrizione;
	private float prezzo = 0;
	
	
	public  Piatto( String tipo , String a , float p ) {
		
		this.tipo = tipo;		
		this.descrizione = a;
		this.prezzo = p;
	}
	
	public  Piatto(String tipo) {
		
		this.tipo = "";		
		this.descrizione = "";
		this.prezzo = 0;
	}
	
	public  Piatto() {
		
		Scanner input = new Scanner ( System . in );
		
		System.out.print("Inserisci tipo piatto: ");
		
		this.tipo = input.nextLine();
		
		System.out.println("Inserisci descrizione: " );
		this.descrizione = input.nextLine();
		
		System.out.println( "Inserisci prezzo: " );
		this.prezzo = input.nextFloat();
		
		input.close();
		}
	
	public void visualizza() {
		System.out.println(  this.descrizione + " " + this.prezzo + " €" );
	}
	
	public void modifica(String descrizione) 	{
		this.descrizione = descrizione ;
		}
	
	public void modifica(String tipo , String descrizione) 	{
		this.tipo = tipo ;
		this.descrizione = descrizione ;
		
		}
	
	public void modifica(float prezzo) {
		this.prezzo = prezzo ;
		}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
