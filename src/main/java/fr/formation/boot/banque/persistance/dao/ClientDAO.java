package fr.formation.boot.banque.persistance.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.formation.boot.banque.persistance.entite.Client;

public interface ClientDAO {

	@Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
	public abstract void ajouterClient(Client client);
	
	@Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
	public abstract void modifierClient(Client client);
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = Exception.class)
	public abstract Client rechercherClientParId(long id);
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = Exception.class)
	public abstract List<Client> rechercherTousLesClients();
	
}
