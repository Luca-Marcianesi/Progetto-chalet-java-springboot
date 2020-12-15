

public class Tavolo {
	
	
	public Tavolo ( int numeropersone ) {
	}
	
		private int numeroposti;
		
		private int postobambino;
		
		private char risposta;
		public void setPosti (int numeroposti) {
			this.numeroposti = numeroposti;
		}
		
		public void setBambino (int postobambino, char risposta) {
			if ( risposta == 's' || risposta == 'S' ) 
				System.out.print("Quanti?");
			else return;
		}
		
		
		public int getPosti () {
			return this.numeroposti;
		}
		
		
		public char getBambino () {
			return this.risposta;
		}
		
		
		public String toString () {
			return ("Posti:" + this.numeroposti + "Posti per bambini(s / n):" + this.postobambino
					+ "Numero tavolo");
		}
		
}

