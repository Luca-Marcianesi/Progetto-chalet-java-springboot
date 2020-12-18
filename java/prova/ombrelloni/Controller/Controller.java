package prova.ombrelloni.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Liste.*;
import OtherClass.*;
import Server.Server;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import prova.ombrelloni.Model.*;


@RestController
public class Controller {
	
	Server server = new Server();
	ListaOggettiPrenotabili<Eventi> eventi = new ListaOggettiPrenotabili<Eventi>();
	UsaApi a = new UsaApi();
	
	@PostMapping("/aggiungi")
	public String test1(@RequestParam(name = "name")String nome,@RequestParam(name = "user")String username,@RequestParam(name = "pass")String password) {
		
		if(server.Crea_Account(nome, username, password)) {
			return "Account creato";
			}
		else return "Username già presente";
	}
	
	@GetMapping("/lista")
	public Server test2() {
		return this.server;
	}
	
	@GetMapping("/previsioni")
	public Lista<Previsioni> test3(@RequestParam(name = "param1",defaultValue = "luca")String nome) {
		UsaApi a = new UsaApi();
		return a.lista;
	}
	
	@PostMapping("/crea")
	public void test4(@RequestParam(name = "max", defaultValue = "100")int max , @RequestParam(name = "nome",defaultValue = "Billionaire")String nome,@RequestParam(name = "mese")int mese , @RequestParam(name = "giorno")int giorno) {
		Eventi evento = new Eventi(max,nome,mese,giorno);
		eventi.aggiungi(evento);
		
	}
	
	@PostMapping("/prenota")
	public String test4(@RequestParam(name = "nome")String nome , @RequestParam(name = "nomeP")String nomePersona) {
		a.letturaOnline();
		if(eventi.prenota(nome, nomePersona)) return ("Prenotazione effettuata");
		else return ("Prenotazione non riuscita");
	}
	
	@GetMapping("/listaP")
	public 	ListaOggettiPrenotabili<Eventi> test5() {
		return this.eventi;
		
	}
	
	@GetMapping("/posti")
	public 	Integer test6(@RequestParam(name = "evento")String nome ) {
		for(Eventi eve : this.eventi.lista) {
			if(nome.equalsIgnoreCase(eve.getTipo())) return eve.getDisponibili();	
		}
		
		return 0;
		
	}
}
	
	

