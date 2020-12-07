//@author DiegoMignani

import java.util.Vector;

public class Deposito{
	private Vector<Attrezzatura> lista = new Vector<Attrezzatura>();
	
	public Deposito(Attrezzatura A){
		lista.add(A);
	}
	
	public boolean prenota(String tipo,int num){
		boolean flag = false;
		int k = 0,i=-1;
		for (Attrezzatura x : lista ) { 
			if(x.getTipo()==tipo) {flag = true; k = i;}
			i++; 
		}
		if(flag && num<lista.get(k).getUnità()) {
			System.out.println("Prenotazione effettuata! Al costo di" + (lista.get(k).getPrezzo() * num)+" €.");
			lista.get(k).prenota(num);
			return true;
		}
		else {
			System.out.println("Prenotazione non effettuata!");
			System.out.println( "I " + num + ' ' + tipo +"da lei richiesti sono esauriti o non esistono,\nattualmente ci sono:");
			return false;
		}	
	}
	
	public boolean eliminaPrenota(String tipo, int num){
		boolean flag = false;
		int k = 0,i=-1;
		for (Attrezzatura x : lista ) { 
			if(x.getTipo()==tipo) {flag = true; k = i;}
			i++; 
		}
		if(flag) {
			System.out.println("Prenotazione rimossa!");
			lista.get(k).eliminaPrenota(num);
			return true;
		}
		else {
			System.out.println("Rimozione non effettuata!");
			System.out.println( "I " + num + ' ' + tipo +" non esistono o non sono stati prenotati,\nattualmente ci sono:");
			return false;
		}		
	}
	
	
}
