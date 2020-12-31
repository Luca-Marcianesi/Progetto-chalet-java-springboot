package ProgettoOOP.chalet.Model.Prenotazioni;

public class PrenotazionePosto extends Prenotazione{
	private int posto;
	
	public PrenotazionePosto(String nome,int numeroPrenotazione,int posto){
		super(nome,numeroPrenotazione);
		this.posto = posto;
		
		
	}
	
	public int getPosto() {
		return this.posto;
	}

}

