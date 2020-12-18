//@author  LucaMarcianesi

package Informazioni;
import java.util.Vector;

public   class Informazioni {
	
	private Vector <String> lista_informazioni = new Vector <String>() ;
	
	public void aggiungi_valutazione(String a) {
		this.lista_informazioni.add(a);
	}

}
