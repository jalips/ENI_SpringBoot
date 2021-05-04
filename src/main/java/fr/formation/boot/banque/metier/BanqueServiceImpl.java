package fr.formation.boot.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.formation.boot.banque.persistance.dao.ClientDAO;
import fr.formation.boot.banque.persistance.dao.CompteDAO;
import fr.formation.boot.banque.persistance.entite.Client;
import fr.formation.boot.banque.persistance.entite.Compte;

@Component("banqueService")
public class BanqueServiceImpl implements BanqueService {
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Autowired
	private CompteDAO compteDAO;

	@Override
	public Client authentifier(long idClient, String motDePasse) throws BanqueException {
		try {
			Client client = clientDAO.rechercherClientParId(idClient);
			if(motDePasse != null && motDePasse.equals(client.getMotDePasse())) {
				return client;
			}else {
				throw new Exception();
			}
		}catch(Exception e){
			throw new BanqueException("Erreur d'authentification.");
		}
	}

	@Override
	public List<Compte> lesComptes(long idClient) throws BanqueException {
		try {
			Client client = clientDAO.rechercherClientParId(idClient);
			return compteDAO.rechercherComptesClient(client);
			
		}catch(Exception e) {
			throw new BanqueException("Erreur récup liste comptes");
		}
	}

	@Override
	public void virementEntreComptes(long numeroCompteADebiter, long numeroCompteACrediter, double montant)
			throws BanqueException {
		try {
			Compte aDebiter = compteDAO.rechercherCompteParNumero(numeroCompteADebiter);
			Compte aCrediter = compteDAO.rechercherCompteParNumero(numeroCompteACrediter);
			
			aDebiter.setSolde(aDebiter.getSolde() - montant);
			aCrediter.setSolde(aCrediter.getSolde() + montant);
			
			compteDAO.modifierCompte(aDebiter);
			compteDAO.modifierCompte(aCrediter);
		
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de l'enregistrement du virement.");
		}

	}

}
