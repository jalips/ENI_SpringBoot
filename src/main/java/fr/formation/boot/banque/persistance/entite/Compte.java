package fr.formation.boot.banque.persistance.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
public class Compte {

	@Id
	@Column(name = "numero")
	private long numero;
	
	@Column(name = "solde", precision= 15, scale = 2)
	private double solde;
	
	@ManyToOne(targetEntity = Client.class)
	@JoinColumn(name = "idclient")
	private Client client;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
}
