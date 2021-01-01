package ProgettoOOP.chalet.Model.Server;
/*
 * @author DiegoMignani
 * Classe che rappresenta un account e i suoi attributi 
 */
public class Account  {
	/*
	 * Username impostato dalla persona che possiede l'account
	 */
	private String username;
	/*
	 * Password impostata dal proprietario dell'account
	 */
	private String password;
	/*
	 * Costruttore che assegna le varie credenziali agli attributi
	 */
	public  Account( String username ,String password) {
		this.username = username;
		this.password = password;
	}
	/*
	 * Metodo utile per la verifica della password
	 * @return restituisce l'esito del controllo
	 */
	public boolean controllaPassword (String Password) {
		if(this.password == Password) return true;
		else return false;
	}
	/*
	 * Metodo che permette di immettere una nuova password controllando quella precedente 
	 */
	public boolean modificaPass(String Vecchia_Password, String Nuova_Password) {
		if (this.controllaPassword(Vecchia_Password)) {
			this.password = Nuova_Password;
			return true;
		}
		else return false;
		}
	/*
	 * Metodo che permette di immettere un nuovo username verificando la password 
	 */
	public boolean modificaUsername(String Password, String Nuovo_Username) {
		if (this.controllaPassword(Password)) {
			this.username = Nuovo_Username;
			return true;
			}
		else return false;
		}
	/*
	 * @return restituisce l'attributo username dell'oggetto Account
	 */
	public String getUsername() {
		return this.username;
		}
	/*
	 * @return restituisce l'attributo password dell'oggetto Account
	 */
	public String getPassword() {
		return this.password;
		}
	/*
	 * @return resituisce graficamente la descrizione dell'oggetto Account
	 */
	public String toString() {
		return(	 "User: " + username + "\n");
	}
	

	
	
}


