package fr.formation.boot.banque.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.boot.banque.metier.BanqueException;
import fr.formation.boot.banque.metier.BanqueService;
import fr.formation.boot.banque.persistance.entite.Client;
import fr.formation.boot.banque.persistance.entite.Compte;
import fr.formation.boot.banque.rest.bo.Auth;
import fr.formation.boot.banque.rest.bo.Virement;

@RestController
public class BanqueController {

	@Autowired
	private BanqueService banqueService;
	
	@PostMapping(
		value = "/client/auth",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Client> authentification(@RequestBody Auth auth){
		try {
			Client client = banqueService.authentifier(auth.getIdentifiant(), auth.getMotDePasse());
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}catch(BanqueException e) {
			e.printStackTrace();
			return new ResponseEntity<Client>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping(
		value = "/comptes/{idclient}",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<Compte>> comptesClient(@PathVariable("idclient") long idClient){
		try {
			List<Compte> listeDeComptes = banqueService.lesComptes(idClient);
			return new ResponseEntity<List<Compte>> (listeDeComptes, HttpStatus.OK);
		
		}catch(BanqueException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
			//return new ResponseEntity<List<Compte>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(
		value = "/virement",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<String> virement(@RequestBody Virement virement){
		try {
			banqueService.virementEntreComptes(
				virement.getNumeroADebiter(), 
				virement.getNumeroACrediter(), 
				virement.getMontant()
			);
			return new ResponseEntity<String>("Virement OK", HttpStatus.ACCEPTED);
		}catch(BanqueException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
