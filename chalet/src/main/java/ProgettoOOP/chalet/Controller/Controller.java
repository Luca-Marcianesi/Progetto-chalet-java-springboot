package ProgettoOOP.chalet.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.DateTimeException;
import java.util.*;
import ProgettoOOP.chalet.Model.Ristorante.Piatto;
import ProgettoOOP.chalet.Model.Liste.*;
import ProgettoOOP.chalet.Model.OtherClass.*;
import ProgettoOOP.chalet.Model.Server.Server;
import ProgettoOOP.chalet.Model.Eccezioni.*;
/**
 * @author LucaMarcianesi
 * Classe che gestisce le chiamate postman e risponde 
 *
 */
@RestController
public class Controller {
	
	private Chalet chalet;
	private boolean accesso;
	private String user ;
	
	/**
	 * Costruttore che crea lo chalet , 
	 * imposta l'accesso a false (ovvero non è stato fatto ancora il login)
	 * e quindi l'username dell'utente è vuoto
	 * 
	 */
	public Controller() {
		this.chalet = new Chalet();
		this.accesso = false;
		this.user =  "";
	}
	
	/**
	 * Permette ad un utente di creare un account cliente
	 * @param username Username per l'account
	 * @param password Password dell'account
	 * @return Esito della creazione
	 */
	@PostMapping("/creaAccount")
	public String test1(@RequestParam(name = "user")String username,@RequestParam(name = "pass")String password) {
		if(this.chalet.server.Crea_Account(username, password)) {
			return "Account creato";
			}
		else return "Username in uso";
	}
	
	/**
	 * Permette di effettuare il login al server dello chalet
	 * Se il login viene effettuato vengono aggionate le variabili user ed accesso
	 * Facendo una prenotazione in seguito nel nome della prenotazione verra inserito l'user
	 * @param username Usename dell'utente
	 * @param password Password dell'account
	 * @return Esito del login
	 */
	@PostMapping("/login")
	public String test2(@RequestParam(name = "user")String username,@RequestParam(name = "pass")String password) {
		if(this.chalet.server.Login(username, password)) {
			this.accesso = true;
			this.user = username;
			return ("Accesso effettuato");
			}
		else return ("Credenziali sbagliate");
	}
	
	/**
	 * Permette al proprietario di vedere la lista degli account
	 * @return La lista degli Account
	 */
	@GetMapping("/listaAccount")
	public Server test3() {
		if(this.chalet.proprietario(this.user))return this.chalet.server;
		else return null;
		
	}
	
	/**
	 * Permette al proprietario di creare un evento e lo aggiunge alla lista degli eventi
	 * Può generare un eccezione se la data non esiste
	 * @param nome Nome dell'evento
	 * @param posti Posti disponibili
	 * @param anno Anno in cui si svolge 
	 * @param mese Mese in cui si svolge 
	 * @param giorno Giorno in cui si svolge 
	 * @param prezzo Prezzo dell'evento
	 * @return Esito della creazione
	 */
	@PostMapping("/creaEvento")
	public String test4(@RequestParam(name = "nome",defaultValue = "billionaire")String nome,
			@RequestParam(name = "posti",defaultValue = "100")int posti ,
			@RequestParam(name = "anno",defaultValue = "2020")int anno, 
			@RequestParam(name = "mese",defaultValue = "12")int mese,
			@RequestParam(name = "giorno")int giorno,
			@RequestParam(name = "prezzo")float prezzo) throws DateTimeException{
	if(this.chalet.proprietario(user)) {
		Evento evento;
		try {
	evento = new Evento(nome,posti,anno,mese,giorno,prezzo);
	}
		catch(DateTimeException e){
			return ("Informazioni inesistenti");
			
		}
	this.chalet.listaEventi.aggiungi(evento);
	return ("Evento creato");
	}	
	return ("Non sei il proprietario");
	}
	
	/**
	 * Permette al proprietario di gestire la creare la spiaggia
	 * @param righe Numero di righe
	 * @param colonne Numero di colonne
	 * @return Risultato della creazione
	 * @throws NumberFormatException  se all'inserimento di codice e prezzo viene inserita una stringa
	 */
	@PostMapping("/creaSpiaggia")
	public String test5(@RequestParam(name = "righe",defaultValue = "10")int righe,@RequestParam(name = "colonne",defaultValue = "10")int colonne ) {
		
		if(righe < 0 && colonne < 0)return ("Impossibile");
		if(this.chalet.proprietario(this.user)) {
			this.chalet.creaSpiaggia(righe, colonne);
			return ("Spiaggia creata");
		}
		else return ("Non sei il proprietario");	
	}
	
