package Liste;
//@author  LucaMarcianesi

import java.util.Vector;

public class Lista<T> {
	
	public  Vector <T> lista = new Vector <T>() ;
	
	public   void aggiungi(T oggetto) {
		this.lista.add(oggetto);
	}
	
	
	public void modifica(int a, T nuovo_oggetto) {
		this.lista.set(a, nuovo_oggetto);
	}

	public void elimina(int posizione) {
		this.lista.remove(posizione);
}
	public String toString() {
		String ritorno = "";
		for(T Elemento : this.lista) ritorno = (ritorno +Elemento.toString() + "\n");
		return ritorno;
	}
}

