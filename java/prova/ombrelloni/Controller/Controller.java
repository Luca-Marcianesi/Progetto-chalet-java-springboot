package prova.ombrelloni.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Liste.*;
import OtherClass.*;
import Server.Server;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import prova.ombrelloni.Model.*;


@RestController
public class Controller {
	
	private Chalet chalet = new Chalet();
	private boolean accesso = false;
	private String user = "";
	
	@PostMapping("/creaAccount")
	public String test1(@RequestParam(name = "user")String username,@RequestParam(name = "pass")String password) {
		if(this.chalet.server.Crea_Account( username, password)) {
			return "Account creato";
			}
		else return "Username già presente";
	}
	
	@PostMapping("/login")
	public String test2(@RequestParam(name = "user")String user,@RequestParam(name = "pass")String password) {
		if(this.chalet.server.Login(user, password)) {
			this.accesso = true;
			this.user = user;
			return ("Accesso effettualto");}
		else return ("Credenziali sbagliate");
	}
	
	@GetMapping("/listaAccount")
	public Server test3() {
		if(this.chalet.proprietario(this.user))return this.chalet.server;
		else return null;
	}
	
	@PostMapping("/creaEvento")
	public String test4(@RequestParam(name = "nome",defaultValue = "billionaire")String nome,@RequestParam(name = "posti",defaultValue = "luca")int posti ,@RequestParam(name = "anno",defaultValue = "2020")int anno, @RequestParam(name = "mese",defaultValue = "12")int mese, @RequestParam(name = "giorno")int giorno) {
	if(this.chalet.proprietario(user)) {
	Eventi evento = new Eventi(nome,posti,anno,mese,giorno);
	this.chalet.listaEventi.aggiungi(evento);
	return ("Evento creato");
	}	
	return ("Non sei il proprietario");
	}
	
	@PostMapping("/creaSpiaggia")
	public String test5(@RequestParam(name = "righe",defaultValue = "10")int righe,@RequestParam(name = "colonne",defaultValue = "10")int colonne ) {
		if(this.chalet.proprietario(this.user)) {
			this.chalet.creaSpiaggia(righe, colonne);
			return ("Spiaggia creata");
		}
		else return ("Non sei il proprietario");
	}
	
	
	@GetMapping("/previsioni")
	public Lista<Previsioni> test6() {
		UsaApi api = new UsaApi();
		api.valorizzaListaPrevisioni();
		return api.lista;
	}
	
	@PostMapping("/prenota")
	public String test7(@RequestParam(name = "richiesta")String richiesta,@RequestParam(name = "nome")String nome) {
		if (this.accesso) nome = this.user;
		if(chalet.listaAttrezzatura.prenota(richiesta, nome)) return ("prenotazione riuscita");
		if(chalet.listaEventi.prenota(richiesta, nome)) return ("prenotazione riuscita");
		if(chalet.listaTavoli.prenota(richiesta, nome)) return ("prenotazione riuscita");
		return ("prenotazione non riuscita");
				
			}
	
	@PostMapping("/prenotaOmbrellone")
	public String test8(@RequestParam(name = "posto")int posto,@RequestParam(name = "nome")String nome) {
		if (this.accesso) nome = this.user;
		if(chalet.listaOmbrelloni.prenota(posto, nome)) return ("prenotazione riuscita");
		return ("prenotazione non riuscita");	
			}
	@GetMapping("/chalet")
	public Chalet test9() {
		if(this.chalet.proprietario(this.user)) return this.chalet;
		else return null;
	}
		}
	
	
	
	
	
	
	
	
	

	
	

	
	

