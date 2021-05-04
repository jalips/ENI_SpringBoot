package fr.formation.boot.banque.rest.bo;

public class Virement {

	private long numeroADebiter;
	private long numeroACrediter;
	private double montant;
	
	public long getNumeroADebiter() {
		return numeroADebiter;
	}
	
	public void setNumeroADebiter(long numeroADebiter) {
		this.numeroADebiter = numeroADebiter;
	}
	
	public long getNumeroACrediter() {
		return numeroACrediter;
	}
	
	public void setNumeroACrediter(long numeroACrediter) {
		this.numeroACrediter = numeroACrediter;
	}
	
	public double getMontant() {
		return montant;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	
}
