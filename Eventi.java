import java.util.Scanner;

public class Eventi {
	private String orario;
	private String descrizione;
	private int Max;
	private int Prenotati;
	Scanner input = new Scanner(System.in);
	
	public Eventi () {
		System.out.println( "Scrivi la descrizione dell'evento: " );
		this.descrizione = input.nextLine();
		
		System.out.println( "Inserisci l' orario dell'evento:" );
		this.orario = input.nextLine();
		
		System.out.println( "Quante persone può ospitare l'evento?" );
		this.Max = input.nextInt();
	}
	
	public void visualizza () {
		System.out.println( "\nDescrizione dell'evento: \t" + descrizione +
							"\nOrario dell'evento: \t\t" + orario +
							"\nPosti liberi: \t\t\t" + (Max-Prenotati) + '\n' );
	}
	
	public void ModificaOrario() {
		input.nextLine();
		System.out.println( "Modifica l' orario dell'evento:" );
		String orario = input.nextLine();
		this.orario = orario;
	}
	
	public void ModificaDes() {
		input.nextLine();
		System.out.println( "Inserisci la nuova descrizione: " );
		String descrizione = input.nextLine();
		this.descrizione = descrizione;
	}
	
	public void ModificaMax() {
		System.out.println( "Inserisci il nuovo numero massimo di persone" );
		int Max = input.nextInt();
		this.Max = Max;
	}
	
	public void Prenota () {
		System.out.println( "Per quante persone vuoi prenotare?" );
		int Num = input.nextInt();
		if ((Max-Prenotati)>Num) {
			Prenotati += Num; 
			System.out.println( "Prenotazione effettuata!" );
		}
		else System.out.println( "Prenotazione non effettuata.\nCi sono solo "  + (Max-Prenotati) + " posti liberi!" );
	}
}
