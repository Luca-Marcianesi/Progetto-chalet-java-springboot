package ProgettoOOP.chalet.Model.Eccezioni;

public class EccezioneSpiaggia extends Exception{
	private static final long serialVersionUID = 1L;
	public EccezioneSpiaggia() {
		super("Spiaggia non creata");
	}
}
