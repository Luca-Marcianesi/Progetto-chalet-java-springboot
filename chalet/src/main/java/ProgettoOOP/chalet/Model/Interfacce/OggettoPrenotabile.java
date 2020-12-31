package ProgettoOOP.chalet.Model.Interfacce;

/**
 * @author DiegoMignani
 * @author LucaMarcianesi
 * 
 *Interfaccia per gli oggetti che sono prenotabili
 */

public interface OggettoPrenotabile  {
		public boolean getStato();
		
		public void setStato(boolean stato);
		
		public String getTipo();
		
		public  void aggiungiPrenotazione(String nome);
		}
