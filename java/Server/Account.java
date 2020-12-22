package Server;
/*
 * @author DiegoMignani
 * Classe che rappresenta un account e i suoi attributi 
 */
public class Account {
	/*
	 * Nome della persona che possiede questo account
	 */
	public  String nome;
	/*
	 * Username impostato dalla persona che possiede l'account
	 */
	public String username;
	/*
	 * Password impostata dal proprietario dell'account
	 */
	public  String password;
	/*
	 * Costruttore che assegna le varie credenziali agli attributi
	 */
	public  Account(String nome,String username ,String password) {
		this.nome = nome;
		this.username = username;
		this.password = password;
	}
	/*
	 * Metodo utile per la verifica della password
	 */
	private boolean controlla_Password (String Password) {
		if(this.password == Password) return true;
		else return false;
	}
	/*
	 * Metodo che permette di immettere una nuova password controllando quella precedente 
	 */
	public boolean Modifica_Pass(String Vecchia_Password, String Nuova_Password) {
		if (this.controlla_Password(Vecchia_Password)) {
			this.password = Nuova_Password;
			return true;
		}
		else return false;
	}
	/*
	 * Metodo che permette di immettere un nuovo username verificando la password 
	 */
	public boolean Modifica_Username(String Password, String Nuovo_Username) {
		if (this.controlla_Password(Password)) {
			this.username = Nuovo_Username;
			return true;
		}
		else return false;
	}
	/*
	 * @return restituisce l'attributo nome dell'oggetto Account
	 */
	public String getNome() {
		return this.nome;
	}
	/*
	 * @return restituisce l'attributo username dell'oggetto Account
	 * 
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
		return(	"Nome: " + nome + "\t " + "User: " + username + "\n");
	}
	

	
	
}
