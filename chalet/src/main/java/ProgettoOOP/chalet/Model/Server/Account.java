package ProgettoOOP.chalet.Model.Server;
//@author DiegoMignani


public class Account  {
	private String username;
	private String password;
	
	public  Account( String username ,String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean controllaPassword (String Password) {
		if(this.password == Password) return true;
		else return false;
	}
	
	public boolean modificaPass(String Vecchia_Password, String Nuova_Password) {
		if (this.controllaPassword(Vecchia_Password)) {
			this.password = Nuova_Password;
			return true;
		}
		else return false;
		}
	
	public boolean modificaUsername(String Password, String Nuovo_Username) {
		if (this.controllaPassword(Password)) {
			this.username = Nuovo_Username;
			return true;
			}
		else return false;
		}
	
	public String getUsername() {
		return this.username;
		}
	
	public String getPassword() {
		return this.password;
		}
	
	public String toString() {
		return(	 "User: " + username + "\n");
	}
	

	
	
}


