package ProgettoOOP.chalet.Model.Server;
//@author DiegoMignani


/**
 * @author DiegoMignani
 * Classe che rappresenta un account personale
 *
 */
public class Account  {
	private String username;
	private String password;
	
	/**
	 * Costruttore dell'acoount
	 * @param username nome del proprietario
	 * @param password codice di verifica
	 */
	public  Account( String username ,String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Controlla la password
	 * @param password string da controllare
	 * @return true se corrisponde altrimenti false
	 */
	public boolean controllaPassword (String password) {
		if(password.equalsIgnoreCase(this.password)) return true;
		else return false;
	}
	
	/**
	 * Permette di modificare la password
	 * @param vecchiaPassword password per il controllo
	 * @param nuovaPassword nuova password
	 * @return se la password è stata cambiata true altrimenti false
	 */
	public boolean modificaPass(String vecchiaPassword, String nuovaPassword) {
		if (this.controllaPassword(vecchiaPassword)) {
			this.password = nuovaPassword;
			return true;
		}
		else return false;
		}
	
	/**
	 * Modifica l'username
	 * @param password password dell'account
	 * @param nuovoUsername nuovo username
	 * @return true se l' username è stato cambiato, altrimenti false
	 */
	public boolean modificaUsername(String password, String nuovoUsername) {
		if (this.controllaPassword(password)) {
			this.username = nuovoUsername;
			return true;
			}
		else return false;
		}
	
	/**
	 * @return ritorna l username
	 */
	public String getUsername() {
		return this.username;
		}
	
	/**
	 * @return ritorna la password
	 */
	public String getPassword() {
		return this.password;
		}
	
	/**
	 *@return ritorna in stringa la classe 
	 */
	public String toString() {
		return(	 "User: " + username + "\n");
	}	
}
