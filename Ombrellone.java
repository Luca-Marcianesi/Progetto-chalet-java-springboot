
//@author DiegoMignani

public class Ombrellone {
	private boolean libero = true;
	private int sdraio = 0;
	private int lettino = 0;
	private float prezzoOmbrellone;
	private float prezzoSdraio;
	private float prezzoLettino;

	public void setPrezzoOmbrellone(float prezzoOmbrellone) {this.prezzoOmbrellone = prezzoOmbrellone;};
	
	public void setPrezzoSdraio(float prezzoSdraio) {this.prezzoSdraio = prezzoSdraio;};
	
	public void setPrezzoLettino(float prezzoLettino) {this.prezzoLettino = prezzoLettino;};
	
	public boolean getLibero() {return libero;}
	
	public void setLibero(boolean libero) {this.libero = libero;}
	
	public void setSdraio(int sdraio) {this.sdraio = sdraio;}
	
	public void setLettino(int lettino) {this.lettino = lettino;}
	
	public float getPrezzoTotale() {
		return (sdraio*prezzoSdraio + lettino * prezzoLettino + prezzoOmbrellone);
	}
}
