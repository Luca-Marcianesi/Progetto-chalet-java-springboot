package ProgettoOOP.chalet.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.DateTimeException;
import java.lang.NumberFormatException;
import java.util.*;
import ProgettoOOP.chalet.Model.Ristorante.Piatto;
import ProgettoOOP.chalet.Model.Liste.ListaOggettiConValore;
import ProgettoOOP.chalet.Model.OtherClass.*;
import ProgettoOOP.chalet.Model.Server.Server;
//import ProgettoOPP.chalet.Model.Eccezioni.*;


@RestController
public class Controller {
	
	private Chalet chalet;
	private boolean accesso;
	private String user ;
	
	public Controller() {
		this.chalet = new Chalet();
		this.accesso = false;
		this.user =  "";
	}
	
	@PostMapping("/creaAccount")
	public String test1(@RequestParam(name = "user")String username,@RequestParam(name = "pass")String password) {
		if(this.chalet.server.Crea_Account(username, password)) {
			return "Account creato";
			}
		else return "Username in uso";
	}
	
	@PostMapping("/login")
	public String test2(@RequestParam(name = "user")String username,@RequestParam(name = "pass")String password) {
		if(this.chalet.server.Login(username, password)) {
			this.accesso = true;
			this.user = username;
			return ("Accesso effettuato");
			}
		else return ("Credenziali sbagliate");
	}
	
	@GetMapping("/listaAccount")
	public Server test3() {
		if(this.chalet.proprietario(this.user))return this.chalet.server;
		else return null;
		
	}
	
	@PostMapping("/creaEvento")
	public String test4(@RequestParam(name = "nome",defaultValue = "billionaire")String nome,
			@RequestParam(name = "posti",defaultValue = "100")int posti ,
			@RequestParam(name = "anno",defaultValue = "2020")int anno, 
			@RequestParam(name = "mese",defaultValue = "12")int mese,
			@RequestParam(name = "giorno")int giorno,
			@RequestParam(name = "prezzo")float prezzo) {
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
	
	@PostMapping("/creaSpiaggia")
	public String test5(@RequestParam(name = "righe",defaultValue = "10")int righe,@RequestParam(name = "colonne",defaultValue = "10")int colonne ) throws NumberFormatException {
		
		if(righe < 0 && colonne < 0)return ("Impossibile");
		if(this.chalet.proprietario(this.user)) {
			this.chalet.creaSpiaggia(righe, colonne);
			return ("Spiaggia creata");
		}
		else return ("Non sei il proprietario");	
	}
	
	@GetMapping("/previsioni")
	public ListaOggettiConValore<Previsioni> test6() {
		UsaApi api = new UsaApi();
		return api.valorizzaListaPrevisioni();
	}
	
	@PostMapping("/prenota")
	public String test7(@RequestParam(name = "richiesta")String richiesta,@RequestParam(name = "nome",defaultValue = "")String nome,@RequestParam(name = "posti",defaultValue = "1")int posti) throws NumberFormatException{
		if(posti<1) return ("prenotazione non riuscita");
		if (this.accesso) nome = this.user;
		if(chalet.listaAttrezzatura.prenota(richiesta, nome)) return ("prenotazione riuscita");
		if(chalet.listaEventi.prenota(richiesta, nome)) return ("prenotazione riuscita");
		if(chalet.listaTavoli.prenota(richiesta, nome,posti)) return ("prenotazione riuscita");
		return ("prenotazione non riuscita");
				
			}
	
	@PostMapping("/prenotaOmbrellone")
	public String test8(@RequestParam(name = "posto")int posto,@RequestParam(name = "nome")String nome) throws NumberFormatException {
		if (this.accesso) nome = this.user;
		if(chalet.listaOmbrelloni.prenota(posto, nome)) return ("prenotazione riuscita");
		return ("prenotazione non riuscita");	
			}
	@GetMapping("/chalet")
	public Chalet test9() {
		if(this.chalet.proprietario(this.user)) return this.chalet;
		else return null;
	}
	
	@GetMapping("/vini")
	public Vector<Piatto> test10() {
		return this.chalet.menuVini.getLista();
	}
	
	@PostMapping("/cambiaVino")
	public String test11(@RequestParam(name = "codice")int codice,@RequestParam(name = "prezzo")float prezzo) throws NumberFormatException{
		if(prezzo<0)return("Prezzo non consentito");
		this.chalet.menuVini.setPrezzo(codice, prezzo);
		return ("Vino aggiornato");
			
		}
}
	
	
	
	
	
	
	
	
	

	
	

	
	


