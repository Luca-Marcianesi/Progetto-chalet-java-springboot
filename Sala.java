//@author DiegoMignani

public class Sala {
	private int massimo;
	private static int prenotati = 0;
	
	public Sala(int massimo) {
		this.massimo = massimo;
	}
	
	public String toString() {
		return ("\nTavoli\n\n" + 
				liberi() + " tavoli liberi!\n");
	}
	
	public int getMassimo() { return massimo; }
	
	public int getPrenotati() { return prenotati; }

	public int liberi() {return (massimo - prenotati);};
	
	public boolean prenota(int num){
		if(liberi()>num) {
			System.out.println(num + " tavoli prenotati!");
			prenotati+=num;
			return true;
		}
		else {
			System.out.println("Prenotazione non effettuata!");
			System.out.println( "I tavoli da lei richiesti sono esauriti, attualmente ci sono " + liberi() +" posti liberi");
			return false;
		}
	}
}
