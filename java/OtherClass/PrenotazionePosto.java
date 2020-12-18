package OtherClass;

public class PrenotazionePosto extends Prenotazione{
	
	private int posto;
	
	public PrenotazionePosto(String nome,int posto) {
		super(nome);
		this.posto = posto;	
	}
	
	public String toString() {
		return (" Numero prenotazione " + super.numeroPrenotazione + " Nome " + super.nome + "Posizione" + this.posto);
	}
	

}
