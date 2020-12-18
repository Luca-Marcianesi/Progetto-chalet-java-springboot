package OtherClass;

public class Prenotazione {
	
	public int numeroPrenotazione;
	private static int ultimaPrenotazione = 1;
	public String nome;
	
	public Prenotazione (String nome) {
		this.nome = nome;
		this.numeroPrenotazione = ultimaPrenotazione;
		ultimaPrenotazione++;
			
	}
	
	
	public String toString() {
		return (" Numero prenotazione " + this.numeroPrenotazione + " Nome " + this.nome);
	}
	

}
