package fr.formation.boot.banque.metier;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.boot.banque.persistance.entite.Client;
import fr.formation.boot.banque.persistance.entite.Compte;

public interface BanqueService {

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = BanqueException.class)
	public abstract Client authentifier(long idClient, String motDePasse) 
		throws BanqueException;
	
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = BanqueException.class)
	public abstract List<Compte> lesComptes(long idClient) 
		throws BanqueException;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = BanqueException.class)
	public abstract void virementEntreComptes(
		long numeroCompteADebiter, long numeroCompteACrediter, double montant
	) throws BanqueException;
	
}
