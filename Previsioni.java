
import java.util.Date;
import java.time.*;
public class Previsioni {
		
		 private String nome;
		 
		 private Date locale;
		 
		 private Date alba;
		 private Date tramonto;
		 
		 private double temperatura;
		 
		 private long umidita;
		 
		 String principale;
		 String descrizione;
		 
		 public void setOrari (long ora, boolean controllo) {
			 ora = ora * 1000;
			 if ( controllo ) this.alba = new Date(ora);
			 else this.tramonto = new Date (ora);
		 }
		 
		 
		 public void setTemperatura (double temperatura) {
			 this.temperatura = temperatura;
		 }
		 
		 public void setUmidita (long umidita) {
			 this.umidita = umidita;
		 }
		 
		 public void setCondizioni ( String principale, String descrizione ) {
			 this.principale = principale;
			 this.descrizione = descrizione;
		 }
		 
		 public void setNome ( String nome ) {
			 this.nome = nome;
		 }
		 
		 
		 public void setLocale (long ora) {
			 ora = ora * 1000;
			 this.locale = new Date (ora);
		 }
		
		 public String toString () {
			 return ( "Nome città: " + this.nome + "\ndata: " + this.locale + "\ntemperatura: " + this.temperatura 
					 + "\ncondizioni meteo: " + this.principale );
			 
		 }
		 
	}

