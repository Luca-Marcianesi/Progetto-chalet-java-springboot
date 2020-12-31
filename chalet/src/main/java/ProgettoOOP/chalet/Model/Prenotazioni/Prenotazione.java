package ProgettoOOP.chalet.Model.Prenotazioni;

public class Prenotazione {
	
	private int numeroPrenotazione;
	private String nome;
	
	public Prenotazione (String nome,int numeroPrenotazione) {
		this.nome = nome;
		this.numeroPrenotazione = numeroPrenotazione++;
			
	}
	
	
	public String toString() {
		return (" Numero prenotazione " + this.numeroPrenotazione + " Nome " + this.nome);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getNumeroPrenotazione() {
		return this.numeroPrenotazione;
	}
	

}