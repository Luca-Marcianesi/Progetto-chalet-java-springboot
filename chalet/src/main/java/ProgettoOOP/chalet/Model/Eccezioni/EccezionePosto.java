package ProgettoOOP.chalet.Model.Eccezioni;

public class EccezionePosto extends Exception {
	private static final long serialVersionUID = 1L;
	public EccezionePosto() {
		super("Posto non accetabile");
	}
}
