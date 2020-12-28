package Server;

import java.util.Vector;

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
		
	/**
	 * Funzione che permette di fare il login tramite username e password
	 * Controlla se l username è presente nel server poi controlla se la password corrisponde 
	 * all'username
	 * @param username String con l'username dell'utente
	 * @param password String con la password dell'utente
	 * @return ritorna true se l'username esiste e la password ad esso associata corrisponde
	 */
	public boolean Login (String username , String password) {
		if (this.controlla(username)) {
			if(this.controlla(username, password)){ 
				return true;
				}
			else return false;
		}
		else return false;
		
}
	
	/**
	 * Permette di creare un account ed aggiungerlo alla lista degli account 
	 * se username non è già in uso
	 * @param username String con l'username del nuovo account
	 * @param password String  con la password del nuovo account
	 * @return boolean true se l'account è stato creato con successo false altrimenti
	 */
	public boolean Crea_Account (String username , String password) {
		if (!this.controlla(username)){
			Account nuovo = new Account(username , password);
				this.lista.add(nuovo);
				return true;
				}
		else  return false;
		
		}
	
	/**
	 *Trasforma la lista degli account in String
	 */
	public String toString() {
		String ritorno = "";
		for(Account Elemento : this.lista) ritorno = (ritorno +Elemento.toString() + "\n");
		return ritorno;
	}
	
	/**
	 * Controlla  se è presente un account con tale username
	 * @param username String da controllare
	 * @return  boolean true se l'username è presente false altrimenti
	 */
	private boolean controlla(String username) {
		
		for(Account Utente : this.lista)  {
			if(username.equalsIgnoreCase(Utente.getUsername())) {
				return true;
			}
		}
		return false;
			}
	
	/**
	 * Ritorna la lista degli Account
	 * @return vector il vettore che contiene gli account
	 */
	public Vector <Account> getLista(){
		return this.lista;
	}
	
	/**
	 * Controlla se la password corrisponde alla password del account di nome "username"
	 * @param username String con l'username dell'account
	 * @param password String da controllare la corrispondenza
	 * @return boolean true se username e password corrispondono allo stesso account 
	 */
	private boolean controlla(String username , String password) {
		
		for(Account Utente : this.lista)  
			if(username.equalsIgnoreCase(Utente.getUsername()) &&  password.equalsIgnoreCase(Utente.getPassword()) ) return true;
		return false;
			}
	
	public void	aggiungiAccount(Account account) {
		this.lista.add(account);
	}
	
	/*
	public void salvaFile() {
		try {
			ObjectOutputStream file_output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("prova.json")));
			file_output.writeObject(this.lista);
			
			file_output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void leggiLocale(/*String nome_file) {
		String nome_file = "listaa.json";
		try {
			ObjectInputStream file_input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nome_file)));
			
			JSONObject o	 = (JSONObject) file_input.readObject();
			JSONArray lista = (JSONArray) o.get("lista");
			
			for(Object acc : lista) {
				if(acc instanceof JSONObject) {
					JSONObject o1 = (JSONObject ) o;
					String user  = (String)o1.get("username");;
					String pass = (String)o1.get("password");;
					Account a = new Account(user,pass);
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
	*/
}
