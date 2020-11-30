
public class Account extends server implements OggettiListabile{
	private String Username;
	private String Password;
	private String Nome;
	private String Cognome;
	
	public String toString() {
		return(	"Nome:\t\t" + Nome + "\n" + "Cognome:\t" + Cognome + "\n" + "User:\t\t" + Username + "\n");
	}
	
	public boolean Modifica_Pass(String Vecchia_Password, String Nuova_Password) {
		if (this.controlla_Password(Password)) {
			this.Password = Nuova_Password;
			System.out.println("Password modificata correttamenete!");
			return true;
		}
		else {
			System.out.println("La sua vecchia Password non è corretta, impossibile modificarla con una nuova!");
			return true;
		}
	}
	
	public String getUsername() {return Username;}
	
	public String getPassword() {return Password;}
	
	public boolean Modifica_Username(String Password, String Nuovo_Username) {
		if (this.controlla_Password(Password)) {
			this.Username = Nuovo_Username;
			System.out.println("Username modificato correttamenete!");
			return true;
		}
		else {
			System.out.println("La sua vecchia Password non è corretta, impossibile modificare il nuovo Username!");
			return true;
		}
	}
	
	private boolean controlla_Password (String Password) {
		if(this.Password == Password) return true;
		else return false;
	}
}
