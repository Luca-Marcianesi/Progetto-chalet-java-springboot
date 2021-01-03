package ProgettoOOP.chalet.Model.Eccezioni;

public class EccezionePrezzo extends Exception{
	private static final long serialVersionUID = 1L;
	public EccezionePrezzo() {
		super("Prezzo non accettabile");
	}

}
