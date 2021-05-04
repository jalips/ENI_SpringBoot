package fr.formation.boot.banque.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.boot.banque.persistance.entite.Client;
import fr.formation.boot.banque.persistance.entite.Compte;

@Repository("compteDAO")
public class JpaCompteDAO implements CompteDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void ajouterCompte(Compte compte) {
		em.persist(compte);
	}

	@Override
	public void modifierCompte(Compte compte) {
		em.merge(compte);
	}

	@Override
	public Compte rechercherCompteParNumero(long numero) {
		return em.find(Compte.class, numero);
	}

	@Override
	public List<Compte> rechercherComptesClient(Client client) {
		Query q = em.createQuery("from Compte as c where c.client = :leClient");
		q.setParameter("leClient", client);
		return q.getResultList();
	}

}
