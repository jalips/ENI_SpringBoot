package fr.formation.boot.banque.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.boot.banque.persistance.entite.Client;

@Repository("clientDAO")
public class JpaClientDAO implements ClientDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void ajouterClient(Client client) {
		// TODO Auto-generated method stub
		em.persist(client);
	}

	@Override
	public void modifierClient(Client client) {
		// TODO Auto-generated method stub
		em.merge(client);
		
	}

	@Override
	public Client rechercherClientParId(long id) {
		// TODO Auto-generated method stub
		return em.find(Client.class, id);
	}

	@Override
	public List<Client> rechercherTousLesClients() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Client");
		return q.getResultList();
	}

}
