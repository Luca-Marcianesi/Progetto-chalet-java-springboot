//@author  LucaMarcianesi & DiegoMignani

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

public class Server {
	
	private Vector <Account> lista = new  Vector<Account>();
	
	public Server() {
		//this.leggiLocale();
	}
	
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
		if (this.controlla( username)){
				this.lista.add(nuovo);
				return true;
				}
		else  return false;
		
		}
	
	public String toString() {
		String ritorno = "";
		for(Account Elemento : this.lista) ritorno = (ritorno +Elemento.toString() + "\n");
		return ritorno;
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
	
	private boolean controlla(String username) {
		
		for(Account Utente : this.lista)  if(Utente.getDescrizione() == username) return false;
		return true;
			}
	
	private boolean controlla(String username , String password) {
		
		for(Account Utente : this.lista)  
			if(Utente.getDescrizione() == username && Utente.getPassword() == password ) return true;
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
}