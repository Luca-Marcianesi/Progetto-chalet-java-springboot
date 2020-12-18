package OtherClass;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Previsioni {
		
		 private String nome;
		 
		 private LocalDate data;
		 
		 private String principale;
		 
		 protected double temperatura;
		 
		 public double vento;
	 
		 private boolean condizioni;
		 
		 
		 private NumberFormat nf = new DecimalFormat("0.00");
		 
		 public String getPrincipale() {
			 return this.principale;
		 }
		 
		 public void setTemperatura (double temperatura) {
			 this.temperatura = temperatura -273.15;
		 }
		 
		 
		 public void setVento (double vento) {
			 this.vento = vento;
		 }
		 
		 
		 public LocalDate getData() {
			 return this.data;
		 }
		 
		 public void setNome ( String nome ) {
			 this.nome = nome;
		 }
		 
		 
		 public void setData (long ora) {
			data = data.ofEpochDay(ora);
		 }
		
		public void setCondizioni( String principale) {
			switch(principale) {
			case "Clear" : 
				 this.principale = ("Bel tempo"); 
				 break;
			case "Clouds" : 
				this.principale = ("Ci sono un po' di nuvole");
				 break;
			case "Drizzle" : 
				this.principale = ("Sta piovigginando"); 
				 break;
			case "Rain" : 
			case "Thunderstorm" : 
			case "Snow" : 
				this.principale = ("Brutto tempo!"); 
				 break;
			case "Previsioni non disponibili":
				this.principale = ("Previsioni non disponibili");
				break;
			default : 
				this.principale = ("Condizioni Particolari"); break;
				
			}
			}
			public boolean getCondizioni() {
				switch (this.principale) {
				  case "Bel tempo" : 
						return true;
				  case "Clouds" : 
						return true;
				  case "Drizzle" : 
						return true;
				  case "Previsioni non disponibili":
					  return true;		
				  default :
					  	return false;
							}
			}
			
		
			public String toString () {
			 return ( "Nome città: " + this.nome + "\ndata: " + this.data + "\ntemperatura: " +  nf.format(this.temperatura)
					 + " °C\ncondizioni meteo: " + this.principale );	 
		 }
		
	}

/*
 * case "Clear" : 
				 this.principale = ("Bel tempo"); 
				return true;
			case "Clouds" : 
				this.principale = ("Ci sono un po' di nuvole");
				return true;
			case "Drizzle" : 
				this.principale = ("Sta piovigginando"); 
				return true;
			case "Rain" : 
			case "Thunderstorm" : 
			case "Snow" : 
				this.principale = ("Brutto tempo!"); 
				return false;
			default : 
				this.principale = ("Condizioni Particolari");
				return false;
			}*/