	/**
	 * Permette di vedere le previsioni per i prossimi giorni
	 * @return Una lista di previsioni
	 */
	@GetMapping("/previsioni")
	public ListaOggettiConValore<Previsioni> test6() {
		UsaApi api = new UsaApi();
		return api.valorizzaListaPrevisioni();
	}
	
	/**
	 * Permette all'utente di prenotare qualsiasi cosa a eccezione degli ombrelloni all'interno
	 * dello chalet inserendo la cosa desiderata in richiesta
	 * Controlla in ogni lista dello chalet se la richiesta è presente
	 * @param richiesta Oggetto richiesto dall'utente
	 * @param nome Nome dell'utente
	 * @param posti Posti se ad esempio si prenota il tavolo altrimenti 1 Ã¨ il valore di default
	 * @return Esito della prenotaazione
	 * @throws NumberFormatException
	 */
	@PostMapping("/prenota")
	public String test7(@RequestParam(name = "richiesta")String richiesta,@RequestParam(name = "nome",defaultValue = "")String nome,@RequestParam(name = "posti",defaultValue = "1")int posti)throws EccezionePosto{
		if(posti<1) throw new EccezionePosto();
		if (this.accesso) nome = this.user;
		if(chalet.listaAttrezzatura.prenota(richiesta, nome)) return ("prenotazione riuscita");
		if(chalet.listaEventi.prenota(richiesta, nome)) return ("prenotazione riuscita");
		if(chalet.listaTavoli.prenota(richiesta, nome,posti)) return ("prenotazione riuscita");
		return ("prenotazione non riuscita");
				
			}
	
	/**
	 * Permette di prenotare un ombrellone
	 * @param posto Posto della spiaggia da prenotare
	 * @param nome Nome della persona che prenota
	 * @return Risultato della prenotazione
	 * @throws NumberFormatException Se all'inserimento di codice e prezzo viene inserita una stringa
	 */
	@PostMapping("/prenotaOmbrellone")
	public String test8(@RequestParam(name = "posto" )int posto,@RequestParam(name = "nome",defaultValue = "")String nome) throws EccezionePosto,EccezioneSpiaggia  {
		if(this.chalet.listaOmbrelloni == null) throw new EccezioneSpiaggia();
		if(posto<1)throw new EccezionePosto();
		if (this.accesso) nome = this.user;
		if(chalet.listaOmbrelloni.prenota(posto, nome)) return ("prenotazione riuscita");
		return ("prenotazione non riuscita");	
			}
	/**
	 * @return Restituisce un JSONObject con tutte le informazioni dello chalet
	 */
	@GetMapping("/chalet")
	public Chalet test9() {
		if(this.chalet.proprietario(this.user)) return this.chalet;
		else return null;
	}
	
	/**
	 * @return Restituisce la lista dei vini
	 */
	@GetMapping("/vini")
	public Vector<Piatto> test10() {
		return this.chalet.menuVini.getLista();
	}
	
	/**
	 * Permette al proprietario di modificare i prezzi del vino che di base sono fissati a zero
	 * @param codice Codice del vino visibile chiamando la lista dei vini
	 * @param prezzo Prezzo da inserire 
	 * @return String con la risposta all operazione
	 * @throws NumberFormatException se all'inserimento di codice e prezzo viene inserita una stringa
	 */
	@PostMapping("/cambiaVino")
	public String test11(@RequestParam(name = "codice")int codice,@RequestParam(name = "prezzo")float prezzo) throws EccezionePrezzo {
		if(prezzo<0) throw new EccezionePrezzo();
		this.chalet.menuVini.setPrezzo(codice, prezzo);
		return ("Vino aggiornato");	
		}
	
	/**
	 * Effettua il logout dal sever chalet
	 * @return ritorna l'esito
	 */
	@GetMapping("/logout")
	public String test12() {
		if(!this.accesso) return ("Non sei loggato");
		else {
			this.accesso = false;
			this.user = "";
			return ("Uscito con successo");
			}	
		}
	/*
	 * @return restituisce tutte le informazioni più importanti dei futuri eventi eventi
	 */
	@GetMapping("/visualizzaEventi")
	public ListaOggettiPrenotabili<Evento> test13(){
		return this.chalet.listaEventi;
	}
	
	/*
	 * @return restituisce graficcamente la rappresentazione degli ombrelloni in una spiaggia
	 */
	@GetMapping("/visualizzaSpiaggia")
	public String test14 (){
		return this.chalet.listaOmbrelloni.toString();
	}
	/*
	 * @return restituisce le informazioni meteo principali
	 */
}
