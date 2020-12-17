//@author DiegoMignani

package Server;


public class Account  {
	
	public  String nome;
	public String username;
	public  String password;
	
	//private int valore = 0 ;  //0 persona //1 proprietario
	
	
	public  Account( String nome,String username ,String password) {
		this.nome = nome;
		this.username = username;
		this.password = password;
	}
	
	private boolean controlla_Password (String Password) {
		if(this.password == Password) return true;
		else return false;
	}
	
	
	
	public boolean Modifica_Pass(String Vecchia_Password, String Nuova_Password) {
		if (this.controlla_Password(Vecchia_Password)) {
			this.password = Nuova_Password;
			return true;
		}
		else return false;
		}
	
	public boolean Modifica_Username(String Password, String Nuovo_Username) {
		if (this.controlla_Password(Password)) {
			this.username = Nuovo_Username;
			return true;
			}
		else return false;
		}
	
	
	public String getNome() {return nome;}
	
	public String getDescrizione() {return username;}
	
	public String getPassword() {return password;}
	
	//public float getValore() {return this.valore;}
	
	public String toString() {
		return(	"Nome: " + nome + "\t " + "User: " + username + "\n");
	}
	

	
	
}
