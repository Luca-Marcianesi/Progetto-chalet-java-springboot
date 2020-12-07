//@author DiegoMignani

public class Attrezzatura{
	
	private String tipo;
	private float prezzo;
	private int max;
	
	public Attrezzatura(String tipo, float prezzo, int max) {
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.max = max;
	}
	public void prenota(int num) {max-=num;}
	public void eliminaPrenota(int num) {max+=num;}
	public String getTipo() {return tipo;}
	public float getPrezzo() {return prezzo;}
	public int getUnità() {return max;}
}
