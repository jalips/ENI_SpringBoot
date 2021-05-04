package fr.formation.boot.banque.persistance.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nom", length= 100, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length= 50, nullable = false)
	private String prenom;
	
	@Column(name = "adresse", length= 200, nullable = false)
	private String adresse;
	
	@Column(name = "codepostal", length= 30, nullable = false)
	private String codePostal;
	
	@Column(name = "ville", length= 200, nullable = false)
	private String ville;
	
	@Column(name = "motdepasse", length= 100, nullable = false)
	private String motDePasse;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	
	
}
