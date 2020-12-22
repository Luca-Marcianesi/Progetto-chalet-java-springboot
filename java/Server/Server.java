package Server;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * @author LucaMarcianesi
 * @author   DiegoMignani
 * Classe che rappresenta il server che gestisce gli account
 */
public class Server {
	
	/**
	 * Vector lista degli account che sono stati creati
	 */
	private Vector <Account> lista = new  Vector<Account>();
	
	//public Server() {this.leggiLocale();}
	
	/**
	 * Funzione che permette di fare il login tramite username e password
	 * Controlla se l username è presente nel server poi controlla se la password corrisponde 
	 * all'username
	 * @param username String con l'username dell'utente
	 * @param password String con la password dell'utente
	 * @return ritorna true se l'username esiste e la password ad esso associata corrisponde
	 */
	public boolean Login (String username , String password) {
		if (!this.controlla(username)) {
			if(this.controlla(username, password)){ 
				System.out.println("Login effettuato");
				return true;
				}
			else {
				System.out.println("Username o password errate!");
				return false;
			}
		}
		else {
		System.out.println("Informazioni errate!");
		return false;
		}
}
	
	public boolean Crea_Account (String nome , String username , String password) {
		Account nuovo = new Account(nome , username , password);
		if (this.controlla(username)){
			if(this.lista.size()==0) {
				this.lista.add(nuovo);
				nuovo.setPermessi(true);
			}
			else {
				this.lista.add(nuovo);
			}
			return true;
		}
		else  return false;
	}
	
	/**
	 *Trasforma la lista degli account in string
	 */
	public String toString() {
		String ritorno = "";
		for(Account Elemento : this.lista) ritorno = (ritorno +Elemento.toString() + "\n");
		return ritorno;
	}
	
	
	
	/**
	 * Controlla  se è presente un account con tale username
	 * @param username String da controllare
	 * @return true se l'username è presente
	 */
	private boolean controlla(String username) {
		for(Account Utente : this.lista)  if(Utente.getUsername() == username) return false;
		return true;
	}
	
	/**
	 * Controlla se la password corrisponde alla password del account di nome "username"
	 * @param username username dell'account
	 * @param password String da controllare la corrispondenza
	 * @return true se username e password corrispondono allo stesso account
	 */
	private boolean controlla(String username , String password) {
		
		for(Account Utente : this.lista)  
			if(Utente.getUsername() == username && Utente.getPassword() == password ) return true;
		return false;
			}

	public void salvaFile() {
		try {
			ObjectOutputStream file_output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("prova.json")));
			file_output.writeObject(this.lista);
			
			file_output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void leggiLocale(/*String nome_file*/) {
		String nome_file = "listaa.json";
		try {
			ObjectInputStream file_input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nome_file)));
			
			JSONObject o	 = (JSONObject) file_input.readObject();
			JSONArray lista = (JSONArray) o.get("lista");
			
			for(Object acc : lista) {
				if(acc instanceof JSONObject) {
					JSONObject o1 = (JSONObject ) o;
					String nome = (String)o1.get("nome");
					String user  = (String)o1.get("username");;
					String pass = (String)o1.get("password");;
					Account a = new Account(nome,user,pass);
					this.lista.add(a);
				}
			}
			
			file_input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
