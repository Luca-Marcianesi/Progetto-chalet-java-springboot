
public class Prenotazioni {
	
	private int numeroPrenotazione;
	private static int ultimaPrenotazione = 1;
	public String nome;
	
	public Prenotazioni (  String nome ) {
		this.nome = nome;
		this.numeroPrenotazione = ultimaPrenotazione;
		ultimaPrenotazione++;
			
	}
	
	
	public String toString() {
		return (" Numero prenotazione " + this.numeroPrenotazione + " Nome " + this.nome);
	}
	
	
	// da continuare o modificare	
	

	
}